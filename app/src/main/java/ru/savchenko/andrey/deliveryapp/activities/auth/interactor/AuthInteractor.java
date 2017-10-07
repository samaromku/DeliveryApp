package ru.savchenko.andrey.deliveryapp.activities.auth.interactor;


import android.text.TextUtils;
import android.util.Log;

import io.reactivex.Observable;

import static android.content.ContentValues.TAG;

/**
 * Created by Andrey on 07.10.2017.
 */

public class AuthInteractor {

    public Observable<Boolean> checkAuth(String login, String password) {
        boolean isValid = !TextUtils.isEmpty(login) && !TextUtils.isEmpty(password);
        return Observable.fromCallable(() -> isValid);
    }

}
