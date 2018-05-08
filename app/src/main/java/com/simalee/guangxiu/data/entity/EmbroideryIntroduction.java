package com.simalee.guangxiu.data.entity;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/8.
 */

public class EmbroideryIntroduction {
    public List<TextImageItem> getItemList() {
        return mItemList;
    }

    public void setItemList(List<TextImageItem> itemList) {
        mItemList = itemList;
    }

    public EmbroideryIntroduction() {
    }

    public EmbroideryIntroduction(List<TextImageItem> itemList) {
        mItemList = itemList;
    }

    @Override
    public String toString() {
        return "EmbroideryIntroduction{" +
                "mItemList=" + mItemList +
                '}';
    }

    private List<TextImageItem> mItemList;
}
