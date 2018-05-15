package com.simalee.guangxiu.data.model;

import android.util.Log;

import com.simalee.guangxiu.app.UrlConstants;
import com.simalee.guangxiu.data.DataSource;
import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.data.entity.Artist;
import com.simalee.guangxiu.data.entity.EmbroideryIntroduction;
import com.simalee.guangxiu.data.entity.PergolaIntroduction;
import com.simalee.guangxiu.data.entity.QuizItem;
import com.simalee.guangxiu.data.entity.SimpleIntroduction;
import com.simalee.guangxiu.data.entity.StitchInfoDetail;
import com.simalee.guangxiu.data.entity.StitchIntroduction;
import com.simalee.guangxiu.data.entity.StitchItem;
import com.simalee.guangxiu.data.entity.ThreadIntroduction;
import com.simalee.guangxiu.data.entity.ThreadItem;
import com.simalee.guangxiu.data.entity.Version;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

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
                        Log.d(TAG, "onResponse: response "+response);
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

    @Override
    public void getStitchIntroduction(final DataCallback<StitchIntroduction> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_STITCH_INTRODUCTION)
                .addParams("version","11")
                .addParams("id","6")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "onResponse: getStitchInstruction" + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("msg");

                            if (code.equals("200")){

                                JSONObject data = jsonObject.getJSONObject("data");
                                callback.onSuccess(ResponseParser.parseStitchIntroduction(data));

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
    public void getThreadList(final DataCallback<List<ThreadItem>> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_THREAD_LIST)
                .addParams("version","11")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError: "+ e.toString());
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "onResponse: getThreadList:" + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("msg");

                            if (code.equals("200")){

                                JSONArray data = jsonObject.getJSONArray("data");
                                callback.onSuccess(ResponseParser.parseThreadList(data));

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
    public void getThreadWithId(String threadId, final DataCallback<ThreadIntroduction> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_THREAD_INTRODUCTION)
                .addParams("version","11")
                .addParams("id",threadId)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError: "+ e.toString());
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "onResponse: getThreadWithId: " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("msg");

                            if (code.equals("200")){

                                JSONObject data = jsonObject.getJSONObject("data");
                                callback.onSuccess(ResponseParser.parseThreadIntroduction(data));

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
    public void getEmbroideryWithId(String embroideryId, final DataCallback<EmbroideryIntroduction> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_EMBROIDERY_INTRODUCTION)
                .addParams("version","11")
                .addParams("id",embroideryId)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError: ", e);
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "onResponse: getEmbroideryWithId:" + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("msg");

                            if (code.equals("200")){

                                JSONObject data = jsonObject.getJSONObject("data");
                                callback.onSuccess(ResponseParser.parseEmbroideryIntroduction(data));

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
    public void getStitchList(final DataCallback<List<StitchItem>> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_STITCH_LIST)
                .addParams("version","11")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError: ",e);
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "onResponse: getStitchList:" + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("msg");

                            if (code.equals("200")){

                                JSONArray data = jsonObject.getJSONArray("data");
                                callback.onSuccess(ResponseParser.parseStitchItemList(data));

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
    public void getStitchInfoWithId(String stitchId, final DataCallback<StitchInfoDetail> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_STITCH_INFO)
                .addParams("version","11")
                .addParams("id",stitchId)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError: ", e);
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "onResponse: getStitchInfoWithId: " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("msg");

                            if (code.equals("200")){

                                JSONObject data = jsonObject.getJSONObject("data");
                                callback.onSuccess(ResponseParser.parseStitchInfoDetail(data));

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
    public void getArtistList(final DataCallback<List<Artist>> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_ARTIST_LIST)
                .addParams("version","11")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError: ", e);
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "onResponse: getArtistList: " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("msg");

                            if (code.equals("200")){

                                JSONArray data = jsonObject.getJSONArray("data");
                                callback.onSuccess(ResponseParser.parseArtistList(data));

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
    public void getArtistInfoWithId(String artistId, final DataCallback<Artist> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_ARTIST_INFO)
                .addParams("id",artistId)
                .addParams("version","11")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError: ", e);
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "onResponse: getArtistWithId: " +response);

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("msg");

                            if (code.equals("200")){

                                JSONObject data = jsonObject.getJSONObject("data");
                                callback.onSuccess(ResponseParser.parseArtistInfo(data));

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
    public void getQuizList(final DataCallback<List<QuizItem>> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_QUIZ_LIST)
                .addParams("version","11")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError: ", e);
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "onResponse: getQuizList " + response);

                        Log.d(TAG, "onResponse: getArtistWithId: " +response);

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("msg");

                            if (code.equals("200")){

                                JSONArray data = jsonObject.getJSONArray("data");
                                callback.onSuccess(ResponseParser.parseQuizList(data));

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
