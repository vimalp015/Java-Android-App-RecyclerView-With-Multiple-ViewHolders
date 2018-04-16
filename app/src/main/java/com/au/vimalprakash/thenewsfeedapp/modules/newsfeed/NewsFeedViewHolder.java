package com.au.vimalprakash.thenewsfeedapp.modules.newsfeed;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.au.vimalprakash.thenewsfeedapp.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewsFeedViewHolder extends RecyclerView.ViewHolder implements NewsFeedContract.ViewHolder {

    private final ClickListener mClickListener;

    private final Context mContext;

    @BindView(R.id.headline_text_view)
    TextView mHeadlineTextView;

    @BindView(R.id.abstract_text_view)
    TextView mAbstractTextView;

    @BindView(R.id.byline_text_view)
    TextView mByLineTextView;

    @BindView(R.id.news_image_view)
    ImageView mNewsImageView;

    public interface ClickListener {
        void onClick(int position);
    }

    public NewsFeedViewHolder(View itemView, Context context, ClickListener clickListener) {
        super(itemView);
        mContext = context;
        mClickListener = clickListener;
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setHeadline(String headline) {
        mHeadlineTextView.setText(headline);
    }

    @Override
    public void setTheAbstract(String theAbstract) {
        mAbstractTextView.setText(theAbstract);
    }

    @Override
    public void setByline(String byline) {
        mByLineTextView.setText(byline);
    }

    @Override
    public void setSmallImage(String url) {
        Picasso.with(mContext).load(url).into(mNewsImageView);
    }

    @OnClick(R.id.news_feed_title_card_view)
    protected void onNewsFeedTileClick() {
        if (mClickListener != null) {
            mClickListener.onClick(getAdapterPosition());
        }
    }
}
