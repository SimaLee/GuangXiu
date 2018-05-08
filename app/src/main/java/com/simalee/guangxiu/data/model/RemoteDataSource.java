package com.simalee.guangxiu.data.model;

import android.util.Log;

import com.simalee.guangxiu.app.UrlConstants;
import com.simalee.guangxiu.data.DataSource;
import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.data.entity.PergolaIntroduction;
import com.simalee.guangxiu.data.entity.SimpleIntroduction;
import com.simalee.guangxiu.data.entity.Version;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;

/**
 * Created by Lee Sima on 2018/5/1.
 */

public class RemoteDataSource implements DataSource {

    private static final String TAG = "RemoteDataSource";

    public RemoteDataSource(){

    }

    @Override
    public void getIntroduction(final DataCallback<SimpleIntroduction> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_DESCRIPTION)
                .addParams("version","11")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d(TAG, "onError: " + e.toString());
                        callback.onFailure("error");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "onResponse: " +response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("msg");
                            if (code.equals("200")){
                                JSONObject data = jsonObject.getJSONObject("data");
                                callback.onSuccess(ResponseParser.parseSimpleIntroduction(data));
                            }else{
                                callback.onFailure(msg);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

    }

    @Override
    public void getVersionCode(final DataCallback<Version> callback) {
        //联网完成数据获取
        OkHttpUtils.get()
                .url(UrlConstants.URL_GET_VERSION)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {

                        try {
                            JSONObject object = new JSONObject(response);
                            String code = object.getString("code");
                            String msg = object.getString("msg");

                            if (code.equals("200")){
                                JSONObject data = object.getJSONObject("data");

                                callback.onSuccess(ResponseParser.parseVersion(data));

                            }else{
                                callback.onFailure(object.getString("msg"));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void getArtFeature(final DataCallback<ArtFeature> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_ART_FEATURE)
                .addParams("version","11")
                .addParams("id","4")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "onResponse: " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("msg");

                            if (code.equals("200")){

                                JSONObject data = jsonObject.getJSONObject("data");
                                callback.onSuccess(ResponseParser.parseArtFeature(data));

                            }else{
                                callback.onFailure(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    /**
     * 获取花架介绍
     * @param callback
     */
    @Override
    public void getPergolaIntroduction(final DataCallback<PergolaIntroduction> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_PERGOLA_INTRODUCTION)
                .addParams("version","11")
                .addParams("id","5")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "onResponse: " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("msg");

                            if (code.equals("200")){

                                JSONObject data = jsonObject.getJSONObject("data");
                                callback.onSuccess(ResponseParser.parsePergolaIntroduction(data));

                            }else{
                                callback.onFailure(msg);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }


}
