package ru.savchenko.andrey.deliveryapp.activities.confirm;

import io.reactivex.disposables.CompositeDisposable;

import static ru.savchenko.andrey.deliveryapp.storage.Const.ASK_AGAIN;
import static ru.savchenko.andrey.deliveryapp.storage.Const.TRY_COUNT;

public class ConfirmCodePresenter {
    private static final String TAG = ConfirmCodePresenter.class.getSimpleName();
    private ConfirmCodeView view;
    private ConfirmCodeInterActor interActor;
    private CompositeDisposable cp;


    public ConfirmCodePresenter(ConfirmCodeView view, ConfirmCodeInterActor interActor) {
        this.view = view;
        this.interActor = interActor;
        cp = new CompositeDisposable();
    }

    void onRetryClick(String phone, String name){
        interActor.onRetryClick(phone, name)
                .subscribe(s -> interActor.setTimePassed(60),
                        throwable -> view.showToast("Произошла ошибка"));
    }

    void setInterval(){
        cp.add(interActor.setInterval()
                .subscribe(aLong -> {
                    if (interActor.getTimePassed() <= 0) {
                        view.setBtnParameters(true, ASK_AGAIN,"#0097A7");
                        return;
                    }
                    interActor.setTimePassed(interActor.getTimePassed()-1);
                    view.setBtnParameters(false, ASK_AGAIN + " (" + interActor.getTimePassed() + ")", "#b6b5af");
                }));
    }

    void updateCount(){
        interActor.updateCount()
                .subscribe(integer -> {
                    view.tvTryCountSetText(TRY_COUNT + " " + integer);
                    if(integer<=0){
                        view.finishAllActivities();
                    }
                    // FIXME: 19.12.17 скинуть код из смс на сервер вместе с телефоном и именем - провереный!
                });
    }

    void getCountSetText(){
        view.tvTryCountSetText(TRY_COUNT + " " + interActor.getCount());
    }

    void onDestroy(){
        cp.clear();
    }
}
