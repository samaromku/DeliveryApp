package ru.savchenko.andrey.deliveryapp.di.main;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryapp.activities.main.MainActivity;
import ru.savchenko.andrey.deliveryapp.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryapp.di.base.ComponentBuilder;

/**
 * Created by savchenko on 28.12.17.
 */
@MainScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent extends BaseComponent<MainActivity>{
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<MainComponent, MainModule>{}
}
