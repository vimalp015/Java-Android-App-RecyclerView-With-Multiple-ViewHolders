// Generated code from Butter Knife. Do not modify!
package com.au.vimalprakash.thenewsfeedapp.modules.newsfeed;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.au.vimalprakash.thenewsfeedapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NewsFeedFragment_ViewBinding implements Unbinder {
  private NewsFeedFragment target;

  private View view2131165319;

  @UiThread
  public NewsFeedFragment_ViewBinding(final NewsFeedFragment target, View source) {
    this.target = target;

    View view;
    target.mSwipeContainer = Utils.findRequiredViewAsType(source, R.id.swipe_container, "field 'mSwipeContainer'", SwipeRefreshLayout.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'mRecyclerView'", RecyclerView.class);
    target.mErrorLoadingLayout = Utils.findRequiredView(source, R.id.error_loading_layout, "field 'mErrorLoadingLayout'");
    view = Utils.findRequiredView(source, R.id.try_again_button, "method 'onTryAgain'");
    view2131165319 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onTryAgain();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    NewsFeedFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSwipeContainer = null;
    target.mRecyclerView = null;
    target.mErrorLoadingLayout = null;

    view2131165319.setOnClickListener(null);
    view2131165319 = null;
  }
}
