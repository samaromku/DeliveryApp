package ru.savchenko.andrey.deliveryapp.base;

import com.arellomobile.mvp.MvpAppCompatFragment;

import ru.savchenko.andrey.deliveryapp.interfaces.OnChangeTitle;

/**
 * Created by Andrey on 09.09.2017.
 */

public class BaseFragment extends MvpAppCompatFragment {
    protected OnChangeTitle onChangeTitle;

    public void setOnChangeTitle(OnChangeTitle onChangeTitle) {
        this.onChangeTitle = onChangeTitle;
    }
}
