package ru.savchenko.andrey.deliveryapp.activities.registry;

public class RegPresenter {
    private static final String TAG = RegPresenter.class.getSimpleName();
    private RegView view;
    private RegInterActor interActor;

    public RegPresenter(RegView view, RegInterActor interActor) {
        this.view = view;
        this.interActor = interActor;
    }

    void onSendClick(String phone, String name){
        interActor.onSendClick(phone, name)
                .subscribe(s -> view.startConfirmActivity(),
                        throwable -> {
                            view.showToast("Произошла ошибка");
                            throwable.printStackTrace();
                        });
    }
}
