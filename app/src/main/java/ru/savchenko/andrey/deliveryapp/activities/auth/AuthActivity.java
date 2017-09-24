package ru.savchenko.andrey.deliveryapp.activities.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.activities.auth.presenter.AuthPresenter;
import ru.savchenko.andrey.deliveryapp.activities.auth.view.AuthView;
import ru.savchenko.andrey.deliveryapp.activities.main.DeliveryActivity;
import ru.savchenko.andrey.deliveryapp.base.BaseActivity;

/**
 * Created by Andrey on 09.09.2017.
 */

public class AuthActivity extends BaseActivity implements AuthView {
    @InjectPresenter AuthPresenter presenter;
    @BindView(R.id.login)TextView login;
    @OnClick(R.id.btn_enter)
    void onClick(){
        startActivity(new Intent(this, DeliveryActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
        initToolbar(R.string.auth);
    }

    @Override
    public void authSuccess() {
        login.setText("her");
    }

    @Override
    public void authError() {

    }
}
