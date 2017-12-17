package ru.savchenko.andrey.deliveryapp.network;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Andrey on 17.12.2017.
 */

public interface FirebaseService {
    @POST("/fcm/send")
    public Observable<String> sendMessage(@Body String message);
}
