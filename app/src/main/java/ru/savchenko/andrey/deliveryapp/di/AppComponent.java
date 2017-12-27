package ru.savchenko.andrey.deliveryapp.di;

import javax.inject.Singleton;

import dagger.Component;
import ru.savchenko.andrey.deliveryapp.activities.auth.interactor.AuthInteractor;
import ru.savchenko.andrey.deliveryapp.activities.confirm.ConfirmActivity;
import ru.savchenko.andrey.deliveryapp.activities.map.MapsActivity;
import ru.savchenko.andrey.deliveryapp.activities.registry.RegistryActivity;
import ru.savchenko.andrey.deliveryapp.di.auth.components.AnonimComponent;
import ru.savchenko.andrey.deliveryapp.di.auth.components.AuthComponent;
import ru.savchenko.andrey.deliveryapp.di.auth.modules.AnonimModule;
import ru.savchenko.andrey.deliveryapp.di.auth.modules.AuthModule;
import ru.savchenko.andrey.deliveryapp.di.current.CurrentComponent;
import ru.savchenko.andrey.deliveryapp.di.current.CurrentModule;
import ru.savchenko.andrey.deliveryapp.di.delivered.DeliveredComponent;
import ru.savchenko.andrey.deliveryapp.di.delivered.DeliveredModule;
import ru.savchenko.andrey.deliveryapp.di.discount.DiscountComponent;
import ru.savchenko.andrey.deliveryapp.di.discount.DiscountModule;
import ru.savchenko.andrey.deliveryapp.di.reviews.ReviewComponent;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.FragmentCurrentOrders;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.interactor.CurrentInteractorImpl;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.presenter.CurrentPresenterImpl;
import ru.savchenko.andrey.deliveryapp.fragments.discount.DiscountInteractor;
import ru.savchenko.andrey.deliveryapp.fragments.discount.DiscountPresenter;
import ru.savchenko.andrey.deliveryapp.di.reviews.ReviewModule;

/**
 * Created by Andrey on 23.09.2017.
 */

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
//    void injectCurrentFragment(FragmentCurrentOrders fragmentCurrentOrders);

    void inject(AuthInteractor interactor);

    void inject(MapsActivity activity);

    void inject(RegistryActivity activity);

    void inject(ConfirmActivity activity);

    ReviewComponent reviewComponent(ReviewModule reviewModule);

    DiscountComponent discountComponent(DiscountModule discountModule);

    AuthComponent authComponent(AuthModule authModule);

    AnonimComponent anonimComponent(AnonimModule anonimModule);

    DeliveredComponent deliveredComponent(DeliveredModule deliveredModule);

    CurrentComponent currentComponent(CurrentModule module);
}
