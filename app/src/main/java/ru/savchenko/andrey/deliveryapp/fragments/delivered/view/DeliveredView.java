package ru.savchenko.andrey.deliveryapp.fragments.delivered.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.savchenko.andrey.deliveryapp.entities.Order;

/**
 * Created by Andrey on 23.09.2017.
 */

public interface DeliveredView extends MvpView{
    void setData(List<Order>data);
}
