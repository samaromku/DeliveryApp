package ru.savchenko.andrey.deliveryapp.fragments.review;

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

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.adapters.ReviewAdapter;
import ru.savchenko.andrey.deliveryapp.base.BaseFragment;
import ru.savchenko.andrey.deliveryapp.di.ComponentManager;
import ru.savchenko.andrey.deliveryapp.entities.Review;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;

import static android.content.ContentValues.TAG;

/**
 * Created by savchenko on 12.09.17.
 */

public class ReviewFragment extends BaseFragment implements OnItemClickListener, ReviewView {
    @BindView(R.id.rvReviews) RecyclerView rvReviews;
//    @Inject ReviewAdapter adapter;
    @Inject ReviewPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_review, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        onChangeTitle.changeTitle(R.string.my_review);
        ComponentManager.initReviewComponent(this).inject(this);
        presenter.getReviews();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ComponentManager.destroyReviewComponent();
    }

    @Override
    public void onClick(int position) {
        Log.i(TAG, "onClick: " + position);
    }

    @Override
    public void setListToAdapter(List<Review> listToAdapter) {
        ReviewAdapter adapter = new ReviewAdapter();
        adapter.setClickListener(this);
        adapter.setDataList(listToAdapter);
        rvReviews.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvReviews.setAdapter(adapter);
    }
}

