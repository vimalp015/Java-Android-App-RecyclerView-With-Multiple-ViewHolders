// Generated code from Butter Knife. Do not modify!
package com.au.vimalprakash.thenewsfeedapp.modules.newsfeed;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.au.vimalprakash.thenewsfeedapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NewsFeedViewHolder_ViewBinding implements Unbinder {
  private NewsFeedViewHolder target;

  private View view2131165260;

  @UiThread
  public NewsFeedViewHolder_ViewBinding(final NewsFeedViewHolder target, View source) {
    this.target = target;

    View view;
    target.mHeadlineTextView = Utils.findRequiredViewAsType(source, R.id.headline_text_view, "field 'mHeadlineTextView'", TextView.class);
    target.mAbstractTextView = Utils.findRequiredViewAsType(source, R.id.abstract_text_view, "field 'mAbstractTextView'", TextView.class);
    target.mByLineTextView = Utils.findRequiredViewAsType(source, R.id.byline_text_view, "field 'mByLineTextView'", TextView.class);
    target.mNewsImageView = Utils.findRequiredViewAsType(source, R.id.news_image_view, "field 'mNewsImageView'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.news_feed_title_card_view, "method 'onNewsFeedTileClick'");
    view2131165260 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onNewsFeedTileClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    NewsFeedViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mHeadlineTextView = null;
    target.mAbstractTextView = null;
    target.mByLineTextView = null;
    target.mNewsImageView = null;

    view2131165260.setOnClickListener(null);
    view2131165260 = null;
  }
}
