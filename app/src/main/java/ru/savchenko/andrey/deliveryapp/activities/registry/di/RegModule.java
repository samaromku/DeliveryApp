package ru.savchenko.andrey.deliveryapp.activities.registry.di;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryapp.di.base.BaseModule;
import ru.savchenko.andrey.deliveryapp.activities.registry.RegView;
import ru.savchenko.andrey.deliveryapp.activities.registry.RegPresenter;
import ru.savchenko.andrey.deliveryapp.activities.registry.RegInterActor;
import ru.savchenko.andrey.deliveryapp.network.FirebaseService;

@Module
public class RegModule implements BaseModule {
    private RegView view;

    public RegModule(RegView view) {
        this.view = view;
    }

    @RegScope
    @Provides
    public RegPresenter presenter(RegInterActor interActor) {
        return new RegPresenter(view, interActor);
    }

    @RegScope
    @Provides
    RegInterActor interActor(FirebaseService service) {
        return new RegInterActor(service);
    }
}

