package ru.savchenko.andrey.deliveryapp.di;

import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by Andrey on 23.09.2017.
 */

public class ComponentManager {
    private static CurrentComponent appComponent;
    private static DeliveryComponent deliveryComponent;

    public static DeliveryComponent getDeliveryComponent() {
        return deliveryComponent;
    }

    public static CurrentComponent getAppComponent() {
        return appComponent;
    }

    public static void init(){
        appComponent = DaggerCurrentComponent
                .builder()
                .build();
    }

    public static void initDeliveryComponent(){
        deliveryComponent = DaggerDeliveryComponent
                .builder()
                .currentComponent(appComponent)
                .build();
    }

    public static void destroyDeliveryComponent(){
        deliveryComponent = null;
        Log.i(TAG, "destroyDeliveryComponent: ");
    }
}
