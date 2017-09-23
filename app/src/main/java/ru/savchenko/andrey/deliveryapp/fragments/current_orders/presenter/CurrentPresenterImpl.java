package ru.savchenko.andrey.deliveryapp.fragments.current_orders.presenter;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryapp.di.ComponentManager;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.interactor.CurrentInteractorImpl;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.view.CurrentView;

/**
 * Created by Andrey on 23.09.2017.
 */
@Module
public class CurrentPresenterImpl implements CurrentPresenter {
    private CurrentView view;
    @Inject CurrentInteractorImpl interactor;

    @Provides
    CurrentPresenterImpl currentPresenter() {
        ComponentManager.getAppComponent().injectCurrentPresenter(this);
        return this;
    }

    @Override
    public void getOrderList() {
        interactor.getOrderList()
                .subscribe(orders -> view.setDataList(orders));
    }

    @Override
    public void init(CurrentView view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
