package com.example.utils.models;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class SearchResponse {
    public abstract SearchPhotos photos();

    public static TypeAdapter<SearchResponse> typeAdapter(Gson gson) {
        return new AutoValue_SearchResponse.GsonTypeAdapter(gson);
    }
}
