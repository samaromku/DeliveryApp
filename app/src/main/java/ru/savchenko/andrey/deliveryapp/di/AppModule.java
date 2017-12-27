package ru.savchenko.andrey.deliveryapp.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.savchenko.andrey.deliveryapp.activities.auth.AuthActivity;
import ru.savchenko.andrey.deliveryapp.di.auth.AuthComponent;
import ru.savchenko.andrey.deliveryapp.di.base.ComponentBuilder;
import ru.savchenko.andrey.deliveryapp.di.current.CurrentComponent;
import ru.savchenko.andrey.deliveryapp.di.delivered.DeliveredComponent;
import ru.savchenko.andrey.deliveryapp.di.discount.DiscountComponent;
import ru.savchenko.andrey.deliveryapp.di.reviews.ReviewComponent;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.FragmentCurrentOrders;
import ru.savchenko.andrey.deliveryapp.fragments.discount.DiscountFragment;
import ru.savchenko.andrey.deliveryapp.network.FirebaseService;
import ru.savchenko.andrey.deliveryapp.network.MapService;
import ru.savchenko.andrey.deliveryapp.network.TestFlask;

/**
 * Created by Andrey on 06.10.2017.
 */
@Module(subcomponents = {
        AuthComponent.class,
        CurrentComponent.class,
        DeliveredComponent.class,
        DiscountComponent.class,
        ReviewComponent.class
})
class AppModule {
    private static final String BASE_FIREBASE_URL = "https://fcm.googleapis.com";
    private static final String BASE_MAP_URL = "https://maps.googleapis.com";
    private static final String APP_KEY = "key=AAAAtzJYhJA:APA91bHSGk3gOnOGqakZbaPvNkEc2P6748IrNYnmoCV_ZIS6iBuS-awPvRHsxG0KshG8jTNdD4nrKwvfLwOA2K9uGryI5cvEpjgb3rGe2ZDK3TPKWj3F4dy3W0GsycSjSr9eMUyEMFfY";
    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String EMULATOR_IP = "http://10.0.2.2:5000";

    @Provides
    @IntoMap
    @ClassKey(AuthActivity.class)
    ComponentBuilder provideAuthActivity(AuthComponent.Builder builder){
        return builder;
    }

    @Provides
    @IntoMap
    @ClassKey(FragmentCurrentOrders.class)
    ComponentBuilder provideCurrent(CurrentComponent.Builder builder){
        return builder;
    }


    @Provides
    @IntoMap
    @ClassKey(DiscountFragment.class)
    ComponentBuilder provideDiscount(DiscountComponent.Builder builder){
        return builder;
    }

    @Provides
    @IntoMap
    @ClassKey(ReviewComponent.class)
    ComponentBuilder provideReview(ReviewComponent.Builder builder){
        return builder;
    }

    @Singleton
    @Provides
    FirebaseService FirebaseService() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(chain -> {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("Content-Type", "application/json")
                            .addHeader("Authorization", APP_KEY)
                            .build();
                    return chain.proceed(request);
                })
                .build();

        return new Retrofit.Builder()
                .baseUrl(BASE_FIREBASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(FirebaseService.class);
    }

    @Singleton
    @Provides
    MapService mapService(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(chain -> {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("Content-Type", "application/json")
                            .addHeader("Authorization", APP_KEY)
                            .build();
                    return chain.proceed(request);
                })
                .build();

        return new Retrofit.Builder()
                .baseUrl(BASE_MAP_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(MapService.class);
    }

    @Singleton
    @Provides
    TestFlask testFlask(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Gson gson = new GsonBuilder()
                .setDateFormat(DATE_PATTERN)
                .create();
        return new Retrofit.Builder()
                .baseUrl(EMULATOR_IP)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(TestFlask.class);
    }
}
