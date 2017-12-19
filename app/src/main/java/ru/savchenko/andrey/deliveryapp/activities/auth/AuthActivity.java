package ru.savchenko.andrey.deliveryapp.activities.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.activities.auth.presenter.AuthPresenter;
import ru.savchenko.andrey.deliveryapp.activities.auth.view.AuthView;
import ru.savchenko.andrey.deliveryapp.activities.registry.RegistryActivity;
import ru.savchenko.andrey.deliveryapp.base.BaseActivity;
import ru.savchenko.andrey.deliveryapp.di.ComponentManager;
import ru.savchenko.andrey.deliveryapp.dialogs.PreviewDialog;

/**
 * Created by Andrey on 09.09.2017.
 */

public class AuthActivity extends BaseActivity implements AuthView {
    public static final String TAG = "AuthActivity";
    @InjectPresenter AuthPresenter presenter;
    @Inject
    AuthShowAnimation authShowAnimation;
    @BindView(R.id.login)TextView login;
    @BindView(R.id.password)TextView password;
    @OnClick(R.id.btn_enter)
    void onClick(){
        presenter.auth(login.getText().toString(), password.getText().toString());
//        startActivity(new Intent(this, DeliveryActivity.class));
    }

    @OnClick(R.id.btn_register)
    void onRegisterClick(){
        startActivity(new Intent(this, RegistryActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
        initToolbar(R.string.auth);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ComponentManager.destroyBaseAuthComponent();
    }

    @Override
    public void auth(boolean isAuhValid) {
        Log.i(TAG, "auth: " + isAuhValid);
        ComponentManager.getBaseAuthComponent(isAuhValid).inject(this);
        authShowAnimation.showAnimation();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.auth_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.nav_auth:
                PreviewDialog previewDialog = new PreviewDialog();
                previewDialog.show(getFragmentManager(), "previewDialog");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
