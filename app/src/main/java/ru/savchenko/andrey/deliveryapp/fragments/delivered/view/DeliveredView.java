package ru.savchenko.andrey.deliveryapp.fragments.delivered.view;

import java.util.List;

import ru.savchenko.andrey.deliveryapp.entities.Order;

/**
 * Created by Andrey on 23.09.2017.
 */

public interface DeliveredView {
    void setData(List<Order>data);
}
