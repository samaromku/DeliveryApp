package ru.savchenko.andrey.deliveryapp.activities.auth.presenter;

import com.arellomobile.mvp.InjectViewState;

import ru.savchenko.andrey.deliveryapp.activities.auth.interactor.AuthInteractor;
import ru.savchenko.andrey.deliveryapp.activities.auth.view.AuthView;
import ru.savchenko.andrey.deliveryapp.base.BaseMVPPresenter;

/**
 * Created by Andrey on 23.09.2017.
 */
@InjectViewState
public class AuthPresenter extends BaseMVPPresenter<AuthView> {
    private AuthInteractor interactor;

    public AuthPresenter() {
        this.interactor = new AuthInteractor();
    }

    public void auth(String login, String pwd) {
        interactor.checkAuth(login, pwd)
                .subscribe(aBoolean -> getViewState().auth(aBoolean));
    }
}
