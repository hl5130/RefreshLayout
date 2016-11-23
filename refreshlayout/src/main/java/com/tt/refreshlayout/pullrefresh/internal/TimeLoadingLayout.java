package com.tt.refreshlayout.pullrefresh.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

import com.tt.refreshlayout.pullrefresh.views.PullToRefreshBase;

/**
 * Created by Administrator on 2016/11/23.
 */
public class TimeLoadingLayout extends LoadingLayout {
    public TimeLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation scrollDirection, TypedArray attrs) {
        super(context, mode, scrollDirection, attrs);
    }

    @Override
    protected int getDefaultDrawableResId() {
        return 0;
    }

    @Override
    protected void onLoadingDrawableSet(Drawable imageDrawable) {

    }

    @Override
    protected void onPullImpl(float scaleOfLayout) {

    }

    /**
     * 拉动中
     */
    @Override
    protected void pullToRefreshImpl() {

    }

    /**
     * 刷新中
     */
    @Override
    protected void refreshingImpl() {

    }

    /**
     * 释放刷新
     */
    @Override
    protected void releaseToRefreshImpl() {

    }

    /**
     * 重启
     */
    @Override
    protected void resetImpl() {

    }
}
