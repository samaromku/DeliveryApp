package ru.savchenko.andrey.deliveryapp;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

import ru.savchenko.andrey.deliveryapp.di.ComponentManager;

/**
 * Created by Andrey on 09.09.2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
        ComponentManager.init();
    }
}
