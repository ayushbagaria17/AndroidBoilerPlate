package com.example.mytestapplication.feature.ui.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mytestapplication.R;
import com.example.utils.models.Photos;


public class HomeViewHolder extends RecyclerView.ViewHolder {

    private final Context mContext;
    private Photos data;
    private TextView imageView;

    public HomeViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        imageView = itemView.findViewById(R.id.iv_image);
        this.mContext = context;
    }

    public void setData(Photos data) {
        this.data = data;
        imageView.setText(data.id());
    }
}
