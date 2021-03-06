package com.simalee.guangxiu.utils;

import android.util.Log;

import com.simalee.guangxiu.BuildConfig;

/**
 * Created by Lee Sima on 2018/5/6.
 */

public class LogUtils {

    private static boolean isDebug = BuildConfig.DEBUG;

    private LogUtils(){
        throw new UnsupportedOperationException("LogUtils can't be instantiated!");
    }

    public static void v(String tag,String msg){
        if (isDebug){
            Log.v(tag,msg);
        }
    }

    public static void v(String tag, String msg, Throwable throwable){
        if (isDebug){
            Log.v(tag,msg,throwable);
        }
    }

    public static void d(String tag,String msg){
        if (isDebug){
            Log.d(tag,msg);
        }
    }

    public static void d(String tag, String msg, Throwable throwable){
        if (isDebug){
            Log.d(tag,msg,throwable);
        }
    }

    public static void i(String tag,String msg){
        if (isDebug){
            Log.i(tag,msg);
        }
    }

    public static void i(String tag, String msg, Throwable throwable){
        if (isDebug){
            Log.i(tag,msg,throwable);
        }
    }

    public static void w(String tag,String msg){
        if (isDebug){
            Log.w(tag,msg);
        }
    }

    public static void w(String tag, String msg, Throwable throwable){
        if (isDebug){
            Log.w(tag,msg,throwable);
        }
    }

    public static void e(String tag,String msg){
        if (isDebug){
            Log.e(tag,msg);
        }
    }

    public static void e(String tag, String msg, Throwable throwable){
        if (isDebug){
            Log.e(tag,msg,throwable);
        }
    }
}
