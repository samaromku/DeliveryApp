package ru.savchenko.andrey.deliveryapp.di.current;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryapp.di.base.BaseModule;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.interactor.CurrentInteractorImpl;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.presenter.CurrentPresenterImpl;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.view.CurrentView;
import ru.savchenko.andrey.deliveryapp.network.TestFlask;

/**
 * Created by savchenko on 27.12.17.
 */
@Module
public class CurrentModule implements BaseModule{
    private CurrentView view;

    public CurrentModule(CurrentView view) {
        this.view = view;
    }

    @CurrentScope
    @Provides
    CurrentPresenterImpl currentPresenter(CurrentInteractorImpl interactor){
        return new CurrentPresenterImpl(interactor, view);
    }

    @CurrentScope
    @Provides
    public CurrentInteractorImpl interactor(TestFlask testFlask){
        return new CurrentInteractorImpl(testFlask);
    }
}
