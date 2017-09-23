package ru.savchenko.andrey.deliveryapp.interfaces;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andrey on 09.09.2017.
 */
public interface OnItemClickListener {
    void onclick(int position);
}
