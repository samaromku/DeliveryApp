package ru.savchenko.andrey.deliveryapp.activities.main;

/**
 * Created by savchenko on 28.12.17.
 */

public class MainPresenter {
    private MainView view;
    private MainInterActor interActor;

    public MainPresenter(MainView view, MainInterActor interActor) {
        this.view = view;
        this.interActor = interActor;
    }
}
