package ru.savchenko.andrey.deliveryapp.activities.registry;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import br.com.sapereaude.maskedEditText.MaskedEditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.activities.confirm.ConfirmActivity;
import ru.savchenko.andrey.deliveryapp.base.BaseActivity;
import ru.savchenko.andrey.deliveryapp.di.ComponentManager;
import ru.savchenko.andrey.deliveryapp.entities.Data;
import ru.savchenko.andrey.deliveryapp.entities.Message;
import ru.savchenko.andrey.deliveryapp.network.FirebaseService;
import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.slots.PredefinedSlots;
import ru.tinkoff.decoro.watchers.FormatWatcher;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;

import static ru.savchenko.andrey.deliveryapp.storage.Const.NAME;
import static ru.savchenko.andrey.deliveryapp.storage.Const.PHONE;

/**
 * Created by Andrey on 17.12.2017.
 */

public class RegistryActivity extends BaseActivity {
    public static final String TAG = "RegistryActivity";
    @Inject
    FirebaseService service;
    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.etName)
    EditText etName;

    @OnClick(R.id.btnSend)
    void onSendClick() {
        Message message = new Message("/topics/pizda", new Data(etPhone.getText().toString(), etName.getText().toString()));

        service.sendMessage(message)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> startActivity
                                (new Intent(this, ConfirmActivity.class)
                                .putExtra(PHONE, etPhone.getText().toString())
                                .putExtra(NAME, etName.getText().toString())),
                        throwable -> {
                            Toast.makeText(this, "Произошла ошибка", Toast.LENGTH_SHORT).show();
                            throwable.printStackTrace();
                        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);
        ComponentManager.getAppComponent().inject(this);
        ButterKnife.bind(this);

        MaskImpl mask = MaskImpl.createTerminated(PredefinedSlots.RUS_PHONE_NUMBER);
        mask.setHideHardcodedHead(false); // default value
        FormatWatcher formatWatcher = new MaskFormatWatcher(mask);
        formatWatcher.installOn(etPhone);
    }
}
