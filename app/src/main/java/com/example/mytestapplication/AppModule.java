package com.example.mytestapplication;

import android.app.Application;

import com.example.mytestapplication.feature.ui.AppScope;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @AppScope
    public Application provideApplication() {
        return mApplication;
    }
}
