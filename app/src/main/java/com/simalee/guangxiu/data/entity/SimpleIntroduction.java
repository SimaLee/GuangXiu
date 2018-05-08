package com.simalee.guangxiu.data.entity;

/**
 * Created by Lee Sima on 2018/5/1.
 */

public class SimpleIntroduction {

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(String backgroundImg) {
        this.backgroundImg = backgroundImg;
    }

    @Override
    public String toString() {
        return "SimpleIntroduction{" +
                "description='" + description + '\'' +
                ", backgroundImg='" + backgroundImg + '\'' +
                '}';
    }

    public SimpleIntroduction(){
        description = "";
        backgroundImg = "";
    }

    public SimpleIntroduction(String description, String backgroundImg) {
        this.description = description;
        this.backgroundImg = backgroundImg;
    }

    /**
     * 广绣的简要介绍
     */
    private String description;
    /**
     * 简介的背景图片的url
     */
    private String backgroundImg;

}
