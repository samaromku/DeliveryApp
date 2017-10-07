package ru.savchenko.andrey.deliveryapp.di.base;

import ru.savchenko.andrey.deliveryapp.activities.auth.AuthActivity;

/**
 * Created by Andrey on 07.10.2017.
 */

public interface BaseAuthComponent {
    public void inject(AuthActivity authActivity);
}
