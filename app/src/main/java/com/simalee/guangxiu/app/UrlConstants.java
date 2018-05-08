package com.simalee.guangxiu.app;

/**
 * Created by Lee Sima on 2018/5/8.
 */

public interface UrlConstants {

    public static final String BASE_URL = "http://110.64.89.19:8080/GuangXiu/";

    public static final String URL_GET_VERSION = BASE_URL + "ConfigInfo/version";
    /**
     * 广绣简要介绍
     */
    public static final String URL_GET_DESCRIPTION = BASE_URL + "EmbroideryDesc/desc";
    /**
     * 广绣艺术特点
     */
    //
    public static final String URL_GET_ART_FEATURE = BASE_URL + "GraphicItem/";

    /**
     * 广绣材料:花架介绍
     */
    public static final String URL_GET_PERGOLA_INTRODUCTION = BASE_URL + "GraphicItem/";


}
