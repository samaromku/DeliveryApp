package ru.savchenko.andrey.deliveryapp.fragments.discount;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import ru.savchenko.andrey.deliveryapp.di.ComponentManager;


public class DiscountPresenter {
    private DiscountInteractor interactor;
    private DiscountView view;

    public DiscountPresenter(DiscountInteractor interactor, DiscountView view) {
        this.interactor = interactor;
        this.view = view;
    }

    public void getDiscounts(){
        interactor.getDiscounts()
                .subscribe(discounts -> view.setData(discounts), throwable -> {
                            throwable.printStackTrace();
                        });
    }
}
