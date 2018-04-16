package com.au.vimalprakash.thenewsfeedapp.networking;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface NewsFeedApi {

    @GET("NewsFeedApp/master/data.json")
    Single<NewsFeedResponse> getNewsFeed();
}