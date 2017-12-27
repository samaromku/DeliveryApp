package ru.savchenko.andrey.deliveryapp.fragments.delivered.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryapp.di.ComponentManager;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.interactor.DeliveredInteractor;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.interactor.DeliveredInteractorImpl;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.view.DeliveredView;

/**
 * Created by Andrey on 23.09.2017.
 */
//@Module
//@InjectViewState
public class DeliveredPresenterImpl implements DeliveredPresenter{
//    @Inject
//    DeliveredInteractorImpl interactor;
    private DeliveredView view;
    private DeliveredInteractor interactor;

    public DeliveredPresenterImpl(DeliveredInteractor interactor, DeliveredView view) {
        this.interactor = interactor;
        this.view = view;
    }

//    @Provides
//    DeliveredPresenterImpl deliveredPresenter(){
//        return this;
//    }

    @Override
    public void setDataOrders() {
        interactor.getDeliveredOrders()
                .subscribe(orders -> view.setData(orders));
    }
}
