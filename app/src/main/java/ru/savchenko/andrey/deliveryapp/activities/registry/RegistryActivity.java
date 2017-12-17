package ru.savchenko.andrey.deliveryapp.activities.registry;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.base.BaseActivity;

/**
 * Created by Andrey on 17.12.2017.
 */

public class RegistryActivity extends BaseActivity {
    @BindView(R.id.etPhone)
    EditText etPhone;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);
        ButterKnife.bind(this);
        final String[] lastChar = {" "};
        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                int digits = etPhone.getText().toString().length();
                if (digits > 1)
                    lastChar[0] = etPhone.getText().toString().substring(digits - 1);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int digits = etPhone.getText().toString().length();
                Log.d("LENGTH", "" + digits);
                if (!lastChar[0].equals("-")) {
                    if(digits == 1){
                        etPhone.append("(");
                    }
                    if(digits == 5){
                        etPhone.append(")");
                    }

                    if (digits == 9) {
                        etPhone.append("-");
                    }


                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
