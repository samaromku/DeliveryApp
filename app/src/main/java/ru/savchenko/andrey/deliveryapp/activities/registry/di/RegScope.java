package ru.savchenko.andrey.deliveryapp.activities.registry.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
@interface RegScope {
}
