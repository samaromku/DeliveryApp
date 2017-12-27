package ru.savchenko.andrey.deliveryapp.fragments.delivered;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryapp.App;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.adapters.CurrentOrdersAdapter;
import ru.savchenko.andrey.deliveryapp.base.BaseFragment;
import ru.savchenko.andrey.deliveryapp.di.ComponentManager;
import ru.savchenko.andrey.deliveryapp.di.delivered.DeliveredComponent;
import ru.savchenko.andrey.deliveryapp.di.delivered.DeliveredModule;
import ru.savchenko.andrey.deliveryapp.dialogs.ReviewDialog;
import ru.savchenko.andrey.deliveryapp.entities.Order;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.presenter.DeliveredPresenter;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.presenter.DeliveredPresenterImpl;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.view.DeliveredView;
import ru.savchenko.andrey.deliveryapp.interfaces.OnCircleSet;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;
import ru.savchenko.andrey.deliveryapp.view.CircleTransform;

import static android.content.ContentValues.TAG;

/**
 * Created by Andrey on 09.09.2017.
 */

public class DeliveredFragment extends BaseFragment implements OnItemClickListener, OnCircleSet, DeliveredView{
    @BindView(R.id.rvCurrentOrders)
    RecyclerView rvCurrentOrders;

    @Inject DeliveredPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_delivered, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        ((DeliveredComponent)App.getComponentManager()
                .getPresenterComponent(getClass(), new DeliveredModule(this))).inject(this);
        if(onChangeTitle!=null)
        onChangeTitle.changeTitle(R.string.delivered);
        initRv();
    }

    private void initRv() {
        rvCurrentOrders.setLayoutManager(new LinearLayoutManager(getActivity()));

        presenter.setDataOrders();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        App.getComponentManager().releaseComponent(getClass());
    }

    @Override
    public void setData(List<Order> data) {
        CurrentOrdersAdapter adapter = new CurrentOrdersAdapter();
        adapter.setClickListener(this);
        adapter.setOnCircleSet(this);
        adapter.setData(data);
        rvCurrentOrders.setAdapter(adapter);
    }

    @Override
    public void onClick(int position) {
        Log.i(TAG, "onClick: " + position);
    }

    @Override
    public void onCircleSet(String url, ImageView imageView) {
        Log.i(TAG, "onCircleSet: " + url);
        Picasso.with(getActivity()).load(url).transform(new CircleTransform()).into(imageView);
    }

    @Override
    public void onClickReview(int position) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        ReviewDialog newFragment = new ReviewDialog();
        newFragment.show(ft, "dialog");
    }
}
