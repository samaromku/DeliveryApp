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
        discounts.add(new Discount(1, "ДОДО", "Две большие пепперони", "Две большие пепперони. Закажи две большие пепперони со скидкой 20%. Действует на доставку и самовывоз",
                "https://dodopizzaru-a.akamaihd.net/Img/BonusActionBanners/Gallery/b1466d86f2184c24afc2f2b3a7e89573.jpeg"));
        discounts.add(new Discount(2, "ДОДО", "Корпоратив. Купи четыре больших - плати за три", "Устройте праздник на работе! С понедельника по четверг с 9:00 до 17:00 любые четыре большие пиццы диаметром 35 см по цене трех - всего за 1905 рублей * Акция не действует в выходные, праздничные и предпраздничные дни.",
                "https://dodopizzaru-a.akamaihd.net/Img/BonusActionBanners/Gallery/ac78d7ebe82746e2bb27c53d7b870198.jpeg"));
        discounts.add(new Discount(3, "ДОДО", "Бизнес - ланч", "Вкусный и быстрый обед не выходя из офиса! С понедельника по четверг с 11:00 до 14:00 вы можете заказать 2 любые пиццы среднего размера (30 см) со скидкой 30%. Доставка всегда бесплатно! *Акция не действует в выходные, праздничные и предпраздничные дни.",
                "https://dodopizzaru-a.akamaihd.net/Img/BonusActionBanners/Gallery/8717cb15066844e5b21ca0c000748a48.jpeg"));
        discounts.add(new Discount(4, "Ёха", "Купи пиццу - получи бокал пива в подарок!", "Купи большую американскую пиццу и получи один бокал пива в подарок! Акция действует с 15.00 до 23.00 в ресторане Ёха по адресу ул. Зипповская, 10. Подробности уточняйте у сторудников ресторана. Внимание, акция доступна только лицам, достигшим 18 лет!", "http://www.exa-pizza.ru/sites/default/files/styles/actions/public/actions/img_1644-01-12-16-15-41.jpeg?itok=cjFz-4v3"));
        discounts.add(new Discount(5, "Антей сервис", "ВЕНИКИ ВАРЕНИКИ: КАКОЕ ЛЕТО БЕЗ КВАСА?!", "Какое лето без кваса! Семейный ресторан «Веники-Вареники» славится фирменными рецептами, здесь квас готовят сами: классический белый, облепиховый, ягодно-мятный. Какой любите вы? Закажите квас из ресторана «Веники-Вареники», мы привезём его домой или в офис! Стоимость — 600 рублей (объём 1,8 литра). Осторожно: этот напиток вызывает радость!", "http://antei-service.ru/_site/files/images/news/1506535212/1522258399_image_15009769322588.jpg_big.jpeg"));

        return Observable.just(discounts);
    }
}
