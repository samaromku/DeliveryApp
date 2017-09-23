package ru.savchenko.andrey.deliveryapp.fragments.delivered.presenter;

import ru.savchenko.andrey.deliveryapp.base.basemvp.BasePresenter;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.view.DeliveredView;

/**
 * Created by Andrey on 23.09.2017.
 */

public interface DeliveredPresenter extends BasePresenter<DeliveredView> {
    void setDataOrders();
}
