package com.example.utils.repo;

import android.support.annotation.NonNull;

import com.example.utils.models.SearchResponse;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface Repo {
    Observable<SearchResponse> getPhotos(@NonNull String searchString, int page);
}
