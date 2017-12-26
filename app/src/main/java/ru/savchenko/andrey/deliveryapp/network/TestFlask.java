package ru.savchenko.andrey.deliveryapp.network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ru.savchenko.andrey.deliveryapp.entities.Order;
import ru.savchenko.andrey.deliveryapp.entities.Token;

/**
 * Created by savchenko on 26.12.17.
 */

public interface TestFlask {
    @GET("/kuzya")
    Observable<String>flaskTest();

    @POST("/kuzya")
    Observable<String>flaskTestPost();

    @GET("/auth")
    Observable<Token>auth(@Query("userName")String userName,
                          @Query("password")String password);

    @GET("/get_current")
    Observable<List<Order>>getCurrent();
}
