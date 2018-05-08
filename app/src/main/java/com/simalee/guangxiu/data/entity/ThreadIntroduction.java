package com.simalee.guangxiu.data.entity;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class ThreadIntroduction {

    public ThreadIntroduction() {
    }

    @Override
    public String toString() {
        return "ThreadIntroductionActivity{" +
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
