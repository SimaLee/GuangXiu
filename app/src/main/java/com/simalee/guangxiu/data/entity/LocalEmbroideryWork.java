package com.simalee.guangxiu.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zb.yang on 2018/5/23.
 */

public class LocalEmbroideryWork implements Parcelable {
    public static final String TAG = "LocalEmbroideryWork";
    public static final int PANO_TYPE = 1;
    public static final int PHOTO_TYPE = 2;

    private int id;
    private int type;
    private String authorName;
    private String workName;
    private String workDes;
    private String workPath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getWorkDes() {
        return workDes;
    }

    public void setWorkDes(String workDes) {
        this.workDes = workDes;
    }

    public String getWorkPath() {
        return workPath;
    }

    public void setWorkPath(String workPath) {
        this.workPath = workPath;
    }


    @Override
    public String toString() {
        return "LocalEmbroideryWork{" +
                "id=" + id +
                ", type=" + type +
                ", authorName='" + authorName + '\'' +
                ", workName='" + workName + '\'' +
                ", workDes='" + workDes + '\'' +
                ", workPath='" + workPath + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.type);
        dest.writeString(this.authorName);
        dest.writeString(this.workName);
        dest.writeString(this.workDes);
        dest.writeString(this.workPath);
    }

    public LocalEmbroideryWork() {
    }

    protected LocalEmbroideryWork(Parcel in) {
        this.id = in.readInt();
        this.type = in.readInt();
        this.authorName = in.readString();
        this.workName = in.readString();
        this.workDes = in.readString();
        this.workPath = in.readString();
    }

    public static final Creator<LocalEmbroideryWork> CREATOR = new Creator<LocalEmbroideryWork>() {
        @Override
        public LocalEmbroideryWork createFromParcel(Parcel source) {
            return new LocalEmbroideryWork(source);
        }

        @Override
        public LocalEmbroideryWork[] newArray(int size) {
            return new LocalEmbroideryWork[size];
        }
    };
}
