package ru.savchenko.andrey.deliveryapp.activities.auth;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Andrey on 07.10.2017.
 */

public class ErrorAuth implements AuthShowAnimation{
    private Context context;

    public ErrorAuth(Context context) {
        this.context = context;
    }

    @Override
    public void showAnimation() {
        Toast.makeText(context, "Заполните поле логин и пароль", Toast.LENGTH_SHORT).show();
    }
}
