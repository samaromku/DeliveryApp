package ru.savchenko.andrey.deliveryapp.di.delivered;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryapp.di.base.BaseModule;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.interactor.DeliveredInteractor;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.interactor.DeliveredInteractorImpl;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.presenter.DeliveredPresenter;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.presenter.DeliveredPresenterImpl;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.view.DeliveredView;

/**
 * Created by savchenko on 27.12.17.
 */
@Module
public class DeliveredModule implements BaseModule{
    private DeliveredView view;

    public DeliveredModule(DeliveredView view) {
        this.view = view;
    }

    @DeliveredScope
    @Provides
    DeliveredPresenter presenter(DeliveredInteractor interactor){
        return new DeliveredPresenterImpl(interactor, view);
    }

    @DeliveredScope
    @Provides
    DeliveredInteractor interactor(){
        return new DeliveredInteractorImpl();
    }
}
