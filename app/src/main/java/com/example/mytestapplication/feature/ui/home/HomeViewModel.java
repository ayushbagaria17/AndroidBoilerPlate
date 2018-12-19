package com.example.mytestapplication.feature.ui.home;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.support.annotation.VisibleForTesting;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.utils.models.SearchResponse;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class HomeViewModel extends BaseObservable{
    private final HomeNavigator mNavigator;
    @VisibleForTesting() public HomeInteractor mHomeInteractor;
    @VisibleForTesting() public ObservableField<String> searchText = new ObservableField<>("");
    @VisibleForTesting() public int pageNumer = 1;
    PublishSubject<String> subject =  PublishSubject.create();


    @Inject
    public HomeViewModel(HomeInteractor homeInteractor, HomeNavigator navigator) {
        mHomeInteractor= homeInteractor;
        mNavigator = navigator;
        getData();
        subject.onNext("Tesla");


    }

    private void getData() {
        subject.debounce(200, TimeUnit.MILLISECONDS)
                .distinct()
                .flatMap(new Function<String, io.reactivex.Observable<SearchResponse>>() {
                    @Override
                    public io.reactivex.Observable<SearchResponse> apply(String s) throws Exception {
                        return mHomeInteractor.getData(pageNumer, s);
                    }
                }).subscribe(new Consumer<SearchResponse>() {
            @Override
            public void accept(SearchResponse searchResponse) throws Exception {
                mNavigator.setData(searchResponse.photos().photo());
            }
        });

    }

    public ObservableField<String> gotTheData =new  ObservableField<String>("");


    @Bindable
    public TextWatcher getSearchTextWatcher()  {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                subject.onNext(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }
}
