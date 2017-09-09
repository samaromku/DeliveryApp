package ru.savchenko.andrey.deliveryapp.base;

import android.support.v4.app.Fragment;

import ru.savchenko.andrey.deliveryapp.interfaces.OnChangeTitle;

/**
 * Created by Andrey on 09.09.2017.
 */

public class BaseFragment extends Fragment {
    protected OnChangeTitle onChangeTitle;

    public void setOnChangeTitle(OnChangeTitle onChangeTitle) {
        this.onChangeTitle = onChangeTitle;
    }
}
