package ru.savchenko.andrey.deliveryapp.di;

import javax.inject.Singleton;

import dagger.Component;
import ru.savchenko.andrey.deliveryapp.adapters.CurrentOrdersAdapter;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.FragmentCurrentOrders;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.interactor.CurrentInteractorImpl;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.presenter.CurrentPresenterImpl;
import ru.savchenko.andrey.deliveryapp.fragments.discount.DiscountInteractor;
import ru.savchenko.andrey.deliveryapp.fragments.discount.presentation.presenter.discount.DiscountPresenter;

/**
 * Created by Andrey on 23.09.2017.
 */

@Component(modules = {
        CurrentPresenterImpl.class,
        CurrentInteractorImpl.class,
        CurrentOrdersAdapter.class,
        DiscountInteractor.class
})

@Singleton
public interface CurrentComponent {
    void injectCurrentFragment(FragmentCurrentOrders fragmentCurrentOrders);

    void injectCurrentPresenter(CurrentPresenterImpl currentPresenter);

    void inject(DiscountPresenter presenter);
}
