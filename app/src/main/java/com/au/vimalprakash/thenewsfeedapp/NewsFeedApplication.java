package com.au.vimalprakash.thenewsfeedapp;

import android.app.Application;

import com.au.vimalprakash.thenewsfeedapp.di.components.ActivityComponents;
import com.au.vimalprakash.thenewsfeedapp.di.components.DaggerActivityComponents;
import com.au.vimalprakash.thenewsfeedapp.di.components.DaggerSupportComponents;
import com.au.vimalprakash.thenewsfeedapp.di.components.SupportComponents;
import com.au.vimalprakash.thenewsfeedapp.di.modules.ActivityModules;
import com.au.vimalprakash.thenewsfeedapp.di.modules.SupportModules;


public class NewsFeedApplication extends Application {

    private final String mBaseUrl = "https://raw.githubusercontent.com/vimalp015/";
    private ActivityComponents mActivityComponents;
    private static NewsFeedApplication sApplication;

    public static NewsFeedApplication getInstance() {
        return sApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }

    public ActivityComponents getActivityComponents() {
        if (mActivityComponents == null) {
            SupportComponents supportComponents = DaggerSupportComponents.builder().supportModules(new SupportModules(this)).build();

            mActivityComponents = DaggerActivityComponents.builder().supportComponents(supportComponents)
                    .activityModules(new ActivityModules())
                    .build();
        }

        return mActivityComponents;
    }

    public String getBaseURL(){
        return mBaseUrl;
    }

}
