package com.simalee.guangxiu.data.entity;

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

    public ThreadItem() {
    }

    @Override
    public String toString() {
        return "ThreadItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
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
}
