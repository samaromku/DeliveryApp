package ru.savchenko.andrey.deliveryapp.di;

import android.util.Log;

import ru.savchenko.andrey.deliveryapp.App;
import ru.savchenko.andrey.deliveryapp.di.auth.components.AnonimComponent;
import ru.savchenko.andrey.deliveryapp.di.auth.components.AuthComponent;
import ru.savchenko.andrey.deliveryapp.di.auth.modules.AnonimModule;
import ru.savchenko.andrey.deliveryapp.di.auth.modules.AuthModule;
import ru.savchenko.andrey.deliveryapp.di.auth.base.BaseAuthComponent;
import ru.savchenko.andrey.deliveryapp.di.delivered.DeliveredComponent;
import ru.savchenko.andrey.deliveryapp.di.delivered.DeliveredModule;
import ru.savchenko.andrey.deliveryapp.di.discount.DiscountComponent;
import ru.savchenko.andrey.deliveryapp.di.discount.DiscountModule;
import ru.savchenko.andrey.deliveryapp.di.reviews.ReviewComponent;
import ru.savchenko.andrey.deliveryapp.di.reviews.ReviewModule;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.DeliveredFragment;
import ru.savchenko.andrey.deliveryapp.fragments.discount.ui.fragment.discount.DiscountFragment;
import ru.savchenko.andrey.deliveryapp.fragments.review.ReviewFragment;

import static android.content.ContentValues.TAG;

/**
 * Created by Andrey on 23.09.2017.
 */

public class ComponentManager {
    private static AppComponent appComponent;
    private static ReviewComponent reviewComponent;
    private static DiscountComponent discountComponent;
    private static AuthComponent authComponent;
    private static AnonimComponent anonimComponent;
    private static DeliveredComponent deliveredComponent;

    public static BaseAuthComponent getBaseAuthComponent(boolean isAuth){
        if(isAuth){
            return initAuthComponent();
        }else {
            return initAnonimComponent();
        }
    }

    public static void destroyBaseAuthComponent(){
        anonimComponent = null;
        authComponent = null;
    }


    public static ReviewComponent initReviewComponent(ReviewFragment fragment){
        if(reviewComponent==null) {
            reviewComponent = appComponent.reviewComponent(new ReviewModule(fragment));
        }
        return reviewComponent;
    }

    private static AuthComponent initAuthComponent(){
        if(authComponent==null) {
            authComponent = appComponent.authComponent(new AuthModule());
        }
        return authComponent;
    }

    private static AnonimComponent initAnonimComponent(){
        if(anonimComponent==null) {
            anonimComponent = appComponent.anonimComponent(new AnonimModule());
        }
        return anonimComponent;
    }



    public static DiscountComponent initDiscountComponent(DiscountFragment fragment){
        if(discountComponent==null){
            discountComponent = appComponent.discountComponent(new DiscountModule(fragment));
        }
        return discountComponent;
    }

    public static void destroyDiscountComponent(){
        discountComponent = null;
    }

    public static void destroyAuthComponent(){
        authComponent = null;
    }

    public static void destroyReviewComponent(){
        reviewComponent = null;
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

    public static DeliveredComponent getDeliveredComponent(DeliveredFragment deliveredFragment){
        if(deliveredComponent==null){
            deliveredComponent = appComponent
                    .deliveredComponent(new DeliveredModule(deliveredFragment));
        }
        return deliveredComponent;
    }
}
