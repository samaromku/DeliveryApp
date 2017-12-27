package ru.savchenko.andrey.deliveryapp.fragments.current_orders.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.savchenko.andrey.deliveryapp.base.BaseMVPPresenter;
import ru.savchenko.andrey.deliveryapp.di.ComponentManager;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.interactor.CurrentInteractorImpl;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.view.CurrentView;

import static ru.savchenko.andrey.deliveryapp.activities.main.DeliveryActivity.TAG;

/**
 * Created by Andrey on 23.09.2017.
 */
public class CurrentPresenterImpl  {
    private CurrentInteractorImpl interactor;
    private CurrentView view;

    public CurrentPresenterImpl(CurrentInteractorImpl interactor, CurrentView view) {
        this.interactor = interactor;
        this.view = view;
    }

    public void getOrderList() {
        interactor.getOrderList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(orders -> view.setDataList(orders), Throwable::printStackTrace);
    }
}
