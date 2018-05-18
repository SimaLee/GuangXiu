package com.simalee.guangxiu.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zb.yang on 2018/5/8.
 */

public class DevelopmentItem implements Parcelable {
    public static final String TAG = "DevelopmentItem";
    private int seq;
    private String des;
    private int developmentItemId;
    private String imageUrl;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getDevelopmentItemId() {
        return developmentItemId;
    }

    public void setDevelopmentItemId(int developmentItemId) {
        this.developmentItemId = developmentItemId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.seq);
        dest.writeString(this.des);
        dest.writeInt(this.developmentItemId);
        dest.writeString(this.imageUrl);
    }

    public DevelopmentItem() {
    }

    protected DevelopmentItem(Parcel in) {
        this.seq = in.readInt();
        this.des = in.readString();
        this.developmentItemId = in.readInt();
        this.imageUrl = in.readString();
    }

    public static final Creator<DevelopmentItem> CREATOR = new Creator<DevelopmentItem>() {
        @Override
        public DevelopmentItem createFromParcel(Parcel source) {
            return new DevelopmentItem(source);
        }

        @Override
        public DevelopmentItem[] newArray(int size) {
            return new DevelopmentItem[size];
        }
    };
}
