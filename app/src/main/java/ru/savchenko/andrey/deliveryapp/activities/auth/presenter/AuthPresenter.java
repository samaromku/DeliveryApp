package ru.savchenko.andrey.deliveryapp.activities.auth.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.savchenko.andrey.deliveryapp.activities.auth.view.AuthView;

/**
 * Created by Andrey on 23.09.2017.
 */
@InjectViewState
public class AuthPresenter extends MvpPresenter<AuthView>{
    public AuthPresenter() {
        getViewState().authSuccess();
    }
}
