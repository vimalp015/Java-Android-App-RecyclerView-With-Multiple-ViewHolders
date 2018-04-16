package com.au.vimalprakash.thenewsfeedapp.modules.mainactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.au.vimalprakash.thenewsfeedapp.NewsFeedApplication;
import com.au.vimalprakash.thenewsfeedapp.modules.newsfeed.NewsFeedFragment;
import com.au.vimalprakash.thenewsfeedapp.R;
import com.au.vimalprakash.thenewsfeedapp.WebContentsFragment;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainAcivityContract.View {

    @Inject
    MainAcivityContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //inject our presenter here
        NewsFeedApplication.getInstance().getActivityComponents().inject(this);

        loadFragment(new NewsFeedFragment(), NewsFeedFragment.TAG);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.attachView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.detachView();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public void loadWebUrl(String url) {
        Bundle bundle = new Bundle();
        bundle.putString(WebContentsFragment.URL_KEY, url);
        Fragment fragment = new WebContentsFragment();
        fragment.setArguments(bundle);
        loadFragment(fragment, WebContentsFragment.TAG);
    }

    private void loadFragment(Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_framelayout, fragment).addToBackStack(tag)
                .commit();
    }
}
