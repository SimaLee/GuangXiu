package com.simalee.guangxiu.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simalee.guangxiu.data.entity.TextImageItem;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/6.
 */

public class MultiItemContainer extends LinearLayout{

    private static final String TAG = "MultiItemContainer";

    private MultiItemHelper mItemHelper;

    public MultiItemContainer(Context context) {
        super(context);
        init();
    }

    public MultiItemContainer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public MultiItemContainer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public MultiItemContainer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        setOrientation(LinearLayout.VERTICAL);
        mItemHelper = new MultiItemHelper(this);
    }

    public void addItem(TextImageItem itemInfo){
        mItemHelper.addItem(itemInfo);
    }

    public void addItems(List<TextImageItem> imageItems){
        mItemHelper.addItems(imageItems);
    }

    /**
     * 清除所有子view
     */
    public void clear(){
        mItemHelper.clear();
        removeAllViews();
    }

}
