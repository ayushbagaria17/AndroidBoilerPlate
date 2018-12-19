package com.example.mytestapplication.feature.ui.home;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.mytestapplication.MyApplication;
import com.example.mytestapplication.R;
import com.example.mytestapplication.databinding.ActivityHomeBinding;
import com.example.utils.base.BaseActivity;
import com.example.utils.models.Photos;

import java.util.List;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity implements HomeNavigator{

    @Inject
    HomeViewModel viewModel;

    private ActivityHomeBinding binding;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        setUpDependencyInjection();
        binding.setVm(viewModel);
        this.mAdapter =new  HomeAdapter(this);
        binding.rvPhotos.setAdapter(mAdapter);
        binding.rvPhotos.setLayoutManager(new GridLayoutManager(this, 3));

    }

    private void setUpDependencyInjection() {
        MyApplication.get(this)
                .getAppComponent()
                .plusHomeComponent(new HomeModule(this))
                .inject(this);
    }

    @Override
    public void setData(List<Photos> photosList) {
        mAdapter.setData(photosList);
    }
}
