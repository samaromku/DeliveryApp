package ru.savchenko.andrey.deliveryapp.fragments.discount.presentation.presenter.discount;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import ru.savchenko.andrey.deliveryapp.di.ComponentManager;
import ru.savchenko.andrey.deliveryapp.fragments.discount.DiscountInteractor;
import ru.savchenko.andrey.deliveryapp.fragments.discount.presentation.view.discount.DiscountView;


@InjectViewState
public class DiscountPresenter extends MvpPresenter<DiscountView> {
    @Inject
    DiscountInteractor interactor;

    public DiscountPresenter() {
        ComponentManager.getAppComponent().inject(this);
    }

    public void getDiscounts(){
        interactor.getDiscounts()
                .subscribe(discounts -> getViewState().setData(discounts));
    }
}
