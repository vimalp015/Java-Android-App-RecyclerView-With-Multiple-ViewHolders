package com.au.vimalprakash.thenewsfeedapp.utils;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AndroidSchedulersProvider implements SchedulersProvider {
    @NonNull
    @Override
    public Scheduler mainUiThread() {
        return AndroidSchedulers.mainThread();
    }

    @NonNull
    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @NonNull
    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @NonNull
    @Override
    public Scheduler immediate() {
        return Schedulers.trampoline();
    }
}
