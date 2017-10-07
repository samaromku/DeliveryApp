package ru.savchenko.andrey.deliveryapp.adapters;

import android.view.ViewGroup;

import ru.savchenko.andrey.deliveryapp.base.BaseAdapter;
import ru.savchenko.andrey.deliveryapp.base.BaseViewHolder;
import ru.savchenko.andrey.deliveryapp.entities.Discount;
import ru.savchenko.andrey.deliveryapp.fragments.discount.DiscountViewHolderFactory;


/**
 * Created by Andrey on 30.09.2017.
 */

public class DiscountAdapter extends BaseAdapter<Discount> {
    DiscountViewHolderFactory factory;

    public DiscountAdapter(DiscountViewHolderFactory factory) {
        this.factory = factory;
    }

    @Override
    public BaseViewHolder<Discount> onCreateViewHolder(ViewGroup parent, int viewType) {
        return factory.createDiscountViewHolder(parent);
    }
}
