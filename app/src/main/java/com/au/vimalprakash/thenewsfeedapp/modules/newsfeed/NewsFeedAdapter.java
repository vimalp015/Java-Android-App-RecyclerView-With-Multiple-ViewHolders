package com.au.vimalprakash.thenewsfeedapp.modules.newsfeed;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.au.vimalprakash.thenewsfeedapp.R;

public class NewsFeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final NewsFeedContract.Presenter mPresenter;

    public NewsFeedAdapter(NewsFeedContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_feed, parent, false);
        return new NewsFeedViewHolder(view, parent.getContext(), mClickListener);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //We want the data to be handled by the presenter using the view holder contract
        //this will also allow us to unit test the data being set to view holder
        mPresenter.onBindViewHolderAtPosition((NewsFeedContract.ViewHolder) holder, position);
    }

    @Override
    public int getItemCount() {
        return mPresenter.getItemCount();
    }

    private NewsFeedViewHolder.ClickListener mClickListener = new NewsFeedViewHolder.ClickListener() {
        @Override
        public void onClick(int position) {
            mPresenter.showWebDetails(position);
        }
    };
}
