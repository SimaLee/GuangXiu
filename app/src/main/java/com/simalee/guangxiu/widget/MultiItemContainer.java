package com.simalee.guangxiu.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.SuperKotlin.pictureviewer.ImagePagerActivity;
import com.SuperKotlin.pictureviewer.PictureConfig;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.data.entity.TextImageItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/6.
 */

public class MultiItemContainer extends LinearLayout{

    private static final String TAG = "MultiItemContainerNew";

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
        mItemHelper.setOnImageClickListener(new MultiItemHelper.OnImageClickListener() {
            @Override
            public void onImageClick(ArrayList<String> imageUrlList, int position) {

                PictureConfig config = new PictureConfig.Builder()
                        .setListData(imageUrlList)//图片数据List<String> list
                        .setPosition(position)//图片下标（从第position张图片开始浏览）
                        .setDownloadPath("pictureviewer")//图片下载文件夹地址
                        .setIsShowNumber(true)//是否显示数字下标
                        .needDownload(true)//是否支持图片下载
                        .setPlacrHolder(R.mipmap.avatar_default)//占位符图片（图片加载完成前显示的资源图片，来源drawable或者mipmap）
                        .build();

                ImagePagerActivity.startActivity(getContext(), config);
            }
        });
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

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clear();
    }
}
