package com.simalee.guangxiu.data.entity;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class StitchItem {
    //针法大类

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

    public StitchItem() {
    }

    @Override
    public String toString() {
        return "StitchItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    /**
     * 针法的id
     */
    String id;
    /**
     * 针法的名字
     */
    String name;
    /**
     * 针法的图片
     */
    String image;
}
