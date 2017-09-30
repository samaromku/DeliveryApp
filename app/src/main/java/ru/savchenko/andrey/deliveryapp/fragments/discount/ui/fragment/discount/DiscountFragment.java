package ru.savchenko.andrey.deliveryapp.fragments.discount.ui.fragment.discount;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.adapters.DiscountAdapter;
import ru.savchenko.andrey.deliveryapp.base.BaseFragment;
import ru.savchenko.andrey.deliveryapp.entities.Discount;
import ru.savchenko.andrey.deliveryapp.fragments.discount.presentation.presenter.discount.DiscountPresenter;
import ru.savchenko.andrey.deliveryapp.fragments.discount.presentation.view.discount.DiscountView;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;


public class DiscountFragment extends BaseFragment implements DiscountView, OnItemClickListener {
    public static final String TAG = "DiscountFragment";
    @InjectPresenter
    DiscountPresenter mDiscountPresenter;
    DiscountAdapter adapter = new DiscountAdapter();
    @BindView(R.id.rvDiscounts)RecyclerView rvDiscounts;

    public static DiscountFragment newInstance() {
        DiscountFragment fragment = new DiscountFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discount, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        mDiscountPresenter.getDiscounts();
    }

    @Override
    public void setData(List<Discount> data) {
        adapter.setClickListener(this);
        adapter.setDataList(data);
        rvDiscounts.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDiscounts.setAdapter(adapter);

    }

    @Override
    public void onClick(int position) {
        Log.i(TAG, "onClick: " + position);
    }
}
