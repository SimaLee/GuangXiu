package com.simalee.guangxiu.data.entity;

/**
 * Created by zb.yang on 2018/5/10.
 */

public class TeachingContentItem {

    public TeachingContentItem(String name,int time,String coverUrl,String videoUrl,int type) {
        super();
        this.videoName = name;
        this.videoTime = time;
        this.coverUrl = coverUrl;
        this.videoUrl = videoUrl;
        this.videoType = type;
    }

    /**
     * 视频id
     */
    private String videoId;
    /**
     * 视频url
     */
    private String videoUrl;
    /**
     * 视频截图url
     */
    private String coverUrl;
    /**
     * 视频名称
     */
    private String videoName;
    /**
     * 视频简介
     */
    private String videoDesc;
    /**
     * 视频时长
     */
    private int videoTime;
    /**
     * 视频类型
     */
    private int videoType;
    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    public int getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(int videoTime) {
        this.videoTime = videoTime;
    }

    public int getVideoType() {
        return videoType;
    }

    public void setVideoType(int videoType) {
        this.videoType = videoType;
    }
}
