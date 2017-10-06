package ru.savchenko.andrey.deliveryapp.di;

import dagger.Component;
import ru.savchenko.andrey.deliveryapp.adapters.CurrentOrdersAdapter;
import ru.savchenko.andrey.deliveryapp.di.scopes.DeliveryScope;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.DeliveredFragment;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.interactor.DeliveredInteractorImpl;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.presenter.DeliveredPresenterImpl;

/**
 * Created by Andrey on 23.09.2017.
 */

@Component(dependencies = AppComponent.class, modules = {
        DeliveredPresenterImpl.class,
        DeliveredInteractorImpl.class,
        CurrentOrdersAdapter.class
})
@DeliveryScope
public interface DeliveryComponent {
    void injectDeliveredPresenter(DeliveredPresenterImpl deliveredPresenter);

    void injectDeliveredFragment(DeliveredFragment deliveredFragment);
}
