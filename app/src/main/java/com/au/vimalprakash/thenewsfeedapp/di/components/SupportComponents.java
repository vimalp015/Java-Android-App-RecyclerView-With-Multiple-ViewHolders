package com.au.vimalprakash.thenewsfeedapp.di.components;

import com.au.vimalprakash.thenewsfeedapp.di.modules.SupportModules;
import com.au.vimalprakash.thenewsfeedapp.networking.NewsFeedApi;
import com.au.vimalprakash.thenewsfeedapp.utils.SchedulersProvider;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {SupportModules.class})
public interface SupportComponents {

    NewsFeedApi getNewsFeedApi();

    Gson getGson();

    SchedulersProvider getSchedulersProvider();
}
