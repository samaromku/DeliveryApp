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

public class ReviewFragment extends BaseFragment implements OnItemClickListener {
    @BindView(R.id.rvReviews) RecyclerView rvReviews;
    @Inject ReviewAdapter adapter;

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
        initRv();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ComponentManager.destroyReviewComponent();
    }

    private void initRv() {
        rvReviews.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvReviews.setAdapter(adapter);
    }

    public List<Review>getReviews(){
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review(1, "Заказ доставили очень быстро", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 5, "Станислав"));
        reviews.add(new Review(1, "Очень хорошо!", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 4, "Станислав"));
        reviews.add(new Review(1, "Долго ехал курьер", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 3, "Станислав"));
        reviews.add(new Review(1, "Не положили подарок на День Рождения", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 2, "Станислав"));
        reviews.add(new Review(1, "Курьер съел мою пиццу(((", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 1, "Станислав"));
        reviews.add(new Review(1, "Заказ доставили очень быстро", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 5, "Станислав"));
        reviews.add(new Review(1, "Заказ доставили очень быстро", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 5, "Станислав"));
        reviews.add(new Review(1, "Заказ доставили очень быстро", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 4, "Станислав"));
        reviews.add(new Review(1, "Заказ доставили очень быстро", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 4, "Станислав"));
        reviews.add(new Review(1, "Заказ доставили очень быстро", "Заказ доставили очень быстро и оперативно, курьер выжливый и прятный", new DateTime(), 4, "Станислав"));

        return reviews;
    }

    @Override
    public void onClick(int position) {
        Log.i(TAG, "onClick: " + position);
    }
}

