package com.au.vimalprakash.thenewsfeedapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebContentsFragment extends Fragment {

    public static final String TAG = "web_contents_fragment_tag";

    public static final String URL_KEY = "url_key";

    private String mUrl;

    @BindView(R.id.news_feed_web_view)
    WebView mNewsFeedWebView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mUrl = getArguments().getString(URL_KEY);
        return inflater.inflate(R.layout.fragment_web_contents, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        if(savedInstanceState == null) {
            loadUrl(mUrl);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState )
    {
        super.onSaveInstanceState(outState);
        mNewsFeedWebView.saveState(outState);
    }

    private void loadUrl(String url){
        mNewsFeedWebView.clearCache(true);
        mNewsFeedWebView.loadUrl(url);
    }
}
