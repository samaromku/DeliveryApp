package ru.savchenko.andrey.deliveryapp.di;

import android.util.Log;

import ru.savchenko.andrey.deliveryapp.App;
import ru.savchenko.andrey.deliveryapp.di.reviews.ReviewComponent;
import ru.savchenko.andrey.deliveryapp.fragments.review.ReviewFragment;
import ru.savchenko.andrey.deliveryapp.di.reviews.ReviewModule;

import static android.content.ContentValues.TAG;

/**
 * Created by Andrey on 23.09.2017.
 */

public class ComponentManager {
    private static AppComponent appComponent;
    private static DeliveryComponent deliveryComponent;
    private static ReviewComponent reviewComponent;

    public static ReviewComponent initReviewComponent(ReviewFragment fragment){
        reviewComponent = appComponent.reviewComponent(new ReviewModule(fragment));
        return reviewComponent;
    }

    public static ReviewComponent getReviewComponent(){
        return reviewComponent;
    }

    public static void destroyReviewComponent(){
        reviewComponent = null;
    }

    public static DeliveryComponent getDeliveryComponent() {
        return deliveryComponent;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static void init(App app){
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(app))
                .build();
    }

    public static void initDeliveryComponent(){
        deliveryComponent = DaggerDeliveryComponent
                .builder()
                .appComponent(appComponent)
                .build();
    }

    public static void destroyDeliveryComponent(){
        deliveryComponent = null;
        Log.i(TAG, "destroyDeliveryComponent: ");
    }
}
