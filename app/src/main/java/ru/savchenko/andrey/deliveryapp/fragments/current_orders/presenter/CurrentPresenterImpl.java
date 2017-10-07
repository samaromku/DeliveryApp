package ru.savchenko.andrey.deliveryapp.fragments.current_orders.presenter;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryapp.base.BaseMVPPresenter;
import ru.savchenko.andrey.deliveryapp.di.ComponentManager;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.interactor.CurrentInteractorImpl;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.view.CurrentView;

/**
 * Created by Andrey on 23.09.2017.
 */
@InjectViewState
@Module
public class CurrentPresenterImpl extends BaseMVPPresenter<CurrentView> implements CurrentPresenter {
    @Inject CurrentInteractorImpl interactor;

    @Provides
    CurrentPresenterImpl currentPresenter() {
        return this;
    }

    @Override
    public void getOrderList() {
        interactor.getOrderList()
                .subscribe(orders -> getViewState().setDataList(orders));
    }

    @Override
    public void init() {
        ComponentManager.getAppComponent().injectCurrentPresenter(this);
    }


}
