package ru.savchenko.andrey.deliveryapp.di.delivered;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by savchenko on 27.12.17.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface DeliveredScope {
}
