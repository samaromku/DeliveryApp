package ru.savchenko.andrey.deliveryapp.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.savchenko.andrey.deliveryapp.R;

import static ru.savchenko.andrey.deliveryapp.storage.Const.SEND_REVIEW;

/**
 * Created by Andrey on 11.09.2017.
 */

public class ReviewDialog extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle(SEND_REVIEW);
        View view = inflater.inflate(R.layout.dialog_review, container);

        return view;
    }
}
