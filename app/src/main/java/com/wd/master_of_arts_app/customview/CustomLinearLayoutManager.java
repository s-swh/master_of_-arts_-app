package com.wd.master_of_arts_app.customview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * 开启或关闭滑动
 */
public class CustomLinearLayoutManager extends LinearLayoutManager {
    private boolean isScrollEnabled = false;

    public CustomLinearLayoutManager(Context context) {
        super(context);
    }

    public CustomLinearLayoutManager(Context context, boolean isScrollEnabled) {
        super(context);
        this.isScrollEnabled = isScrollEnabled;
    }

    public CustomLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public CustomLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        int orientation = getOrientation();
        if (orientation == LinearLayoutManager.VERTICAL) {
            return isScrollEnabled && super.canScrollVertically();
        }
        return super.canScrollVertically();
    }

    @Override
    public boolean canScrollHorizontally() {
        int orientation = getOrientation();
        if (orientation == LinearLayoutManager.HORIZONTAL) {
            return isScrollEnabled && super.canScrollHorizontally();
        }
        return super.canScrollHorizontally();
    }
}
