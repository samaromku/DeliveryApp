package ru.savchenko.andrey.deliveryapp.fragments.delivered.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

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
@InjectViewState
public class DeliveredPresenterImpl extends MvpPresenter<DeliveredView> implements DeliveredPresenter{
    @Inject
    DeliveredInteractorImpl interactor;

    @Provides
    public DeliveredPresenterImpl deliveredPresenter(){
        return this;
    }

    @Override
    public void setDataOrders() {
        interactor.getDeliveredOrders()
                .subscribe(orders -> getViewState().setData(orders));
    }

    @Override
    public void init() {
        ComponentManager.getDeliveryComponent().injectDeliveredPresenter(this);
    }
}
