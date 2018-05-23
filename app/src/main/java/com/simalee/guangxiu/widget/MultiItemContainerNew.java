package com.simalee.guangxiu.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

import com.SuperKotlin.pictureviewer.ImagePagerActivity;
import com.SuperKotlin.pictureviewer.PictureConfig;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.data.entity.TextImageItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/20.
 */

public class MultiItemContainerNew extends RecyclerView {
    private static final String TAG = "MultiItemContainerNew";

    private Context mContext;
    private MultiItemAdapter mAdapter;

    public MultiItemContainerNew(Context context) {
        super(context);
        init(context);
    }

    public MultiItemContainerNew(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MultiItemContainerNew(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        mContext = context;

        this.setLayoutManager(new LinearLayoutManager(context));

        mAdapter = new MultiItemAdapter(context,new ArrayList<TextImageItem>());
        this.setAdapter(mAdapter);

        mAdapter.setOnImageClickListener(new MultiItemAdapter.OnImageClickListener() {
            @Override
            public void onImageClick(List<String> imageUrlList, int position) {

                ArrayList urlList = new ArrayList(imageUrlList);

                PictureConfig config = new PictureConfig.Builder()
                        .setListData(urlList)//图片数据List<String> list
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

    /**
     * 兼容旧的实现 添加接口
     * @param textImageItems
     */
    public void addItems(List<TextImageItem> textImageItems){
        if (mAdapter != null){
            mAdapter.addItems(textImageItems);
        }
    }

    public void replaceItems(List<TextImageItem> textImageItems){
        if(textImageItems == null || textImageItems.size() == 0){
            return;
        }
        if (mAdapter != null){
            mAdapter.replaceItems(textImageItems);
        }
    }

    public void clear(){
        if (mAdapter != null){
            mAdapter.clear();
        }
    }

}
