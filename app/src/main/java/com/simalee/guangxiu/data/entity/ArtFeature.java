package com.simalee.guangxiu.data.entity;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class ArtFeature {


    public ArtFeature(){

    }

    public ArtFeature(List<TextImageItem> mItemList) {
        this.mItemList = mItemList;
    }

    @Override
    public String toString() {
        return "ArtFeature{" +
                "mItemList=" + mItemList +
                '}';
    }

    public List<TextImageItem> getItemList() {
        return mItemList;
    }

    public void setItemList(List<TextImageItem> itemList) {
        mItemList = itemList;
    }

    private List<TextImageItem> mItemList;
}
