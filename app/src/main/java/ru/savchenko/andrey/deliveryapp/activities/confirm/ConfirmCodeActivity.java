package ru.savchenko.andrey.deliveryapp.activities.confirm;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.savchenko.andrey.deliveryapp.App;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.activities.confirm.di.ConfirmCodeComponent;
import ru.savchenko.andrey.deliveryapp.activities.confirm.di.ConfirmCodeModule;

import static ru.savchenko.andrey.deliveryapp.storage.Const.NAME;
import static ru.savchenko.andrey.deliveryapp.storage.Const.PHONE;

public class ConfirmCodeActivity extends AppCompatActivity implements ConfirmCodeView {
    private static final String TAG = ConfirmCodeActivity.class.getSimpleName();
    @Inject
    ConfirmCodePresenter presenter;
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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @OnClick(R.id.btnConfirm)
    void onConfirmBtnClick(){
        presenter.updateCount();
    }

    @Override
    public void tvTryCountSetText(String text) {
        tvTryCount.setText(text);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void finishAllActivities() {
        finishAffinity();
    }

    private String phone;
    private String name;
    @OnClick(R.id.btnRetry)
    void onRetryClick(){
        btnRetry.setEnabled(false);
        presenter.onRetryClick(phone, name);
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_code);
        ((ConfirmCodeComponent) App.getComponentManager()
                .getPresenterComponent(getClass(), new ConfirmCodeModule(this))).inject(this);
        ButterKnife.bind(this);
        presenter.getCountSetText();
        phone = getIntent().getStringExtra(PHONE);
        name = getIntent().getStringExtra(NAME);

        presenter.setInterval();
    }

    @Override
    public void setBtnParameters(boolean enabled, String text, String color) {
        btnRetry.setEnabled(enabled);
        btnRetry.setText(text);
        btnRetry.setBackgroundColor(Color.parseColor(color));
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
        if (isFinishing()) {
            presenter.onDestroy();
            App.getComponentManager().releaseComponent(getClass());
        }
    }

}
