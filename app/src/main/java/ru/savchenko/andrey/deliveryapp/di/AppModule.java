package ru.savchenko.andrey.deliveryapp.di;

import android.content.Context;
import android.view.LayoutInflater;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.savchenko.andrey.deliveryapp.App;
import ru.savchenko.andrey.deliveryapp.network.FirebaseService;

/**
 * Created by Andrey on 06.10.2017.
 */
@Module
public class AppModule {
    public static final String BASE_URL = "https://fcm.googleapis.com";
    public static final String APP_KEY = "AIzaSyBDA7kAs1YyW1cBPmf1gtF9BB3qGbnbQiY";

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
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/json")
                                .addHeader("Authorization", "key=" + APP_KEY)
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(FirebaseService.class);
    }
}
