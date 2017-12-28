package ru.savchenko.andrey.deliveryapp.activities.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import ru.savchenko.andrey.deliveryapp.App;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.activities.main.MainActivity;
import ru.savchenko.andrey.deliveryapp.activities.registry.RegistryActivity;
import ru.savchenko.andrey.deliveryapp.base.BaseActivity;
import ru.savchenko.andrey.deliveryapp.di.auth.AuthComponent;
import ru.savchenko.andrey.deliveryapp.di.auth.AuthModule;
import ru.savchenko.andrey.deliveryapp.dialogs.PreviewDialog;
import ru.savchenko.andrey.deliveryapp.entities.Company;

/**
 * Created by Andrey on 09.09.2017.
 */

public class AuthActivity extends BaseActivity implements AuthView {
    public static final String TAG = "AuthActivity";
    @Inject AuthPresenter presenter;
    @BindView(R.id.login)TextView login;
    @BindView(R.id.password)TextView password;
    @OnClick(R.id.btn_enter)
    void onClick(){
        presenter.auth(login.getText().toString(), password.getText().toString());
    }

    @OnClick(R.id.btn_register)
    void onRegisterClick(){
        startActivity(new Intent(this, RegistryActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AuthComponent)App.getComponentManager()
                .getPresenterComponent(getClass(), new AuthModule(this))).inject(this);

        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
        initToolbar(R.string.auth);
    }

    @Override
    protected void onDestroy() {
        App.getComponentManager().releaseComponent(getClass());
        super.onDestroy();
    }

    @Override
    public void auth(boolean isAuhValid) {
        Log.i(TAG, "auth: " + isAuhValid);
        startActivity(new Intent(this, MainActivity.class));

    }

    private void test() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> {
            for (int i = 0; i < 10; i++) {
                realm1.insertOrUpdate(new Company(i, "company" + i, "url"));
            }
        });


        final Realm[] ioRealm = {null};
        Observable.fromCallable(() -> {
            Log.i(TAG, "test: " + "fromCallable " + Thread.currentThread().getName());
            ioRealm[0] = Realm.getDefaultInstance();
            return ioRealm[0];
        })
                .subscribeOn(Schedulers.io())
                .doFinally(() -> {
                    ioRealm[0].close();
                    Log.i(TAG, "test: " + "finnaly " + Thread.currentThread().getName());
                })
                .map(realm1 -> {
                    Log.i(TAG, "test: " + "map " + Thread.currentThread().getName());
                    return realm1.copyFromRealm(realm1.where(Company.class).findAll());
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Log.i(TAG, "test: " + s);
                    Log.i(TAG, "test: " + "subscribe " + Thread.currentThread().getName());
                });
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
