package com.au.vimalprakash.thenewsfeedapp.modules.newsfeed;

public interface NewsFeedContract {

    interface View{

        void updateNewsFeed();

        void showLoading();

        void hideLoading();

        void setCouldNotLoadLayoutVisibility(boolean showCouldNotLoadLayout);

//        void showDetailsInWebView(String url);
    }

    interface Presenter {

        void onBindViewHolderAtPosition(ViewHolder holder, int position);

        void getNewsFeed();

        void attachView(View view);

        void detachView();

        void clearDisposables();

        int getItemCount();

        void showWebDetails(int position);
    }

    interface ViewHolder{

        void setHeadline(String headline);

        void setTheAbstract(String theAbstract);

        void setByline(String byline);

        void setSmallImage(String url);
    }
}
