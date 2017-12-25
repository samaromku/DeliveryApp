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

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.activities.map.MapsActivity;
import ru.savchenko.andrey.deliveryapp.adapters.CurrentOrdersAdapter;
import ru.savchenko.andrey.deliveryapp.base.BaseFragment;
import ru.savchenko.andrey.deliveryapp.di.ComponentManager;
import ru.savchenko.andrey.deliveryapp.entities.MapParams;
import ru.savchenko.andrey.deliveryapp.entities.Order;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.presenter.CurrentPresenterImpl;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.view.CurrentView;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;
import ru.savchenko.andrey.deliveryapp.network.MapService;

import static ru.savchenko.andrey.deliveryapp.activities.main.DeliveryActivity.TAG;

/**
 * Created by Andrey on 09.09.2017.
 */
public class FragmentCurrentOrders extends BaseFragment implements OnItemClickListener, CurrentView{
    @InjectPresenter CurrentPresenterImpl presenter;
    @BindView(R.id.rvCurrentOrders) RecyclerView rvCurrentOrders;
    @Inject CurrentOrdersAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_orders, container, false);
        ButterKnife.bind(this, view);
        ComponentManager.getAppComponent().injectCurrentFragment(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRv();
        if(onChangeTitle!=null)
        onChangeTitle.changeTitle(R.string.my_orders);
    }

    private void initRv() {
        rvCurrentOrders.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.init();
        presenter.getOrderList();
    }

    @Override
    public void setDataList(List<Order> orders) {
        adapter.setClickListener(this);
        adapter.setData(orders);
        rvCurrentOrders.setAdapter(adapter);
    }

    @Override
    public void onClick(int position) {
        startActivity(new Intent(getActivity(), MapsActivity.class));
    }
}
