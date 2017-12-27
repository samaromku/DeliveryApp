package ru.savchenko.andrey.deliveryapp.di.auth;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryapp.activities.auth.AuthInteractor;
import ru.savchenko.andrey.deliveryapp.activities.auth.AuthPresenter;
import ru.savchenko.andrey.deliveryapp.activities.auth.AuthView;
import ru.savchenko.andrey.deliveryapp.di.base.BaseModule;
import ru.savchenko.andrey.deliveryapp.network.TestFlask;

/**
 * Created by savchenko on 27.12.17.
 */
@Module
public class AuthModule implements BaseModule{
    private AuthView view;

    public AuthModule(AuthView view) {
        this.view = view;
    }

    @AuthScope
    @Provides
    public AuthPresenter presenter(AuthInteractor interactor){
        return new AuthPresenter(interactor, view);
    }

    @AuthScope
    @Provides
    AuthInteractor authInteractor(TestFlask testFlask){
        return new AuthInteractor(testFlask);
    }
}
