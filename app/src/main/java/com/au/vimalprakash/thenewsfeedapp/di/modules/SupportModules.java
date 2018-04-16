package com.au.vimalprakash.thenewsfeedapp.di.modules;


import android.support.annotation.NonNull;

import com.au.vimalprakash.thenewsfeedapp.NewsFeedApplication;
import com.au.vimalprakash.thenewsfeedapp.networking.NewsFeedApi;
import com.au.vimalprakash.thenewsfeedapp.utils.AndroidSchedulersProvider;
import com.au.vimalprakash.thenewsfeedapp.utils.SchedulersProvider;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class SupportModules {

    NewsFeedApplication mNewsFeedApplication;

    public SupportModules(@NonNull NewsFeedApplication application) {
        mNewsFeedApplication = application;
    }

    @Provides
    @Singleton
    NewsFeedApplication providesApplication() {
        return mNewsFeedApplication;
    }


    @Provides
    @Singleton
    Cache provideOkHttpCache(NewsFeedApplication application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.cache(cache);
        return httpClientBuilder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mNewsFeedApplication.getBaseURL())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    NewsFeedApi provideNewsFeedAPI(Retrofit retrofit) {
        return retrofit.create(NewsFeedApi.class);
    }

    @Provides
    @Singleton
    SchedulersProvider provideSchedulerProvider() {
        return new AndroidSchedulersProvider();
    }
}
