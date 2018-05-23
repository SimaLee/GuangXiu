package com.simalee.guangxiu.data.entity;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/23.
 */

public class ProcessItem implements Comparable<ProcessItem>,Serializable{
    //工艺流程item

    public ProcessItem() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TextImageItem> getItemList() {
        return mItemList;
    }

    public void setItemList(List<TextImageItem> itemList) {
        mItemList = itemList;
    }

    @Override
    public String toString() {
        return "ProcessItem{" +
                "id='" + id + '\'' +
                ", sequence=" + sequence +
                ", name='" + name + '\'' +
                ", mItemList=" + mItemList +
                '}';
    }

    private String id;//item id
    private int sequence;//标识是第几个工艺
    private String name;//工艺流程名字
    private List<TextImageItem> mItemList;//具体展示的内容

    @Override
    public int compareTo(@NonNull ProcessItem o) {
        if (o == null){
            return -1;
        }
        if (!(o instanceof ProcessItem)){
            return -1;
        }
        return (this.sequence - o.getSequence());
    }
}
