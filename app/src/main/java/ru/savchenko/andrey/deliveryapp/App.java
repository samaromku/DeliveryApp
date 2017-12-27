package ru.savchenko.andrey.deliveryapp;

import android.app.Application;

import com.akaita.java.rxjava2debug.RxJava2Debug;

import net.danlew.android.joda.JodaTimeAndroid;

import io.realm.Realm;
import ru.savchenko.andrey.deliveryapp.di.ComponentManager;

/**
 * Created by Andrey on 09.09.2017.
 */

public class App extends Application {
    private static ComponentManager componentManager;

    public static ComponentManager getComponentManager() {
        return componentManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
//        ComponentManager.init(this);
        componentManager = new ComponentManager();
        componentManager.init();
        RxJava2Debug.enableRxJava2AssemblyTracking(new String[]{"ru.savchenko.andrey.deliveryapp", "ru.savchenko.andrey.mylibrary"});
        Realm.init(this);
    }
}
