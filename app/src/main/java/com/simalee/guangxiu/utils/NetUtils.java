package com.simalee.guangxiu.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Lee Sima on 2018/5/8.
 */

public class NetUtils {

    private static final String TAG = "NetUtils";

    private NetUtils(){

    }

    /**
     * 判断网络是否可用
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null){

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()){
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否wifi连接
     * @param context
     * @return
     */
    public static boolean isWifiConnected(Context context ){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null){
            return false;
        }
        return connectivityManager.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;
    }


}
