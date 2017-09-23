package ru.savchenko.andrey.deliveryapp.base.basemvp;

/**
 * Created by Andrey on 23.09.2017.
 */

public interface BasePresenter<T> {
    void init(T t);

    void onDestroy();
}
