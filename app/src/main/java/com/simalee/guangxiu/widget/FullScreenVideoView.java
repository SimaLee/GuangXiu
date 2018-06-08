package com.simalee.guangxiu.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by Lee Sima on 2018/6/8.
 */

public class FullScreenVideoView extends VideoView {
    private static final String TAG = "FullScreenVideoView";


    public FullScreenVideoView(Context context) {
        super(context);
    }

    public FullScreenVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullScreenVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FullScreenVideoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //设置宽高属性，使其全屏
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0,heightMeasureSpec);

        setMeasuredDimension(width,height);
    }
}
