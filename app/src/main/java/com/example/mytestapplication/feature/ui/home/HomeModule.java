package com.example.mytestapplication.feature.ui.home;

import com.example.mytestapplication.feature.ui.ActivityScope;
import com.example.utils.base.BaseActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module(includes = HomeModule.Declarations.class)
public class HomeModule extends BaseActivity {
    private final HomeNavigator mNavigator;

    public HomeModule(HomeNavigator navigator) {
        this.mNavigator = navigator;
    }

    @Module
    public interface Declarations {
        @ActivityScope
        @Binds
        public HomeInteractor provideHomeInteractor(HomeInteractorImpl homeInteractor);
    }

    @Provides
    @ActivityScope
    public HomeNavigator provideHomeNavigator() { return mNavigator;}
}