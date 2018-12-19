package com.example.mytestapplication.feature.ui.home;

import com.example.utils.models.SearchResponse;
import com.example.utils.repo.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;


public class HomeInteractorImpl  implements HomeInteractor {
    Repo mRepo;

    @Inject
    public HomeInteractorImpl(Repo repo) {
        mRepo = repo;
    }


    @Override
    public Observable<SearchResponse> getData(int page, String searchText) {
        return mRepo.getPhotos(searchText, page);
    }
}