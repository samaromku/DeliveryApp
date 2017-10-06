package ru.savchenko.andrey.deliveryapp.di.reviews;

import android.view.LayoutInflater;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryapp.adapters.ReviewAdapter;
import ru.savchenko.andrey.deliveryapp.entities.Review;
import ru.savchenko.andrey.deliveryapp.fragments.review.ReviewFragment;
import ru.savchenko.andrey.deliveryapp.fragments.review.ReviewViewHolderFactory;

/**
 * Created by Andrey on 06.10.2017.
 */
@Module
public class ReviewModule {
    private final ReviewFragment fragment;

    public ReviewModule(ReviewFragment fragment) {
        this.fragment = fragment;
    }

    @ReviewScope
    @Provides
    public List<Review>provideReviews(){
        return fragment.getReviews();
    }

    @ReviewScope
    @Provides
    ReviewAdapter provideAdapter(ReviewViewHolderFactory factory, List<Review>reviews){
        return new ReviewAdapter(reviews, factory);
    }

    @ReviewScope
    @Provides
    public ReviewViewHolderFactory provideFactory(LayoutInflater layoutInflater){
        return new ReviewViewHolderFactory(fragment, layoutInflater);
    }
}
