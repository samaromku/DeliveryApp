package ru.savchenko.andrey.deliveryapp.di;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import ru.savchenko.andrey.deliveryapp.App;
import ru.savchenko.andrey.deliveryapp.di.base.BaseComponent;
import ru.savchenko.andrey.deliveryapp.di.base.BaseModule;
import ru.savchenko.andrey.deliveryapp.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryapp.di.current.CurrentComponent;
import ru.savchenko.andrey.deliveryapp.di.current.CurrentModule;
import ru.savchenko.andrey.deliveryapp.di.delivered.DeliveredComponent;
import ru.savchenko.andrey.deliveryapp.di.delivered.DeliveredModule;
import ru.savchenko.andrey.deliveryapp.di.discount.DiscountComponent;
import ru.savchenko.andrey.deliveryapp.di.discount.DiscountModule;
import ru.savchenko.andrey.deliveryapp.di.reviews.ReviewComponent;
import ru.savchenko.andrey.deliveryapp.di.reviews.ReviewModule;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.FragmentCurrentOrders;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.DeliveredFragment;
import ru.savchenko.andrey.deliveryapp.fragments.discount.DiscountFragment;
import ru.savchenko.andrey.deliveryapp.fragments.review.ReviewFragment;

/**
 * Created by Andrey on 23.09.2017.
 */

public class ComponentManager {
    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        if(appComponent==null){
            appComponent = DaggerAppComponent
                    .builder()
                    .appModule(new AppModule())
                    .build();
        }
        return appComponent;
    }


    @Inject
    Map<Class<?>, Provider<ComponentBuilder>>builders;
    private Map<Class<?>, BaseComponent>components;

    public void init(){
        AppComponent appComponentNew = DaggerAppComponent.builder().appModule(new AppModule()).build();
        appComponentNew.injectComponentManager(this);
        components = new HashMap<>();
    }

    public BaseComponent getPresenterComponent(Class<?>clazz){
        return getPresenterComponent(clazz, null);
    }


    public BaseComponent getPresenterComponent(Class<?>clazz, BaseModule module){
        BaseComponent component = components.get(clazz);
        if(component==null){
            ComponentBuilder builder = builders.get(clazz).get();
            if(module!=null){
                builder.module(module);
            }
            component = builder.build();
            components.put(clazz, component);
        }
        return component;
    }

    public void releaseComponent(Class<?>clazz){
        components.put(clazz, null);
    }
}
