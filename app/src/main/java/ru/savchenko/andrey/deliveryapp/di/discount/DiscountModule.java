package ru.savchenko.andrey.deliveryapp.di.discount;

import dagger.Module;
import dagger.Provides;
import ru.savchenko.andrey.deliveryapp.fragments.discount.DiscountFragment;
import ru.savchenko.andrey.deliveryapp.fragments.discount.DiscountInteractor;
import ru.savchenko.andrey.deliveryapp.fragments.discount.DiscountPresenter;

/**
 * Created by Andrey on 07.10.2017.
 */
@Module
public class DiscountModule {
    private DiscountFragment fragment;

    public DiscountModule(DiscountFragment fragment) {
        this.fragment = fragment;
    }

//    @DiscountScope
//    @Provides
//    public DiscountAdapter adapter(DiscountViewHolderFactory factory){
//        return new DiscountAdapter(factory);
//    }
//
//    @DiscountScope
//    @Provides
//    public DiscountViewHolderFactory factory(LayoutInflater inflater, Context context){
//        return new DiscountViewHolderFactory(fragment, inflater, context);
//    }

    @DiscountScope
    @Provides
    public DiscountPresenter presenter(DiscountInteractor interactor){
        return new DiscountPresenter(interactor, fragment);
    }

    @DiscountScope
    @Provides
    public DiscountInteractor interactor(){
        return new DiscountInteractor();
    }
}
