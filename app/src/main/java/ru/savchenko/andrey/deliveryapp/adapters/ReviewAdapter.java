package ru.savchenko.andrey.deliveryapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import ru.savchenko.andrey.deliveryapp.entities.Review;
import ru.savchenko.andrey.deliveryapp.fragments.review.ReviewViewHolderFactory;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;
import ru.savchenko.andrey.deliveryapp.viewholders.ReviewHolder;

/**
 * Created by savchenko on 12.09.17.
 */

public class ReviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Review> reviewList;
    private ReviewViewHolderFactory factory;

    public ReviewAdapter(List<Review> reviewList, ReviewViewHolderFactory factory) {
        this.reviewList = reviewList;
        this.factory = factory;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return factory.createReviewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Review review = reviewList.get(position);
        ((ReviewHolder) holder).bind(review);
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }
}
