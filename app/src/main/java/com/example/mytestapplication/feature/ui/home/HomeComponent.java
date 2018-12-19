package com.example.mytestapplication.feature.ui.home;

import com.example.mytestapplication.feature.ui.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {HomeModule.class})
public interface HomeComponent {
    void inject(HomeActivity activity);
}
