package com.example.utils.models;


import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class Photos {
    public abstract String id();
    public abstract String owner();
    public abstract String secret();
    public abstract String server();
    public abstract int farm();
    public abstract String title();
    public abstract int ispublic();
    public abstract int isfriend();
    public abstract int isfamily();


    public static TypeAdapter<Photos> typeAdapter(Gson gson) {
        return new AutoValue_Photos.GsonTypeAdapter(gson);
    }
}
