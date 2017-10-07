package ru.savchenko.andrey.deliveryapp.di.auth.components;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryapp.di.auth.modules.AuthModule;
import ru.savchenko.andrey.deliveryapp.di.auth.scopes.AuthScope;
import ru.savchenko.andrey.deliveryapp.di.base.BaseAuthComponent;

/**
 * Created by Andrey on 07.10.2017.
 */
@AuthScope
@Subcomponent(modules = AuthModule.class)
public interface AuthComponent extends BaseAuthComponent{

}
