package ru.savchenko.andrey.deliveryapp.activities.registry.di;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryapp.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryapp.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryapp.activities.registry.RegActivity;

@Subcomponent(modules = RegModule.class)
@RegScope
public interface RegComponent extends BaseComponent<RegActivity> {
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<RegComponent, RegModule> {
    }
}
