package com.simalee.guangxiu.data.entity;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class StitchIntroduction {
    public StitchIntroduction(List<TextImageItem> itemList) {
        mItemList = itemList;
    }

    public StitchIntroduction() {
    }

    @Override
    public String toString() {
        return "StitchIntroduction{" +
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
