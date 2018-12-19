package com.example.mytestapplication.feature.ui.home;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxBinder {

    public Scheduler getIOScheduler() {
        return Schedulers.io();
    }

    public Scheduler getAndroidcheduler() {
        return AndroidSchedulers.mainThread() ;
    }
}
