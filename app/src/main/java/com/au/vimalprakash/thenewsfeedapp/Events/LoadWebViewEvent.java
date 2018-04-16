package com.au.vimalprakash.thenewsfeedapp.Events;

public class LoadWebViewEvent {

    private String mUrl;

    public LoadWebViewEvent(String url){
        mUrl = url;
    }

    public String getUrl() {
        return mUrl;
    }
}
