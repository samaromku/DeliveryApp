package ru.savchenko.andrey.deliveryapp.activities.registry;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.savchenko.andrey.deliveryapp.App;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.activities.confirm.ConfirmCodeActivity;
import ru.savchenko.andrey.deliveryapp.activities.registry.di.RegComponent;
import ru.savchenko.andrey.deliveryapp.activities.registry.di.RegModule;
import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.slots.PredefinedSlots;
import ru.tinkoff.decoro.watchers.FormatWatcher;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;

import static ru.savchenko.andrey.deliveryapp.storage.Const.NAME;
import static ru.savchenko.andrey.deliveryapp.storage.Const.PHONE;

public class RegActivity extends AppCompatActivity implements RegView {
    private static final String TAG = RegActivity.class.getSimpleName();
    @Inject
    RegPresenter presenter;
    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.etName)
    EditText etName;

    @OnClick(R.id.btnSend)
    void onSendClick() {
        presenter.onSendClick(etPhone.getText().toString(), etName.getText().toString());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ((RegComponent) App.getComponentManager()
                .getPresenterComponent(getClass(), new RegModule(this))).inject(this);
        ButterKnife.bind(this);

        MaskImpl mask = MaskImpl.createTerminated(PredefinedSlots.RUS_PHONE_NUMBER);
        mask.setHideHardcodedHead(false); // default value
        FormatWatcher formatWatcher = new MaskFormatWatcher(mask);
        formatWatcher.installOn(etPhone);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getComponentManager().releaseComponent(getClass());
        }
    }

    @Override
    public void startConfirmActivity() {
        startActivity(new Intent(this, ConfirmCodeActivity.class)
                        .putExtra(PHONE, etPhone.getText().toString())
                        .putExtra(NAME, etName.getText().toString()));
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
