package com.example.mytestapplication.feature.ui.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mytestapplication.R;
import com.example.utils.models.Photos;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {
    private  Context mContext;
    private  LayoutInflater mInflater;
    public List<Photos> mPhotos;

    public HomeAdapter(Context context) {
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.home_item, viewGroup, false);
        HomeViewHolder viewHolder = new HomeViewHolder(view, mContext);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder homeViewHolder, int i) {
        homeViewHolder.setData(mPhotos.get(i));
    }

    @Override
    public int getItemCount() {
         if (mPhotos != null) return mPhotos.size(); else return 0;
    }

    public void setData(List<Photos> photos) {
        if (photos != null) {
            mPhotos = photos;
            notifyDataSetChanged();
        }
    }
}
