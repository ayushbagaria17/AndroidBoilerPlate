package com.example.mytestapplication;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

public class MyApplication extends MultiDexApplication {
    String apiKey =BuildConfig.API_KEY;
    String baseUrl = BuildConfig.BASE_URL;
    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (!BuildConfig.DEBUG) {
            baseUrl = Constants.prodBaseUrl;
        }

        initialiseAppComponent();

    }

    private void initialiseAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(baseUrl, apiKey))
                .build();
    }

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }


}


