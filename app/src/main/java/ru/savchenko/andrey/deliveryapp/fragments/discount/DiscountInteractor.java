package ru.savchenko.andrey.deliveryapp.fragments.discount;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import ru.savchenko.andrey.deliveryapp.entities.Discount;

/**
 * Created by Andrey on 30.09.2017.
 */
@Module
public class DiscountInteractor {
    @Provides
    DiscountInteractor interactor(){
        return this;
    }

    public Observable<List<Discount>> getDiscounts(){
        List<Discount>discounts = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            discounts.add(new Discount(i, "title " + i, "test", "http"));
        }
        return Observable.just(discounts);
    }
}
