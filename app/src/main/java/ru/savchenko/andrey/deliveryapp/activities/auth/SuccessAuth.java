package ru.savchenko.andrey.deliveryapp.activities.auth;

import android.content.Context;
import android.content.Intent;

import ru.savchenko.andrey.deliveryapp.activities.main.DeliveryActivity;

/**
 * Created by Andrey on 07.10.2017.
 */

public class SuccessAuth implements AuthShowAnimation{
    private Context context;

    public SuccessAuth(Context context) {
        this.context = context;
    }

    @Override
    public void showAnimation() {
        context.startActivity(new Intent(context, DeliveryActivity.class));
    }
}
