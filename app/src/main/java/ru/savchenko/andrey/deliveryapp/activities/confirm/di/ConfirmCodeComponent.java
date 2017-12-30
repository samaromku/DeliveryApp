package ru.savchenko.andrey.deliveryapp.activities.confirm.di;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryapp.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryapp.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryapp.activities.confirm.ConfirmCodeActivity;

@Subcomponent(modules = ConfirmCodeModule.class)
@ConfirmCodeScope
public interface ConfirmCodeComponent extends BaseComponent<ConfirmCodeActivity> {
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<ConfirmCodeComponent, ConfirmCodeModule> {
    }
}
