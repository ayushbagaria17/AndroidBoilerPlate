package com.example.utils.models;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

@AutoValue
public abstract class SearchPhotos {

    public abstract int page();
    public abstract int pages();
    public abstract int perpage();
    public abstract String total();
    public abstract String stat();
    public abstract List<Photos> photo();

    public static TypeAdapter<SearchPhotos> typeAdapter(Gson gson) {
        return new AutoValue_SearchPhotos.GsonTypeAdapter(gson);
    }

}
