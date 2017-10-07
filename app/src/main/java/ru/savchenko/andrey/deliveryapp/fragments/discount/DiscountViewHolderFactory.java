package ru.savchenko.andrey.deliveryapp.fragments.discount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;
import ru.savchenko.andrey.deliveryapp.viewholders.DiscountViewHolder;

/**
 * Created by Andrey on 07.10.2017.
 */

public class DiscountViewHolderFactory {
    private OnItemClickListener clickListener;
    private LayoutInflater inflater;
    private Context context;

    public DiscountViewHolderFactory(OnItemClickListener clickListener, LayoutInflater inflater, Context context) {
        this.clickListener = clickListener;
        this.inflater = inflater;
        this.context = context;
    }

    public DiscountViewHolder createDiscountViewHolder(ViewGroup container){
        View view = inflater.inflate(R.layout.item_discount, container, false);
        return new DiscountViewHolder(view, context, clickListener);
    }
}
