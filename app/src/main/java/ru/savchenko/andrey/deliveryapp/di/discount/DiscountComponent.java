package ru.savchenko.andrey.deliveryapp.di.discount;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryapp.fragments.discount.DiscountFragment;

/**
 * Created by Andrey on 07.10.2017.
 */
@DiscountScope
@Subcomponent(modules = DiscountModule.class)
public interface DiscountComponent {
    void inject(DiscountFragment fragment);
}
