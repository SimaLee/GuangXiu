package com.simalee.guangxiu.data.entity;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class StitchInfoDetail {
    public List<TextImageItem> getItemList() {
        return mItemList;
    }

    public void setItemList(List<TextImageItem> itemList) {
        mItemList = itemList;
    }

    public StitchInfoDetail() {
    }

    @Override
    public String toString() {
        return "StitchInfoDetail{" +
                "mItemList=" + mItemList +
                '}';
    }

    //针法介绍
    private List<TextImageItem> mItemList;
}
