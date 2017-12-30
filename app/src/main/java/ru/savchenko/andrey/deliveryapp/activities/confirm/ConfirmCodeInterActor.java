package ru.savchenko.andrey.deliveryapp.activities.confirm;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.savchenko.andrey.deliveryapp.entities.Data;
import ru.savchenko.andrey.deliveryapp.entities.Message;
import ru.savchenko.andrey.deliveryapp.entities.MessageId;
import ru.savchenko.andrey.deliveryapp.network.FirebaseService;

public class ConfirmCodeInterActor {
    private static final String TAG = ConfirmCodeInterActor.class.getSimpleName();
    private FirebaseService service;
    private int timePassed = 60;
    private int count = 3;

    public ConfirmCodeInterActor(FirebaseService service) {
        this.service = service;
    }

    Observable<Integer>updateCount(){
        count--;
        return Observable.just(count);
    }

    Observable<MessageId> onRetryClick(String phone, String name){
        Message message = new Message("/topics/pizda", new Data(phone, name));
        return service.sendMessage(message)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    Observable<Long>setInterval(){
        return Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    int getTimePassed() {
        return timePassed;
    }

    void setTimePassed(int timePassed) {
        this.timePassed = timePassed;
    }

    public int getCount() {
        return count;
    }
}
