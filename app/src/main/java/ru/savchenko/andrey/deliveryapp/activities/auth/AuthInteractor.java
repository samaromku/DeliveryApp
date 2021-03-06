package ru.savchenko.andrey.deliveryapp.activities.auth;


import android.text.TextUtils;
import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.savchenko.andrey.deliveryapp.di.ComponentManager;
import ru.savchenko.andrey.deliveryapp.network.TestFlask;

/**
 * Created by Andrey on 07.10.2017.
 */

public class AuthInteractor {
    private TestFlask testFlask;

    public AuthInteractor(TestFlask testFlask) {
        this.testFlask = testFlask;
    }

    private static final String TAG = "AuthInteractor";

    Observable<Boolean> checkAuth(String login, String password) {
        testFlask.auth(login, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> Log.i(TAG, "auth: " +s), Throwable::printStackTrace);

        boolean isValid = !TextUtils.isEmpty(login) && !TextUtils.isEmpty(password) &&
                login.equals("andrey") && password.equals("12345");
        return Observable.fromCallable(() -> isValid);
    }

}
