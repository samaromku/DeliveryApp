package ru.savchenko.andrey.deliveryapp.network;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.savchenko.andrey.deliveryapp.entities.Message;
import ru.savchenko.andrey.deliveryapp.entities.MessageId;

/**
 * Created by Andrey on 17.12.2017.
 */

public interface FirebaseService {
    @POST("/fcm/send")
    public Observable<MessageId> sendMessage(@Body Message message);
}
