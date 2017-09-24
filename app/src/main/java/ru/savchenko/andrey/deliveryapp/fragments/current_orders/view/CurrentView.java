package ru.savchenko.andrey.deliveryapp.fragments.current_orders.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.savchenko.andrey.deliveryapp.entities.Order;

/**
 * Created by Andrey on 23.09.2017.
 */
public interface CurrentView extends MvpView{
    void setDataList(List<Order>orders);
}
