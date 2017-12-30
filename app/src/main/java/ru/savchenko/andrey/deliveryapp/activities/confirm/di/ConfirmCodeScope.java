package ru.savchenko.andrey.deliveryapp.activities.confirm.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
@interface ConfirmCodeScope {
}
