package ru.savchenko.andrey.deliveryapp.activities.auth.view;

import com.arellomobile.mvp.MvpView;

/**
 * Created by Andrey on 23.09.2017.
 */
public interface AuthView extends MvpView {
    void auth(boolean isAuhValid);
}
