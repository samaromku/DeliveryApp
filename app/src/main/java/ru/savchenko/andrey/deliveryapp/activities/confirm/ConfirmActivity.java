package ru.savchenko.andrey.deliveryapp.activities.confirm;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.base.BaseActivity;
import ru.savchenko.andrey.deliveryapp.di.ComponentManager;
import ru.savchenko.andrey.deliveryapp.entities.Data;
import ru.savchenko.andrey.deliveryapp.entities.Message;
import ru.savchenko.andrey.deliveryapp.network.FirebaseService;

import static ru.savchenko.andrey.deliveryapp.storage.Const.NAME;
import static ru.savchenko.andrey.deliveryapp.storage.Const.PHONE;

/**
 * Created by Andrey on 18.12.2017.
 */

public class ConfirmActivity extends BaseActivity {
    private static final String TAG = "ConfirmActivity";
    @Inject
    FirebaseService service;
    @BindView(R.id.btnRetry)
    Button btnRetry;
    @BindView(R.id.btnConfirm)
    Button btnConfirm;
    @BindView(R.id.tvTryCount)
    TextView tvTryCount;
    @BindView(R.id.etCode)
    EditText etCode;
    @BindString(R.string.ask_again)
    String askAgain;
    @BindString(R.string.try_count)
    String tryCount;
    private int i = 60;
    private CompositeDisposable cp;
    private int count = 3;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @OnClick(R.id.btnConfirm)
    void onConfirmBtnClick(){
        count--;
        tvTryCount.setText(tryCount + " " + count);
        if(count<=0){
            finishAffinity();
        }
        Log.i(TAG, "onConfirmBtnClick: " + phone);
        // FIXME: 19.12.17 скинуть код из смс на сервер вместе с телефоном и именем - провереный!
    }
    private String phone;
    private String name;
    @OnClick(R.id.btnRetry)
    void onRetryClick(){
        btnRetry.setEnabled(false);
        Message message = new Message("/topics/pizda", new Data(phone, name));
        service.sendMessage(message)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    i = 60;
                }, throwable -> Toast.makeText(this, "Произошла ошибка", Toast.LENGTH_SHORT).show());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        ButterKnife.bind(this);
        ComponentManager.getAppComponent().inject(this);
        cp = new CompositeDisposable();
        tvTryCount.setText(tryCount + " " + count);
        phone = getIntent().getStringExtra(PHONE);
        name = getIntent().getStringExtra(NAME);

        cp.add(Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    if (i <= 0) {
                        btnRetry.setEnabled(true);
                        btnRetry.setText(askAgain);
                        btnRetry.setBackgroundColor(Color.parseColor("#0097A7"));
                        return;
                    }
                    i--;
                    btnRetry.setEnabled(false);
                    btnRetry.setBackgroundColor(Color.parseColor("#b6b5af"));
                    btnRetry.setText(askAgain + " (" + i + ")");
                }));
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cp.clear();
        cp.dispose();
    }
}
