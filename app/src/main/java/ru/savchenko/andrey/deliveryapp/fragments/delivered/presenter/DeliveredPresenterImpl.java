package ru.savchenko.andrey.deliveryapp.fragments.delivered.presenter;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryapp.di.ComponentManager;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.interactor.DeliveredInteractorImpl;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.view.DeliveredView;

/**
 * Created by Andrey on 23.09.2017.
 */
@Module
public class DeliveredPresenterImpl implements DeliveredPresenter{
    private DeliveredView view;
    @Inject
    DeliveredInteractorImpl interactor;

    @Provides
    public DeliveredPresenterImpl deliveredPresenter(){
        return this;
    }

    @Override
    public void setDataOrders() {
        interactor.getDeliveredOrders()
                .subscribe(orders -> view.setData(orders));
    }

    @Override
    public void init(DeliveredView deliveredView) {
        ComponentManager.getDeliveryComponent().injectDeliveredPresenter(this);
        this.view = deliveredView;

    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
