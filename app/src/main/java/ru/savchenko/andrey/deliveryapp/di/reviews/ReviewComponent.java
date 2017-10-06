package ru.savchenko.andrey.deliveryapp.di.reviews;

import dagger.Subcomponent;
import ru.savchenko.andrey.deliveryapp.fragments.review.ReviewFragment;

/**
 * Created by Andrey on 06.10.2017.
 */
@ReviewScope
@Subcomponent(modules = ReviewModule.class)
public interface ReviewComponent {
    void inject(ReviewFragment fragment);
}
