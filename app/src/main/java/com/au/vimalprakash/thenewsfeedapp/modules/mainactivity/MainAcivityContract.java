package com.au.vimalprakash.thenewsfeedapp.modules.mainactivity;


public interface MainAcivityContract {
    interface View{

        void loadWebUrl(String url);
    }

    interface Presenter {

        void attachView(View view);

        void detachView();

    }
}
