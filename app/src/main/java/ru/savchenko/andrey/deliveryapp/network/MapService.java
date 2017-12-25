package ru.savchenko.andrey.deliveryapp.network;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ru.savchenko.andrey.deliveryapp.entities.map.RouteResponse;

/**
 * Created by savchenko on 25.12.17.
 */

public interface MapService {
    @POST("/maps/api/directions/json")
    Observable<RouteResponse>getDirection(@Query("origin")String origin,
                                          @Query("destination")String destination,
                                          @Query("key")String key);
}
