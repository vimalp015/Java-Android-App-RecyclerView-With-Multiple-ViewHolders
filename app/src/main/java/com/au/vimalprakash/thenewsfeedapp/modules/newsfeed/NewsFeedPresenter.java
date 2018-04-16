package com.au.vimalprakash.thenewsfeedapp.modules.newsfeed;

import com.au.vimalprakash.thenewsfeedapp.Events.LoadWebViewEvent;
import com.au.vimalprakash.thenewsfeedapp.networking.NewsFeedApi;
import com.au.vimalprakash.thenewsfeedapp.networking.NewsFeedResponse;
import com.au.vimalprakash.thenewsfeedapp.utils.RxBus;
import com.au.vimalprakash.thenewsfeedapp.utils.SchedulersProvider;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

public class NewsFeedPresenter implements NewsFeedContract.Presenter {

    private NewsFeedApi mNewsFeedApi;

    private SchedulersProvider mSchedulersProvider;

    private NewsFeedContract.View mView;

    private final CompositeDisposable mDisposables = new CompositeDisposable();

    private List<NewsFeedResponse.Assets> mNewsFeed;

    public NewsFeedPresenter(NewsFeedApi newsFeedApi, SchedulersProvider schedulersProvider) {
        mNewsFeedApi = newsFeedApi;
        mSchedulersProvider = schedulersProvider;
    }

    @Override
    public void onBindViewHolderAtPosition(NewsFeedContract.ViewHolder holder, int position) {
        holder.setHeadline(mNewsFeed.get(position).getHeadline());
        holder.setTheAbstract(mNewsFeed.get(position).getTheAbstract());
        holder.setByline(mNewsFeed.get(position).getByLine());
        setSmallestImage(holder, position);
    }

    @Override
    public void getNewsFeed() {

        if (isViewAttached()) {
            mView.showLoading();
        }

        mDisposables.add(mNewsFeedApi.getNewsFeed()
                .subscribeOn(mSchedulersProvider.io())
                .observeOn(mSchedulersProvider.mainUiThread())
                .subscribeWith(new DisposableSingleObserver<NewsFeedResponse>() {

                    @Override
                    public void onSuccess(NewsFeedResponse newsFeedResponse) {
                        //if we have already queried earlier, it will get the data from the Cache
                        mNewsFeed = newsFeedResponse.getAssets();



                        //we need to sort the news feed by time stamp
                        Collections.sort(mNewsFeed, new Comparator<NewsFeedResponse.Assets>() {
                            @Override
                            public int compare(NewsFeedResponse.Assets feed1, NewsFeedResponse.Assets feed2) {
                                if (feed1.getTimeStamp() < feed2.getTimeStamp()) {
                                    return -1;
                                } else if (feed1.getTimeStamp() > feed2.getTimeStamp()) {
                                    return 1;
                                } else {
                                    return 0;
                                }
                            }
                        });

                        //update view with the latest news feed
                        if (isViewAttached()) {
                            mView.hideLoading();
                            mView.updateNewsFeed();
                            mView.setCouldNotLoadLayoutVisibility(false);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        //hide loading
                        if (isViewAttached()) {
                            mView.hideLoading();
                            mView.setCouldNotLoadLayoutVisibility(true);
                        }
                    }
                }));
    }

    @Override
    public void attachView(NewsFeedContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void clearDisposables() {
        mDisposables.clear();
    }

    @Override
    public int getItemCount() {
        return mNewsFeed != null ? mNewsFeed.size() : 0;
    }

    @Override
    public void showWebDetails(int position) {
        if (isViewAttached() && position < mNewsFeed.size()) {
            RxBus.getDefault().post(new LoadWebViewEvent(mNewsFeed.get(position).getUrl()));
        }
    }

    private void setSmallestImage(NewsFeedContract.ViewHolder holder, int position){
        if(mNewsFeed.get(position).getRelatedImages() != null && mNewsFeed.get(position).getRelatedImages().size() > 0) {
            Collections.sort(mNewsFeed.get(position).getRelatedImages(), new Comparator<NewsFeedResponse.RelatedImages>() {
                @Override
                public int compare(NewsFeedResponse.RelatedImages image1, NewsFeedResponse.RelatedImages image2) {
                    if (image1 == null || image2 == null) {
                        return 0;
                    } else if ((image1.getWidth() * image1.getHeight()) > (image2.getWidth() * image2.getHeight())) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
            holder.setSmallImage(mNewsFeed.get(position).getRelatedImages().get(0).getUrl());
        }
    }

    private boolean isViewAttached() {
        return mView != null;
    }
}
