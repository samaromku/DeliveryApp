package ru.savchenko.andrey.deliveryapp.di.main;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryapp.activities.main.MainInterActor;
import ru.savchenko.andrey.deliveryapp.activities.main.MainPresenter;
import ru.savchenko.andrey.deliveryapp.activities.main.MainView;
import ru.savchenko.andrey.deliveryapp.di.base.BaseModule;

/**
 * Created by savchenko on 28.12.17.
 */
@Module
public class MainModule implements BaseModule{
    private MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }

    @MainScope
    @Provides
    public MainPresenter presenter(MainInterActor interActor){
        return new MainPresenter(view, interActor);
    }

    @MainScope
    @Provides
    MainInterActor interActor(){
        return new MainInterActor();
    }
}
