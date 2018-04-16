package com.au.vimalprakash.thenewsfeedapp.modules.mainactivity;

import com.au.vimalprakash.thenewsfeedapp.Events.LoadWebViewEvent;
import com.au.vimalprakash.thenewsfeedapp.utils.RxBus;
import com.au.vimalprakash.thenewsfeedapp.utils.SchedulersProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class MainActivityPresenter implements MainAcivityContract.Presenter{

    private final CompositeDisposable mDisposables = new CompositeDisposable();

    private final SchedulersProvider mSchedulersProvider;

    private MainAcivityContract.View mView;

    public MainActivityPresenter(SchedulersProvider schedulersProvider){
        mSchedulersProvider = schedulersProvider;
    }

    @Override
    public void attachView(MainAcivityContract.View view) {
        mView = view;
        addDisposables();
    }

    @Override
    public void detachView() {
        mDisposables.clear();
        mView = null;
    }

    private void addDisposables(){
        mDisposables.add(RxBus.getDefault()
                .toObservable(LoadWebViewEvent.class)
                .observeOn(mSchedulersProvider.mainUiThread())
                .subscribe(new Consumer<LoadWebViewEvent>() {
                    @Override
                    public void accept(LoadWebViewEvent loadWebViewEvent) throws Exception {
                        onLoadWebViewEvent(loadWebViewEvent);
                    }
                }));
    }

    private void onLoadWebViewEvent(LoadWebViewEvent event){
        if(mView != null){
            mView.loadWebUrl(event.getUrl());
        }
    }
}
