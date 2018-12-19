package com.example.mytestapplication.feature.ui.repository;

import com.example.mytestapplication.utils.Constants;
import com.example.utils.models.SearchResponse;
import com.example.utils.repo.Repo;
import com.example.utils.repo.RepoApi;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;


public class RepoImplementation implements Repo {

    RepoApi mRepoApi;
    String mApiKey;
    String mFormat;
    int mNojsoncallBack;

    public RepoImplementation(@NonNull RepoApi repoApi, @NonNull String apiKey, @NonNull String format, int nojsoncallBack) {
        mRepoApi = repoApi;
        mApiKey = apiKey;
        mFormat = format;
        mNojsoncallBack = nojsoncallBack;
    }

    @Override
    public Observable<SearchResponse> getPhotos(@NonNull String searchString, int page) {
        return mRepoApi.getPhotos(Constants.searchMethod, mApiKey, mFormat, searchString, page, mNojsoncallBack);
    }

}
