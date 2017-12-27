package ru.savchenko.andrey.deliveryapp.fragments.review;

import java.util.List;

import ru.savchenko.andrey.deliveryapp.entities.Review;

/**
 * Created by savchenko on 27.12.17.
 */

public interface ReviewView {
    void setListToAdapter(List<Review>listToAdapter);
}
