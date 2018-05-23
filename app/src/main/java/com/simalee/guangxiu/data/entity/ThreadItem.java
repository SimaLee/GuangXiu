package com.simalee.guangxiu.data.entity;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class ThreadItem {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public List<TextImageItem> getItemList() {
        return mItemList;
    }

    public void setItemList(List<TextImageItem> itemList) {
        mItemList = itemList;
    }

    public ThreadItem() {
    }

    @Override
    public String toString() {
        return "ThreadItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", mItemList=" + mItemList +
                '}';
    }

    /**
     * 绣线的id
     */
    String id;
    /**
     * 绣线的名字
     */
    String name;
    /**
     * 绣线的图片
     */
    String image;

    /**
     * 绣线的介绍
     */
    private List<TextImageItem> mItemList;
}
