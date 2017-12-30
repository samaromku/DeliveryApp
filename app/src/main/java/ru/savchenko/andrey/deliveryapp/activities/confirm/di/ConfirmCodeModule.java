package ru.savchenko.andrey.deliveryapp.activities.confirm.di;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryapp.di.base.BaseModule;
import ru.savchenko.andrey.deliveryapp.activities.confirm.ConfirmCodeView;
import ru.savchenko.andrey.deliveryapp.activities.confirm.ConfirmCodePresenter;
import ru.savchenko.andrey.deliveryapp.activities.confirm.ConfirmCodeInterActor;
import ru.savchenko.andrey.deliveryapp.network.FirebaseService;

@Module
public class ConfirmCodeModule implements BaseModule {
    private ConfirmCodeView view;

    public ConfirmCodeModule(ConfirmCodeView view) {
        this.view = view;
    }

    @ConfirmCodeScope
    @Provides
    public ConfirmCodePresenter presenter(ConfirmCodeInterActor interActor) {
        return new ConfirmCodePresenter(view, interActor);
    }

    @ConfirmCodeScope
    @Provides
    ConfirmCodeInterActor interActor(FirebaseService service) {
        return new ConfirmCodeInterActor(service);
    }
}

