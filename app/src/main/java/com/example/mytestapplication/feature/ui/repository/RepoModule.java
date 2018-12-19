package com.example.mytestapplication.feature.ui.repository;

import com.example.mytestapplication.feature.ui.AppScope;
import com.example.utils.repo.Repo;
import com.example.utils.repo.RepoApi;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import static com.example.mytestapplication.NetModule.API_KEY;
import static com.example.mytestapplication.NetModule.FORMAT;
import static com.example.mytestapplication.NetModule.NO_JSON_CALLBACK;

@Module
public class RepoModule {

    @Provides
    @AppScope
    public RepoApi provideRepoApi(Retrofit retrofit) {
        return retrofit.create(RepoApi.class);
    }

    @Provides
    @AppScope
    public Repo prrovideRepo(RepoApi repoApi, @Named(API_KEY) String apiKey,@Named(FORMAT) String format, @Named(NO_JSON_CALLBACK) int nojsoncallBack)  { return new RepoImplementation(repoApi, apiKey, format, nojsoncallBack);}
}
