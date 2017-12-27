package ru.savchenko.andrey.deliveryapp.di.auth;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryapp.activities.auth.AuthActivity;
import ru.savchenko.andrey.deliveryapp.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryapp.di.base.ComponentBuilder;

/**
 * Created by savchenko on 27.12.17.
 */
@Subcomponent(modules = AuthModule.class)
@AuthScope
public interface AuthComponent extends BaseComponent<AuthActivity>{
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<AuthComponent, AuthModule>{}
}
