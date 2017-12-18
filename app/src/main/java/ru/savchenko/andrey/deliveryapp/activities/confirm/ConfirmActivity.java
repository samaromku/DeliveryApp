package ru.savchenko.andrey.deliveryapp.activities.confirm;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.base.BaseActivity;

/**
 * Created by Andrey on 18.12.2017.
 */

public class ConfirmActivity extends BaseActivity {
    @BindView(R.id.btnAskAgain)
    Button btnAskAgain;
    @BindView(R.id.btnConfirm)
    Button btnConfirm;
    @BindView(R.id.tvTryCount)
    TextView tvTryCount;
    @BindView(R.id.etCode)
    EditText etCode;
    @BindString(R.string.ask_again)String askAgain;
    private int i = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        ButterKnife.bind(this);

        Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    i--;
                    btnAskAgain.setText(askAgain + " (" + i+ ")");
                });
    }
}
