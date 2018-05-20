package com.simalee.guangxiu.utils;

import com.simalee.guangxiu.app.UrlConstants;

/**
 * Created by Lee Sima on 2018/5/20.
 */

public class UrlUtils {


    private UrlUtils(){
        //
    }
    /**
     * 获取图片真实路径
     * @param relativePath
     * @return
     */
    public static String getImageUrl(String relativePath){
        return UrlConstants.BASE_FILE_URL + relativePath;
    }
}
