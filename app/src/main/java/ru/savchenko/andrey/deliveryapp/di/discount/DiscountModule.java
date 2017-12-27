package ru.savchenko.andrey.deliveryapp.di.discount;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryapp.di.base.BaseModule;
import ru.savchenko.andrey.deliveryapp.fragments.discount.DiscountFragment;
import ru.savchenko.andrey.deliveryapp.fragments.discount.DiscountInteractor;
import ru.savchenko.andrey.deliveryapp.fragments.discount.DiscountPresenter;

/**
 * Created by Andrey on 07.10.2017.
 */
@Module
public class DiscountModule implements BaseModule{
    private DiscountFragment fragment;

    public DiscountModule(DiscountFragment fragment) {
        this.fragment = fragment;
    }

    @DiscountScope
    @Provides
    public DiscountPresenter presenter(DiscountInteractor interactor){
        return new DiscountPresenter(interactor, fragment);
    }

    @DiscountScope
    @Provides
    public DiscountInteractor interactor(){
        return new DiscountInteractor();
    }
}
