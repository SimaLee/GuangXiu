package com.simalee.guangxiu.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Lee Sima on 2018/5/14.
 */

public class PreferenceUtil {

    public static final String KEY_FIRST_VERSION_REQUEST  = "key_first_version_request";//true | false 初始化时为true
    private static final String PREF_NAME = "guangxiu_pref";


    /**
     * @param context
     * @param firstRequeest
     */
    public static void setFirstVersionRequest(Context context, boolean firstRequeest){
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(KEY_FIRST_VERSION_REQUEST,firstRequeest);
        editor.apply();
    }
    public static  boolean getFirstVersionRequest(Context context){
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        return  preferences.getBoolean(KEY_FIRST_VERSION_REQUEST,true);
    }
}
