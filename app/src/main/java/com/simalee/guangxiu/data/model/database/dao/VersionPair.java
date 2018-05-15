package com.simalee.guangxiu.data.model.database.dao;

/**
 * Created by Lee Sima on 2018/5/14.
 */

public class VersionPair {

    public int getOldVersion() {
        return oldVersion;
    }

    public void setOldVersion(int oldVersion) {
        this.oldVersion = oldVersion;
    }

    public int getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(int newVersion) {
        this.newVersion = newVersion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VersionPair() {

    }

    public VersionPair(String name, int oldVersion, int newVersion) {
        this.name = name;
        this.oldVersion = oldVersion;
        this.newVersion = newVersion;
    }

    @Override
    public String toString() {
        return "VersionPair{" +
                "name=" + name +
                ", oldVersion=" + oldVersion +
                ", newVersion=" + newVersion +
                '}';
    }

    /**
     * 是否有新的版本信息
     * 为true时 表明本地数据版本落后，需要网络请求更新数据。
     * @return
     */
    public boolean hasNewVersion(){
        return oldVersion < newVersion;
    }

    String name;
    int oldVersion;
    int newVersion;

}
