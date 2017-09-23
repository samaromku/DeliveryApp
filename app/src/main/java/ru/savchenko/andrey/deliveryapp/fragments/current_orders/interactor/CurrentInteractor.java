package ru.savchenko.andrey.deliveryapp.fragments.current_orders.interactor;

import java.util.List;

import io.reactivex.Observable;
import ru.savchenko.andrey.deliveryapp.entities.Order;

/**
 * Created by Andrey on 23.09.2017.
 */

public interface CurrentInteractor {
    Observable<List<Order>> getOrderList();
}
