package com.simalee.guangxiu.data.entity;

import android.support.annotation.NonNull;

/**
 * Created by Lee Sima on 2018/5/6.
 * 图文编排item
 */

public class TextImageItem implements Comparable<TextImageItem>{

    public static final int TYPE_IMAGE = 0;
    public static final int TYPE_TEXT = 1;

    /**
     * 图文item的id
     */
    String id;
    /**
     * 序列号
     */
    int sequence;
    /**
     * item 类型
     */
    int type;
    /**
     * 文字描述
     */
    String text;
    /**
     * 图片宽度
     */
    int width;
    /**
     * 图片高度
     */
    int height;
    /**
     * 图片url
     */
    String imageurl;

    public int getLocalImageId() {
        return localImageId;
    }

    public void setLocalImageId(int localImageId) {
        this.localImageId = localImageId;
    }

    /**
     * 本地图片资源id 设置了本地资源id后
     * 不对imageUrl进行加载，转而加载本地资源
     */
    int localImageId = -1;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    @Override
    public String toString() {
        return "TextImageItem{" +
                "id='" + id + '\'' +
                ", sequence=" + sequence +
                ", type=" + type +
                ", text='" + text + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", imageurl='" + imageurl + '\'' +
                ", localImageId='" + localImageId + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NonNull TextImageItem o) {
        if (o == null){
            return -1;
        }
        if (!(o instanceof TextImageItem)){
            return -1;
        }
        return (this.sequence - o.getSequence());
    }

    public boolean isImageItem(){
        return TYPE_IMAGE == this.type;
    }

    public boolean isTextItem(){
        return TYPE_TEXT == this.type;
    }
}
