package ru.savchenko.andrey.deliveryapp.fragments.current_orders;

import android.content.Intent;
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
import ru.savchenko.andrey.deliveryapp.activities.map.MapsActivity;
import ru.savchenko.andrey.deliveryapp.adapters.CurrentOrdersAdapter;
import ru.savchenko.andrey.deliveryapp.base.BaseFragment;
import ru.savchenko.andrey.deliveryapp.entities.Order;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;

import static android.content.ContentValues.TAG;

/**
 * Created by Andrey on 09.09.2017.
 */

public class FragmentCurrentOrders extends BaseFragment implements OnItemClickListener{
    @BindView(R.id.rvCurrentOrders)
    RecyclerView rvCurrentOrders;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_orders, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onViewCreated: ");
        initRv();
        onChangeTitle.changeTitle(R.string.my_orders);
    }

    private void initRv() {
        rvCurrentOrders.setLayoutManager(new LinearLayoutManager(getActivity()));
        CurrentOrdersAdapter adapter = new CurrentOrdersAdapter(this);
        List<Order>orders = new ArrayList<>();
        orders.add(new Order(1, "test", "Пицца с креветками", new DateTime(1504951111111L), new DateTime(), 10));
        orders.add(new Order(1, "test", "Суши терияки и удон", new DateTime(1504959792456L), new DateTime(), 5));
        orders.add(new Order(1, "test", "Одна с ананасами, две с шпинатом", new DateTime(1504959792187L), new DateTime(), 1));
        orders.add(new Order(1, "test", "Девять балтика 7", new DateTime(1504959792856L), new DateTime(), 12));
        orders.add(new Order(1, "test", "Чайник чая", new DateTime(1504959792911L), new DateTime(), 12.5));
        orders.add(new Order(1, "test", "три сыра по акции", new DateTime(1504959792125L), new DateTime(), 0.5));
        orders.add(new Order(1, "test", "Шашлык свиной", new DateTime(1504959792586L), new DateTime(), 1.3));
        orders.add(new Order(1, "test", "Картофель фри с лососем", new DateTime(1504959792112L), new DateTime(), 10));
        orders.add(new Order(1, "test", "Картофель фри с лососем", new DateTime(1504959792112L), new DateTime(), 10));
        orders.add(new Order(1, "test", "Картофель фри с лососем", new DateTime(1504959792112L), new DateTime(), 10));

        adapter.setData(orders);
        rvCurrentOrders.setAdapter(adapter);
    }

    @Override
    public void onclick(int position) {
        startActivity(new Intent(getActivity(), MapsActivity.class));
    }
}
