package ru.savchenko.andrey.deliveryapp.fragments.current_orders;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryapp.App;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.activities.map.MapsActivity;
import ru.savchenko.andrey.deliveryapp.adapters.CurrentOrdersAdapter;
import ru.savchenko.andrey.deliveryapp.base.BaseFragment;
import ru.savchenko.andrey.deliveryapp.di.current.CurrentComponent;
import ru.savchenko.andrey.deliveryapp.di.current.CurrentModule;
import ru.savchenko.andrey.deliveryapp.entities.Order;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.presenter.CurrentPresenterImpl;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.view.CurrentView;
import ru.savchenko.andrey.deliveryapp.interfaces.OnCircleSet;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;

/**
 * Created by Andrey on 09.09.2017.
 */
public class FragmentCurrentOrders extends BaseFragment implements OnItemClickListener, CurrentView, OnCircleSet {
    @Inject CurrentPresenterImpl presenter;
    @BindView(R.id.rvCurrentOrders) RecyclerView rvCurrentOrders;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_orders, container, false);
        ButterKnife.bind(this, view);
        ((CurrentComponent)App.getComponentManager()
                .getPresenterComponent(getClass(), new CurrentModule(this))).inject(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRv();
        if(onChangeTitle!=null)
        onChangeTitle.changeTitle(R.string.my_orders);
//        testFlask.flaskTestPost()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(s -> Log.i(TAG, "auth: " +s), Throwable::printStackTrace);
    }

    @Override
    public void onDestroy() {
        App.getComponentManager().releaseComponent(getClass());
        super.onDestroy();
    }

    private void initRv() {
        rvCurrentOrders.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.getOrderList();
    }

    @Override
    public void setDataList(List<Order> orders) {
        CurrentOrdersAdapter adapter = new CurrentOrdersAdapter();
        adapter.setClickListener(this);
        adapter.setData(orders);
        adapter.setOnCircleSet(this);
        rvCurrentOrders.setAdapter(adapter);
    }

    @Override
    public void onClick(int position) {
        startActivity(new Intent(getActivity(), MapsActivity.class));
    }

    @Override
    public void onCircleSet(String url, ImageView imageView) {

    }

    @Override
    public void onClickReview(int position) {

    }
}
