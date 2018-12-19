package com.example.utils.repo;

import com.example.utils.models.SearchResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RepoApi {

    @GET("rest/")
    Observable<SearchResponse> getPhotos(@Query("method") String method,
                                         @Query("api_key") String apiKey,
                                         @Query("format") String format,
                                         @Query("text") String searchString,
                                         @Query("page") int page,
                                         @Query("nojsoncallback") int mNojsoncallBack);
}
