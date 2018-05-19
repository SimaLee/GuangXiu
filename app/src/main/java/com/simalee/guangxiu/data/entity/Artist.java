package com.simalee.guangxiu.data.entity;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/10.
 */

public class Artist {
    //名家
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }


    public List<EmbroideryWorkItem> getWorkList() {
        return workList;
    }

    public void setWorkList(List<EmbroideryWorkItem> workList) {
        this.workList = workList;
    }

    public Artist() {
        id = "";
        name = "";
        avatar = "";
        address = "";
        contact = "";
        honor = "";
        introduction = "";
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", honor='" + honor + '\'' +
                ", introduction='" + introduction + '\'' +
                ", workList=" + workList +
                '}';
    }

    /**
     * 名家id
     */
    String id;
    /**
     * 姓名
     */
    String name;
    /**
     * 头像
     */
    String avatar;
    /**
     * 联系地址
     */
    String address;
    /**
     * 联系方式
     */
    String contact;
    /**
     * 获得荣誉
     */
    String honor;
    /**
     * 名家简介
     */
    String introduction;


    /**
     * 名家作品列表
     */
    List<EmbroideryWorkItem> workList;
}
