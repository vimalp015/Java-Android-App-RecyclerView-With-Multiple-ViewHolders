package com.au.vimalprakash.thenewsfeedapp.utils;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

public interface SchedulersProvider {
    @NonNull
    Scheduler mainUiThread();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler immediate();
}
