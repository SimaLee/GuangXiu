package com.simalee.guangxiu.data.entity;

/**
 * Created by Lee Sima on 2018/5/6.
 */

public class Version {

    public Version(){

    }

    public Version(int versionCode) {
        this.versionCode = versionCode;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    @Override
    public String toString() {
        return "Version{" +
                "versionCode=" + versionCode +
                '}';
    }

    int versionCode;

}
