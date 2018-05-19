package com.simalee.guangxiu.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zb.yang on 2018/5/14.
 */

public class EmbroideryWorkItem implements Parcelable {
    private String imageUrl;
    private String workName;
    private String workDescription;
    private String authorName;
    private int type;

    public EmbroideryWorkItem() {
    }

    public EmbroideryWorkItem(String imageUrl, String workName, String workDescription, String authorName, int type) {
        super();
        this.imageUrl = imageUrl;
        this.workName = workName;
        this.workDescription = workDescription;
        this.authorName = authorName;
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isUseType(int useType){
        int currentUseType = type/10;
        if(currentUseType == useType){
            return true;
        }else{
            return false;
        }
    }

    public boolean isThemeType(int themeType){
        int currentUseType = type%10;
        if(currentUseType == themeType){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageUrl);
        dest.writeString(this.workName);
        dest.writeString(this.workDescription);
        dest.writeString(this.authorName);
        dest.writeInt(this.type);
    }

    protected EmbroideryWorkItem(Parcel in) {
        this.imageUrl = in.readString();
        this.workName = in.readString();
        this.workDescription = in.readString();
        this.authorName = in.readString();
        this.type = in.readInt();
    }

    public static final Creator<EmbroideryWorkItem> CREATOR = new Creator<EmbroideryWorkItem>() {
        @Override
        public EmbroideryWorkItem createFromParcel(Parcel source) {
            return new EmbroideryWorkItem(source);
        }

        @Override
        public EmbroideryWorkItem[] newArray(int size) {
            return new EmbroideryWorkItem[size];
        }
    };

    @Override
    public String toString() {
        return "EmbroideryWorkItem{" +
                "imageUrl='" + imageUrl + '\'' +
                ", workName='" + workName + '\'' +
                ", workDescription='" + workDescription + '\'' +
                ", authorName='" + authorName + '\'' +
                ", type=" + type +
                '}';
    }
}
