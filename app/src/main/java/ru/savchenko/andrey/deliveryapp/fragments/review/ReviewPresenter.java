package ru.savchenko.andrey.deliveryapp.fragments.review;

/**
 * Created by savchenko on 27.12.17.
 */

public class ReviewPresenter {
    private ReviewView view;
    private ReviewInterActor interActor;

    public ReviewPresenter(ReviewView view, ReviewInterActor interActor) {
        this.view = view;
        this.interActor = interActor;
    }

    void getReviews(){
        interActor.getReviews()
                .subscribe(reviews -> view.setListToAdapter(reviews));
    }
}
