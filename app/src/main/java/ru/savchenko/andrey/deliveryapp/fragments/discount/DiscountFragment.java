package ru.savchenko.andrey.deliveryapp.fragments.discount;

import android.os.Bundle;
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
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.adapters.DiscountAdapter;
import ru.savchenko.andrey.deliveryapp.base.BaseFragment;
import ru.savchenko.andrey.deliveryapp.di.ComponentManager;
import ru.savchenko.andrey.deliveryapp.entities.Discount;
import ru.savchenko.andrey.deliveryapp.interfaces.OnCircleSet;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;
import ru.savchenko.andrey.deliveryapp.view.CircleTransform;


public class DiscountFragment extends BaseFragment implements
        DiscountView,
        OnItemClickListener,
        OnCircleSet{
    public static final String TAG = "DiscountFragment";
    @Inject DiscountPresenter mDiscountPresenter;
    @BindView(R.id.rvDiscounts)RecyclerView rvDiscounts;
//    @Inject DiscountAdapter adapter;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discount, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        changeToolbarTitle(R.string.discount);
        ComponentManager.initDiscountComponent(this).inject(this);
        ButterKnife.bind(this, view);
        mDiscountPresenter.getDiscounts();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ComponentManager.destroyDiscountComponent();
    }

    @Override
    public void setData(List<Discount> data) {
        DiscountAdapter adapter = new DiscountAdapter();
        adapter.setClickListener(this);
        adapter.setOnCircleSet(this);
        adapter.setDataList(data);
        rvDiscounts.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDiscounts.setAdapter(adapter);
    }

    @Override
    public void onClick(int position) {
        Log.i(TAG, "onClick: " + position);
    }

    @Override
    public void onCircleSet(String url, ImageView imageView) {
        Picasso.with(getActivity()).load(url)
                .transform(new CircleTransform())
                .into(imageView);
    }

    @Override
    public void onClickReview(int position) {

    }
}
