package ru.savchenko.andrey.deliveryapp.di;

import android.content.Context;
import android.view.LayoutInflater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.savchenko.andrey.deliveryapp.App;
import ru.savchenko.andrey.deliveryapp.network.FirebaseService;
import ru.savchenko.andrey.deliveryapp.network.MapService;

/**
 * Created by Andrey on 06.10.2017.
 */
@Module
public class AppModule {
    public static final String BASE_FIREBASE_URL = "https://fcm.googleapis.com";
    public static final String BASE_MAP_URL = "https://maps.googleapis.com";
    public static final String APP_KEY = "key=AAAAtzJYhJA:APA91bHSGk3gOnOGqakZbaPvNkEc2P6748IrNYnmoCV_ZIS6iBuS-awPvRHsxG0KshG8jTNdD4nrKwvfLwOA2K9uGryI5cvEpjgb3rGe2ZDK3TPKWj3F4dy3W0GsycSjSr9eMUyEMFfY";

    private final App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return app;
    }

    @Singleton
    @Provides
    LayoutInflater providesLayoutInflater() {
        return LayoutInflater.from(app);
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
}
