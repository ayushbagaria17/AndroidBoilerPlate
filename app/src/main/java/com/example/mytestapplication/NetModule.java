package com.example.mytestapplication;

import com.example.mytestapplication.feature.ui.AppScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {
    public static final String API_KEY= "API_KEY";
    public static final String FORMAT= "format";
    public static final String NO_JSON_CALLBACK= "1";

    String mBaseUrl;
    String mApiKey;
    String mFormat = "json";
    int mNojsoncallback=1;

    public NetModule(String baseUrl, String apiKey) {
        mBaseUrl = baseUrl;
        mApiKey = apiKey;
    }

    @Provides
    @AppScope
    public Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @AppScope
    public OkHttpClient okHttpClientProvider() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        return client.build();
    }

    @Provides
    @AppScope
    public Retrofit provideRetrofit(Gson gson, OkHttpClient client, RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build();
    }

    @Provides
    @AppScope
    public RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io());
    }

    @Provides
    @AppScope
    @Named(API_KEY)
    public String provideApiKey() {
        return mApiKey;
    }

    @Provides
    @AppScope
    @Named(FORMAT)
    public String provideFormat() {
        return mFormat;
    }

    @Provides
    @AppScope
    @Named(NO_JSON_CALLBACK)
    public int provideNoJsonCallback() {
        return mNojsoncallback;
    }


}
