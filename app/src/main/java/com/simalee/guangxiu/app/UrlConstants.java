package com.simalee.guangxiu.app;

/**
 * Created by Lee Sima on 2018/5/8.
 */

public interface UrlConstants {

    public static final String BASE_URL = "http://110.64.89.19:8080/GuangXiu";

    public static final String BASE_FILE_URL = BASE_URL +"/files/";

    /**
     * 获取资料版本号
     */
    public static final String URL_GET_VERSION = BASE_URL + "/ConfigInfo/version";
    /**
     * 广绣简要介绍
     */
    public static final String URL_GET_DESCRIPTION = BASE_URL + "/EmbroideryDesc/desc";
    /**
     * 广绣艺术特点
     */
    //
    public static final String URL_GET_ART_FEATURE = BASE_URL + "/GraphicItem/";

    /**
     * 广绣材料:花架介绍
     */
    public static final String URL_GET_PERGOLA_INTRODUCTION = BASE_URL + "/GraphicItem/";

    /**
     * 广绣材料:绣针介绍
     */
    public static final String URL_GET_STITCH_INTRODUCTION = BASE_URL + "/GraphicItem/";

    /**
     * 获取绣线列表
     */
    public static final String URL_GET_THREAD_LIST = BASE_URL + "/ThreadInfo/thread";

    /**
     * 获取绣线介绍
     */
    public static final String URL_GET_THREAD_INTRODUCTION = BASE_URL + "/GraphicItem/";

    /**
     * 获取绣种介绍
     */
    public static final String URL_GET_EMBROIDERY_INTRODUCTION = BASE_URL + "/Embroidery/specific";


    /**
     * 获取针法列表
     */
    public static final String URL_GET_STITCH_LIST= BASE_URL + "/StitchInfo/stitch";

    /**
     * 获取指定针法的介绍
     */
    public static final String URL_GET_STITCH_INFO= BASE_URL + "/GraphicItem/";





}
