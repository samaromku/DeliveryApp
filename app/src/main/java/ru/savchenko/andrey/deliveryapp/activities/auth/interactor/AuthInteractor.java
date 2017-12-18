package ru.savchenko.andrey.deliveryapp.activities.auth.interactor;


import android.text.TextUtils;

import io.reactivex.Observable;

/**
 * Created by Andrey on 07.10.2017.
 */

public class AuthInteractor {

    public Observable<Boolean> checkAuth(String login, String password) {
        boolean isValid = !TextUtils.isEmpty(login) && !TextUtils.isEmpty(password) &&
                login.equals("andrey") && password.equals("12345");
        return Observable.fromCallable(() -> isValid);
    }

}
