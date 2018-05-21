package com.simalee.guangxiu.app;


/**
 * Created by Lee Sima on 2018/5/8.
 */

public interface UrlConstants {

    public static final String IP_ADDRESS = "http://119.29.224.50";
    public static final String PORT = ":8080";

    public static final String BASE_URL = IP_ADDRESS + PORT + "/GuangXiu";

    public static final String BASE_FILE_URL = IP_ADDRESS +"/uploads/GXImage/";

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
    public static final String URL_GET_ART_FEATURE = BASE_URL + "/Arts/features";

    /**
     * 广绣材料:花架介绍
     */
    public static final String URL_GET_PERGOLA_INTRODUCTION = BASE_URL + "/Material/pergola";

    /**
     * 广绣材料:绣针介绍
     */
    public static final String URL_GET_STITCH_INTRODUCTION = BASE_URL + "/Material/needle";

    /**
     * 获取绣线列表
     */
    public static final String URL_GET_THREAD_LIST = BASE_URL + "/ThreadInfo/thread";

    /**
     * 获取绣线介绍
     */
    public static final String URL_GET_THREAD_INTRODUCTION = BASE_URL + "/Thread/item";

    /**
     * 获取绣种介绍
     */
    public static final String URL_GET_EMBROIDERY_INTRODUCTION = BASE_URL + "/Embroider/item";


    /**
     * 获取针法列表
     */
    public static final String URL_GET_STITCH_LIST= BASE_URL + "/StitchInfo/stitch";

    /**
     * 获取指定针法的介绍
     */
    public static final String URL_GET_STITCH_INFO= BASE_URL + "/Stitch/item";

    /**
     * 获取名家列表
     */
    public static final String URL_GET_ARTIST_LIST = BASE_URL + "/MasterInfo/master";

    /**
     * 获取名家介绍
     */
    public static final String URL_GET_ARTIST_INFO = BASE_URL + "/MasterInfo/desc";

    public static final String URL_GET_QUIZ_LIST = BASE_URL + "/Answering/answer";


    //---------------------------------------------------------------

    /**
     * 获取教学视频列表
     */
    public static final String URL_GET_TEACHING_VIDEO = BASE_URL +"/Teaching/video";

    /**
     * 获取所有作品列表
     */
    public static final String URL_GET_ALL_WORK = BASE_URL + "/MasterInfo/work";

    /**
     * 获取广绣历史起源
     */
    public static final String URL_GET_ORIGIN = BASE_URL +"/Origin";

    /**
     * 获取广绣未来发展
     */
    public static final String URL_GET_FUTURE_DEVELOPMENT = BASE_URL +"/Development";

    /**
     * 获取文化寓意
     */
    public static final String URL_GET_CULTURE_MEANING = BASE_URL +"/Meaning";

    /**
     * 获取发展过程
     */
    public static final String URL_GET_DEVELOPMENT_PROCESS = BASE_URL +"/PhaseInfo/phases";

    /**
     * 获取发展过程具体项
     */
    public static final String URL_GET_DEVELOPMENT_ITEM = BASE_URL +"/Phases/item";

}
