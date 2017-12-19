package ru.savchenko.andrey.deliveryapp.dialogs;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.savchenko.andrey.deliveryapp.R;

/**
 * Created by Andrey on 19.12.2017.
 */

public class PreviewDialog extends DialogFragment {
    @BindView(R.id.etEnterOrder)EditText etEnterOrder;
    @BindView(R.id.tvOrderTitle)TextView tvOrderTitle;
    @BindView(R.id.tvOrderText)TextView tvOrderText;
    @OnClick(R.id.btnCancel)
    void onCancelClick(){
        getDialog().dismiss();
    }
    private String title;


    @OnClick(R.id.btnSearch)
    void onSearchClick(){

        tvOrderTitle.setVisibility(View.VISIBLE);
        tvOrderText.setVisibility(View.VISIBLE);

        tvOrderText.setText("Чтобы точно отслеживать заказ на карте зарегистрируйтесь в приложении");
        tvOrderTitle.setText(title);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_preview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        tvOrderTitle.setVisibility(View.GONE);
        tvOrderText.setVisibility(View.GONE);
        title = getOrdersState().get((int) (Math.random()*getOrdersState().size()-1));
    }

    List<String>getOrdersState(){
        List<String>strings = new ArrayList<>();
        strings.add("Ваш заказ готовится");
        strings.add("Ваш заказ на стадии отправки");
        strings.add("Ваш заказ уже в пути");
        strings.add("Ваш заказ где-то поблизости");
        strings.add("Мы не можем найти ваш заказ");
        return strings;
    }
}
