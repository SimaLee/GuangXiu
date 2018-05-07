package com.simalee.guangxiu.data.entity;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class PergolaIntroduction {

    public PergolaIntroduction(List<TextImageItem> itemList) {
        mItemList = itemList;
    }

    public PergolaIntroduction() {
    }

    public List<TextImageItem> getItemList() {
        return mItemList;
    }

    public void setItemList(List<TextImageItem> itemList) {
        mItemList = itemList;
    }

    @Override
    public String toString() {
        return "PergolaIntroduction{" +
                "mItemList=" + mItemList +
                '}';
    }

    private List<TextImageItem> mItemList;
}
