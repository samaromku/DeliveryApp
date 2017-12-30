package ru.savchenko.andrey.deliveryapp.activities.registry;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.savchenko.andrey.deliveryapp.entities.Data;
import ru.savchenko.andrey.deliveryapp.entities.Message;
import ru.savchenko.andrey.deliveryapp.entities.MessageId;
import ru.savchenko.andrey.deliveryapp.network.FirebaseService;

public class RegInterActor {
    private static final String TAG = RegInterActor.class.getSimpleName();

    private FirebaseService service;

    public RegInterActor(FirebaseService service) {
        this.service = service;
    }

    Observable<MessageId> onSendClick(String phone, String name) {
        Message message = new Message("/topics/pizda", new Data(phone, name));

        return service.sendMessage(message)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
