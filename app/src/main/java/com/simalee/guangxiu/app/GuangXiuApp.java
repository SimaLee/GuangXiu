package com.simalee.guangxiu.app;

import android.app.Application;

import com.simalee.guangxiu.data.DataManager;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;

import okhttp3.OkHttpClient;

/**
 * Created by Lee Sima on 2018/4/24.
 */

public class GuangXiuApp extends Application {

    private static final String TAG = "GuangXiuApp";

    @Override
    public void onCreate() {
        super.onCreate();

        initOkhttp();
        initDataManager();
    }

    private void initDataManager() {
        DataManager.init(this);
    }

    private void initOkhttp(){
        //配置OkHttp
        CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(getApplicationContext()));
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
}
