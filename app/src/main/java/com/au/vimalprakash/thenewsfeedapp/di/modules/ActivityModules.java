package com.au.vimalprakash.thenewsfeedapp.di.modules;

import com.au.vimalprakash.thenewsfeedapp.modules.mainactivity.MainAcivityContract;
import com.au.vimalprakash.thenewsfeedapp.modules.mainactivity.MainActivityPresenter;
import com.au.vimalprakash.thenewsfeedapp.modules.newsfeed.NewsFeedContract;
import com.au.vimalprakash.thenewsfeedapp.modules.newsfeed.NewsFeedPresenter;
import com.au.vimalprakash.thenewsfeedapp.di.components.PerActivity;
import com.au.vimalprakash.thenewsfeedapp.networking.NewsFeedApi;
import com.au.vimalprakash.thenewsfeedapp.utils.SchedulersProvider;
import com.google.gson.Gson;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModules {

    @Provides
    @PerActivity
    MainAcivityContract.Presenter getMainActivityPresenter(SchedulersProvider mSchedulersProvider){
        return new MainActivityPresenter(mSchedulersProvider);
    }

    @Provides
    @PerActivity
    NewsFeedContract.Presenter getNewsFeedPresenter(NewsFeedApi newsFeedApi, SchedulersProvider schedulersProvider){
        return new NewsFeedPresenter(newsFeedApi, schedulersProvider);
    }
}
