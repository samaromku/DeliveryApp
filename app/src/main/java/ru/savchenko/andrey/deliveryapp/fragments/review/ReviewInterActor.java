package ru.savchenko.andrey.deliveryapp.fragments.review;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import ru.savchenko.andrey.deliveryapp.entities.Review;

/**
 * Created by savchenko on 27.12.17.
 */

public class ReviewInterActor {
    public Observable<List<Review>> getReviews(){
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review(1, "Заказ доставили очень быстро", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 5, "Станислав"));
        reviews.add(new Review(1, "Очень хорошо!", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 4, "Станислав"));
        reviews.add(new Review(1, "Долго ехал курьер", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 3, "Станислав"));
        reviews.add(new Review(1, "Не положили подарок на День Рождения", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 2, "Станислав"));
        reviews.add(new Review(1, "Курьер съел мою пиццу(((", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 1, "Станислав"));
        reviews.add(new Review(1, "Заказ доставили очень быстро", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 5, "Станислав"));
        reviews.add(new Review(1, "Заказ доставили очень быстро", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 5, "Станислав"));
        reviews.add(new Review(1, "Заказ доставили очень быстро", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 4, "Станислав"));
        reviews.add(new Review(1, "Заказ доставили очень быстро", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 4, "Станислав"));
        reviews.add(new Review(1, "Заказ доставили очень быстро", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 4, "Станислав"));

        return Observable.fromCallable(() -> reviews);
    }
}
