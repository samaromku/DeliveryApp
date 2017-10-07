package ru.savchenko.andrey.deliveryapp.fragments.review;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.viewholders.ReviewHolder;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;

/**
 * Created by Andrey on 06.10.2017.
 */

public class ReviewViewHolderFactory {
    private OnItemClickListener listener;
    private LayoutInflater inflater;

    public ReviewViewHolderFactory(OnItemClickListener listener, LayoutInflater inflater) {
        this.listener = listener;
        this.inflater = inflater;
    }

    public ReviewHolder createReviewHolder(ViewGroup parent){
        View view = inflater.inflate(R.layout.item_review, parent, false);
        return new ReviewHolder(view, listener);
    }
}
