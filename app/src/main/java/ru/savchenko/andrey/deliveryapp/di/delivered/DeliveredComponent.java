package ru.savchenko.andrey.deliveryapp.di.delivered;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryapp.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryapp.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.DeliveredFragment;

/**
 * Created by savchenko on 27.12.17.
 */
@DeliveredScope
@Subcomponent(modules = DeliveredModule.class)
public interface DeliveredComponent extends BaseComponent<DeliveredFragment>{
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<DeliveredComponent, DeliveredModule>{}
}
