package com.au.vimalprakash.thenewsfeedapp.modules.newsfeed;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.au.vimalprakash.thenewsfeedapp.NewsFeedApplication;
import com.au.vimalprakash.thenewsfeedapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;


public class NewsFeedFragment extends Fragment implements NewsFeedContract.View{

    public static final String TAG = "news_feed_fragment_tag";

    @BindView(R.id.swipe_container)
    SwipeRefreshLayout mSwipeContainer;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.error_loading_layout)
    View mErrorLoadingLayout;

    private NewsFeedAdapter mAdapter;

    private ProgressDialog progress;

    @Inject
    NewsFeedContract.Presenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_feed, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        //inject our presenter here
        NewsFeedApplication.getInstance().getActivityComponents().inject(this);

        //we do not expect the recyclerview item layout size to change
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new NewsFeedAdapter(mPresenter);
        mRecyclerView.setAdapter(mAdapter);

        mPresenter.getNewsFeed();

        mSwipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getNewsFeed();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.attachView(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.detachView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.clearDisposables();
    }

    @Override
    public void updateNewsFeed() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        if (progress == null) {
            progress = new ProgressDialog(getContext());
            progress.setTitle(getResources().getString(R.string.loading_title));
            progress.setMessage(getResources().getString(R.string.loading_message));
        }
        if (!progress.isShowing()) {
            progress.show();
        }
    }

    @Override
    public void hideLoading() {
        mSwipeContainer.setRefreshing(false);
        if (progress != null && progress.isShowing()) {
            progress.dismiss();
        }
    }

    @Override
    public void setCouldNotLoadLayoutVisibility(boolean showCouldNotLoadLayout) {
        if (showCouldNotLoadLayout) {
            mErrorLoadingLayout.setVisibility(VISIBLE);
            mSwipeContainer.setVisibility(GONE);
        } else {
            mSwipeContainer.setVisibility(VISIBLE);
            mErrorLoadingLayout.setVisibility(GONE);
        }
    }

    @OnClick(R.id.try_again_button)
    protected void onTryAgain() {
        mPresenter.getNewsFeed();
    }
}
