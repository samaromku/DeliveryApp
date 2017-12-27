package ru.savchenko.andrey.deliveryapp.fragments.discount;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.savchenko.andrey.deliveryapp.entities.Discount;


public interface DiscountView extends MvpView {
    void setData(List<Discount> data);
}
