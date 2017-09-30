package ru.savchenko.andrey.deliveryapp.base;

import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

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

    protected void changeToolbarTitle(@StringRes int title){
        ActionBar toolbar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if(toolbar!=null){
            toolbar.setTitle(title);
        }
    }
}
