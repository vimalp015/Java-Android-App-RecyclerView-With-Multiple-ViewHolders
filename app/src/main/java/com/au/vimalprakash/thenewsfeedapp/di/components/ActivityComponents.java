package com.au.vimalprakash.thenewsfeedapp.di.components;

import com.au.vimalprakash.thenewsfeedapp.modules.mainactivity.MainActivity;
import com.au.vimalprakash.thenewsfeedapp.modules.newsfeed.NewsFeedFragment;
import com.au.vimalprakash.thenewsfeedapp.di.modules.ActivityModules;

import dagger.Component;

@PerActivity
@Component(dependencies = {SupportComponents.class}, modules = {ActivityModules.class})
public interface ActivityComponents {

    void inject(MainActivity activity);

    void inject(NewsFeedFragment fragment);
}
