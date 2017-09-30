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
        discounts.add(new Discount(1, "Две большие пепперони", "Две большие пепперони. Закажи две большие пепперони со скидкой 20%. Действует на доставку и самовывоз",
                "https://dodopizzaru-a.akamaihd.net/Img/BonusActionBanners/Gallery/b1466d86f2184c24afc2f2b3a7e89573.jpeg"));
        discounts.add(new Discount(2, "Корпоратив. Купи четыре больших - плати за три", "Устройте праздник на работе! С понедельника по четверг с 9:00 до 17:00 любые четыре большие пиццы диаметром 35 см по цене трех - всего за 1905 рублей * Акция не действует в выходные, праздничные и предпраздничные дни.",
                "https://dodopizzaru-a.akamaihd.net/Img/BonusActionBanners/Gallery/ac78d7ebe82746e2bb27c53d7b870198.jpeg"));
        discounts.add(new Discount(3, "Бизнес - ланч", "Вкусный и быстрый обед не выходя из офиса! С понедельника по четверг с 11:00 до 14:00 вы можете заказать 2 любые пиццы среднего размера (30 см) со скидкой 30%. Доставка всегда бесплатно! *Акция не действует в выходные, праздничные и предпраздничные дни.",
                "https://dodopizzaru-a.akamaihd.net/Img/BonusActionBanners/Gallery/8717cb15066844e5b21ca0c000748a48.jpeg"));
        for (int i = 4; i < 20; i++) {
            discounts.add(new Discount(i, "title " + i, "test", "http"));
        }
        return Observable.just(discounts);
    }
}
