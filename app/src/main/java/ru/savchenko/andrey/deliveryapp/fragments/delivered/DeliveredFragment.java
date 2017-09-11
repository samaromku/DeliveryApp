package ru.savchenko.andrey.deliveryapp.fragments.delivered;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.adapters.CurrentOrdersAdapter;
import ru.savchenko.andrey.deliveryapp.base.BaseFragment;
import ru.savchenko.andrey.deliveryapp.entities.Order;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;

import static android.content.ContentValues.TAG;
import static ru.savchenko.andrey.deliveryapp.storage.Const.DELIVERED;

/**
 * Created by Andrey on 09.09.2017.
 */

public class DeliveredFragment extends BaseFragment implements OnItemClickListener{
    @BindView(R.id.rvCurrentOrders)
    RecyclerView rvCurrentOrders;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_delivered, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        onChangeTitle.changeTitle(R.string.delivered);
        initRv();
    }

    private void initRv() {
        rvCurrentOrders.setLayoutManager(new LinearLayoutManager(getActivity()));
        CurrentOrdersAdapter adapter = new CurrentOrdersAdapter(this);
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Пицца с креветками", "Детали заказа", new DateTime(1504951111111L), new DateTime(), 10));
        orders.add(new Order(1, "Суши терияки и удон", "Суши терияки и удон Картофель фри с лососем Детали заказа", new DateTime(1504959792456L), new DateTime(), 5));
        orders.add(new Order(1, "Одна с ананасами, две с шпинатом", "Одна с ананасами, две с шпинатом Детали заказа", new DateTime(1504959792187L), new DateTime(), 1));
        orders.add(new Order(1, "Девять балтика 7", "Детали заказа", new DateTime(1504959792856L), new DateTime(), 12));
        orders.add(new Order(1, "Чайник чая", "Детали заказа", new DateTime(1504959792911L), new DateTime(), 12.5));
        orders.add(new Order(1, "три сыра по акции", "Детали заказа", new DateTime(1504959792125L), new DateTime(), 0.5));
        orders.add(new Order(1, "Шашлык свиной", "Детали заказа", new DateTime(1504959792586L), new DateTime(), 1.3));
        orders.add(new Order(1, "Картофель фри с лососем", "Детали заказа", new DateTime(1504959792112L), new DateTime(), 10));
        orders.add(new Order(1, "Картофель фри со сметаной", "Детали заказа", new DateTime(1504959792112L), new DateTime(), 10));
        orders.add(new Order(1, "Селедка в собственном соку", "Детали заказа", new DateTime(1504959792112L), new DateTime(), 10));

        for(Order order:orders){
            order.setStatus(DELIVERED);
            order.setRating((int) (Math.random()*5));
        }

        adapter.setData(orders);
        rvCurrentOrders.setAdapter(adapter);
    }

    @Override
    public void onclick(int position) {
        Log.i(TAG, "onclick: " + position);
    }
}
