package ru.savchenko.andrey.deliveryapp.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Andrey on 23.09.2017.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface DeliveryScope {
}
