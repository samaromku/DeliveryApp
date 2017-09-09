package ru.savchenko.andrey.deliveryapp.base;

import android.graphics.Color;
import android.support.annotation.StringRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import ru.savchenko.andrey.deliveryapp.R;

/**
 * Created by Andrey on 09.09.2017.
 */

public class BaseActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected FloatingActionButton fab;

    protected void initToolbar(@StringRes int title){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
        getSupportActionBar().setTitle(title);
        toolbar.setTitleTextColor(Color.WHITE);
    }

    protected void changeToolbarTitle(@StringRes int title){
        if(getSupportActionBar()!=null)
            getSupportActionBar().setTitle(title);
    }
}
