package ru.savchenko.andrey.deliveryapp.fragments.delivered.interactor;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import ru.savchenko.andrey.deliveryapp.entities.Order;

import static ru.savchenko.andrey.deliveryapp.storage.Const.DELIVERED;

/**
 * Created by Andrey on 23.09.2017.
 */
@Module
public class DeliveredInteractorImpl implements DeliveredInteractor {

    @Provides
    public DeliveredInteractorImpl deliveredInteractor(){
        return this;
    }

    @Override
    public Observable<List<Order>> getDeliveredOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Пицца с креветками", "Детали заказа", new DateTime(1504951111111L), new DateTime(), 10, "https://spb.zakazaka.ru/db/348/772/org625.jpg"));
        orders.add(new Order(1, "Суши терияки и удон", "Суши терияки и удон Картофель фри с лососем Детали заказа", new DateTime(1504959792456L), new DateTime(), 5, "https://public.superjob.ru/images/clients_logos.ru/603366_f65f9c18cf57ff58170a281ccc865fd2.jpg"));
        orders.add(new Order(1, "Одна с ананасами, две с шпинатом", "Одна с ананасами, две с шпинатом Детали заказа", new DateTime(1504959792187L), new DateTime(), 1, "https://public.superjob.ru/images/clients_logos.ru/603366_f65f9c18cf57ff58170a281ccc865fd2.jpg"));
        orders.add(new Order(1, "Девять балтика 7", "Детали заказа", new DateTime(1504959792856L), new DateTime(), 12, "https://pp.userapi.com/c618820/v618820621/a762/UHYX3xjPjhY.jpg"));
        orders.add(new Order(1, "Чайник чая", "Детали заказа", new DateTime(1504959792911L), new DateTime(), 12.5, "https://pp.userapi.com/c618820/v618820621/a762/UHYX3xjPjhY.jpg"));
        orders.add(new Order(1, "три сыра по акции", "Детали заказа", new DateTime(1504959792125L), new DateTime(), 0.5, "https://pp.userapi.com/c618820/v618820621/a762/UHYX3xjPjhY.jpg"));
        orders.add(new Order(1, "Шашлык свиной", "Детали заказа", new DateTime(1504959792586L), new DateTime(), 1.3, "https://spb.zakazaka.ru/db/348/772/org625.jpg"));
        orders.add(new Order(1, "Картофель фри с лососем", "Детали заказа", new DateTime(1504959792112L), new DateTime(), 10, "https://spb.zakazaka.ru/db/348/772/org625.jpg"));
        orders.add(new Order(1, "Картофель фри со сметаной", "Детали заказа", new DateTime(1504959792112L), new DateTime(), 10, "https://spb.zakazaka.ru/db/348/772/org625.jpg"));
        orders.add(new Order(1, "Селедка в собственном соку", "Детали заказа", new DateTime(1504959792112L), new DateTime(), 10, "https://spb.zakazaka.ru/db/348/772/org625.jpg"));

        for(Order order:orders){
            order.setStatus(DELIVERED);
            order.setRating((int) (Math.random()*5));
        }
        return Observable.just(orders);
    }
}
