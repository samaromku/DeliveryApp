package ru.savchenko.andrey.deliveryapp.di;

import javax.inject.Singleton;

import dagger.Component;
import ru.savchenko.andrey.deliveryapp.activities.map.MapsActivity;

/**
 * Created by Andrey on 23.09.2017.
 */

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    void inject(MapsActivity activity);

    void injectComponentManager(ComponentManager componentManager);
}
