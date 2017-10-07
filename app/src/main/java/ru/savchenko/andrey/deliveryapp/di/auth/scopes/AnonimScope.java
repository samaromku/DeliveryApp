package ru.savchenko.andrey.deliveryapp.di.auth.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Andrey on 07.10.2017.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface AnonimScope {
}
