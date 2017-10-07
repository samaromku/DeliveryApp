package ru.savchenko.andrey.deliveryapp.di.auth.components;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryapp.di.auth.modules.AnonimModule;
import ru.savchenko.andrey.deliveryapp.di.auth.scopes.AnonimScope;
import ru.savchenko.andrey.deliveryapp.di.base.BaseAuthComponent;

/**
 * Created by Andrey on 07.10.2017.
 */
@AnonimScope
@Subcomponent(modules = AnonimModule.class)
public interface AnonimComponent extends BaseAuthComponent{
}
