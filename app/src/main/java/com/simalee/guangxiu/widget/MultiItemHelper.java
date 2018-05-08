package com.simalee.guangxiu.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.data.entity.TextImageItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class MultiItemHelper {

    private static final String TAG = "MultiItemHelper";

    private MultiItemContainer mContainer;

    private List<TextImageItem> mItemList;

    private static int viewCounter;

    public MultiItemHelper(MultiItemContainer container){
        mContainer = container;
        viewCounter = 0;
    }

    /**
     * 根据item info 在container中添加view
     * @param itemInfo
     */
    public void addItem(TextImageItem itemInfo){

        if (mItemList == null){
            mItemList = new ArrayList<>();
        }
        mItemList.add(itemInfo);
        addViewFor(itemInfo);
    }

    private void addViewFor(TextImageItem itemInfo) {

        if (itemInfo.getType() == TextImageItem.TYPE_IMAGE){
            createAndAddImageView(itemInfo);
        }else if (itemInfo.getType() == TextImageItem.TYPE_TEXT){
            createAndAddTextView(itemInfo);
        }

    }

    private void createAndAddImageView(TextImageItem itemInfo) {
        ImageView imageView = new ImageView(mContainer.getContext());

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(itemInfo.getWidth(),itemInfo.getHeight());
        layoutParams.setMargins(10,10,10,10);

        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        //todo 图片加载
        Glide.with(mContainer.getContext())
                .load(itemInfo.getImageurl())
                .error(R.mipmap.ic_launcher)
                .override(itemInfo.getWidth(),itemInfo.getHeight())
                .into(imageView);

        Log.d(TAG, "createAndAddImageView: addView "+viewCounter);
        mContainer.addView(imageView,viewCounter);
        viewCounter++;
    }

    private void createAndAddTextView(TextImageItem itemInfo) {
        String seperator = "100-100";
        String[] splits = itemInfo.getText().split(seperator);
        TextView textView;
        for (int i = 0; i < splits.length; i++){
            textView = new TextView(mContainer.getContext());
            textView.setText(splits[i]);
            textView.setPadding(10,10,10,10);
            textView.setTextSize(20f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            textView.setLayoutParams(layoutParams);

            mContainer.addView(textView,viewCounter);
            Log.d(TAG, "createAndAddTextView: addView "+viewCounter);
            viewCounter++;
        }
    }


    /**
     * item的顺序需要在传递参数时确定
     * 根据itemList 在container中添加view
     * @param itemList
     */
    public void addItems(List<TextImageItem> itemList){

        for (TextImageItem item: itemList) {
            addItem(item);
        }
    }

    public void clear(){
        mItemList.clear();
        viewCounter = 0;
    }
    /**
     * 根据item info 生成对应的view并设置属性
     * @param context
     * @param itemInfo
     * @return
     */
    public static View createView(Context context,TextImageItem itemInfo){
        TextView textView = new TextView(context);
        textView.setText(itemInfo.getText());
        textView.setPadding(10,10,10,10);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(params);
        return textView;
    }
}
