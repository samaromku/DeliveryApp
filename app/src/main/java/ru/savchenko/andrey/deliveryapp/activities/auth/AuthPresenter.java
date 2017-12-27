package ru.savchenko.andrey.deliveryapp.activities.auth;

import com.arellomobile.mvp.InjectViewState;

import ru.savchenko.andrey.deliveryapp.base.BaseMVPPresenter;

/**
 * Created by Andrey on 23.09.2017.
 */
public class AuthPresenter {
    private AuthInteractor interactor;
    private AuthView view;

    public AuthPresenter(AuthInteractor interactor, AuthView view) {
        this.interactor = interactor;
        this.view = view;
    }

    public void auth(String login, String pwd) {
        interactor.checkAuth(login, pwd)
                .subscribe(aBoolean -> view.auth(aBoolean));
    }
}
