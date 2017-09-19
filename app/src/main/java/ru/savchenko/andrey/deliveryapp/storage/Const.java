package ru.savchenko.andrey.deliveryapp.storage;

/**
 * Created by Andrey on 10.09.2017.
 */

public interface Const {
    int NOT_DELIVERED = 0;
    int DELIVERED = 1;
    int IN_WAY = 2;
    int ERROR_ORDER = 3;
    int ORDER_MODERATION = 4;

    String RATING_1 = "Отлично";
    String RATING_2 = "Хорошо";
    String RATING_3 = "Нормально";
    String RATING_4 = "Плохо";
    String RATING_5 = "Ужасно";
    String SEND_REVIEW = "Оставить отзыв";
}
