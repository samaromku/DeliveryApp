package ru.savchenko.andrey.deliveryapp.di.current;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.FragmentCurrentOrders;

/**
 * Created by savchenko on 27.12.17.
 */
@Subcomponent(modules = CurrentModule.class)
@CurrentScope
public interface CurrentComponent {
    void inject(FragmentCurrentOrders fragmentCurrentOrders);
}
