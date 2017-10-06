package ru.savchenko.andrey.deliveryapp.di;

import android.content.Context;
import android.view.LayoutInflater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryapp.App;

/**
 * Created by Andrey on 06.10.2017.
 */
@Module
public class AppModule {

    private final App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Singleton
    @Provides
    Context provideContext(){
        return app;
    }

    @Singleton
    @Provides
    LayoutInflater providesLayoutInflater(){
        return LayoutInflater.from(app);
    }

}
