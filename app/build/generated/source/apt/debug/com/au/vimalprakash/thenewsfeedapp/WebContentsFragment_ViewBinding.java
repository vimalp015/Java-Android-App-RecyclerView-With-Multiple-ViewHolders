// Generated code from Butter Knife. Do not modify!
package com.au.vimalprakash.thenewsfeedapp;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WebContentsFragment_ViewBinding implements Unbinder {
  private WebContentsFragment target;

  @UiThread
  public WebContentsFragment_ViewBinding(WebContentsFragment target, View source) {
    this.target = target;

    target.mNewsFeedWebView = Utils.findRequiredViewAsType(source, R.id.news_feed_web_view, "field 'mNewsFeedWebView'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WebContentsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mNewsFeedWebView = null;
  }
}
