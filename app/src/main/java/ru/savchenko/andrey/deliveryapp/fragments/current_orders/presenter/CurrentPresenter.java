package ru.savchenko.andrey.deliveryapp.fragments.current_orders.presenter;

import ru.savchenko.andrey.deliveryapp.base.basemvp.BasePresenter;

/**
 * Created by Andrey on 23.09.2017.
 */
public interface CurrentPresenter extends BasePresenter{
    void getOrderList();
}
