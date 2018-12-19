package com.example.mytestapplication.feature.ui.home;

import com.example.utils.models.SearchResponse;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface HomeInteractor {
     Observable<SearchResponse> getData(int page, String searchText);
}