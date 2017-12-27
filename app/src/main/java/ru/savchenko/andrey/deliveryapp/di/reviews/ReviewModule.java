package ru.savchenko.andrey.deliveryapp.di.reviews;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryapp.fragments.review.ReviewFragment;
import ru.savchenko.andrey.deliveryapp.fragments.review.ReviewInterActor;
import ru.savchenko.andrey.deliveryapp.fragments.review.ReviewPresenter;

/**
 * Created by Andrey on 06.10.2017.
 */
@Module
public class ReviewModule {
    private final ReviewFragment fragment;

    public ReviewModule(ReviewFragment fragment) {
        this.fragment = fragment;
    }

//    @ReviewScope
//    @Provides
//    List<Review>provideReviews(){
//        return fragment.getReviews();
//    }

//    @ReviewScope
//    @Provides
//    ReviewAdapter provideAdapter(ReviewViewHolderFactory factory, List<Review>reviews){
//        return new ReviewAdapter(reviews, factory);
//    }

//    @ReviewScope
//    @Provides
//    ReviewViewHolderFactory provideFactory(LayoutInflater layoutInflater){
//        return new ReviewViewHolderFactory(fragment, layoutInflater);
//    }

    @ReviewScope
    @Provides
    ReviewPresenter presenter(ReviewInterActor interActor){
        return new ReviewPresenter(fragment, interActor);
    }

    @ReviewScope
    @Provides
    ReviewInterActor interActor(){
        return new ReviewInterActor();
    }
}
