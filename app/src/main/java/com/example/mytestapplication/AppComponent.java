package com.example.mytestapplication;

import com.example.mytestapplication.feature.ui.AppScope;
import com.example.mytestapplication.feature.ui.home.HomeComponent;
import com.example.mytestapplication.feature.ui.home.HomeModule;
import com.example.mytestapplication.feature.ui.repository.RepoModule;

import dagger.Component;

@AppScope
@Component(modules = {
        NetModule.class,
        AppModule.class,
        RepoModule.class
})
public interface AppComponent {

    public HomeComponent plusHomeComponent(HomeModule module);
}
