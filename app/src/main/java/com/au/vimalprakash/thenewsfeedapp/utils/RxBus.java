package com.au.vimalprakash.thenewsfeedapp.utils;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RxBus {
    private static volatile RxBus sInstance;
    private PublishSubject<Object> bus;

    private RxBus() {
        bus = PublishSubject.create();
    }

    public static RxBus getDefault() {
        if (sInstance == null) {
            synchronized (RxBus.class) {
                if (sInstance == null) {
                    sInstance = new RxBus();
                }
            }
        }
        return sInstance;
    }

    public void post(Object o) {
        bus.onNext(o);
    }

    public <T> Observable<T> toObservable(Class<T> objectType) {
        return bus.ofType(objectType);
    }
}
