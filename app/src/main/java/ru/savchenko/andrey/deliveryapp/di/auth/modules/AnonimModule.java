package ru.savchenko.andrey.deliveryapp.di.auth.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryapp.activities.auth.AuthShowAnimation;
import ru.savchenko.andrey.deliveryapp.activities.auth.ErrorAuth;
import ru.savchenko.andrey.deliveryapp.di.auth.scopes.AnonimScope;

/**
 * Created by Andrey on 07.10.2017.
 */
@Module
public class AnonimModule {

    @AnonimScope
    @Provides
    public AuthShowAnimation authShowAnimation(Context context) {
        return new ErrorAuth(context);
    }

}
