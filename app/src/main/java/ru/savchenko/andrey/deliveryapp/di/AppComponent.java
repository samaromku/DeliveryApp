package ru.savchenko.andrey.deliveryapp.di;

import javax.inject.Singleton;

import dagger.Component;
import ru.savchenko.andrey.deliveryapp.activities.confirm.ConfirmActivity;
import ru.savchenko.andrey.deliveryapp.activities.map.MapsActivity;
import ru.savchenko.andrey.deliveryapp.activities.registry.RegistryActivity;
import ru.savchenko.andrey.deliveryapp.di.current.CurrentComponent;
import ru.savchenko.andrey.deliveryapp.di.current.CurrentModule;
import ru.savchenko.andrey.deliveryapp.di.delivered.DeliveredComponent;
import ru.savchenko.andrey.deliveryapp.di.delivered.DeliveredModule;
import ru.savchenko.andrey.deliveryapp.di.discount.DiscountComponent;
import ru.savchenko.andrey.deliveryapp.di.discount.DiscountModule;
import ru.savchenko.andrey.deliveryapp.di.reviews.ReviewComponent;
import ru.savchenko.andrey.deliveryapp.di.reviews.ReviewModule;

/**
 * Created by Andrey on 23.09.2017.
 */

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    void inject(MapsActivity activity);

    void inject(RegistryActivity activity);

    void inject(ConfirmActivity activity);

    void injectComponentManager(ComponentManager componentManager);
}
