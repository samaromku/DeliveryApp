package ru.savchenko.andrey.deliveryapp.di.current;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryapp.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryapp.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.FragmentCurrentOrders;

/**
 * Created by savchenko on 27.12.17.
 */
@Subcomponent(modules = CurrentModule.class)
@CurrentScope
public interface CurrentComponent extends BaseComponent<FragmentCurrentOrders>{
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<CurrentComponent, CurrentModule>{}
}
