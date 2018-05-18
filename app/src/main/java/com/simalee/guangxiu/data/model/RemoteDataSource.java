package com.simalee.guangxiu.data.model;

import android.util.Log;

import com.simalee.guangxiu.app.UrlConstants;
import com.simalee.guangxiu.data.DataSource;
import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.data.entity.Artist;
import com.simalee.guangxiu.data.entity.DevelopmentItem;
import com.simalee.guangxiu.data.entity.EmbroideryIntroduction;
import com.simalee.guangxiu.data.entity.EmbroideryWorkItem;
import com.simalee.guangxiu.data.entity.PergolaIntroduction;
import com.simalee.guangxiu.data.entity.QuizItem;
import com.simalee.guangxiu.data.entity.SimpleIntroduction;
import com.simalee.guangxiu.data.entity.StitchInfoDetail;
import com.simalee.guangxiu.data.entity.StitchIntroduction;
import com.simalee.guangxiu.data.entity.StitchItem;
import com.simalee.guangxiu.data.entity.TeachingContentItem;
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
    public void getIntroduction(int version,final DataCallback<SimpleIntroduction> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_DESCRIPTION)
                .addParams("version",String.valueOf(version))
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
                        Log.d(TAG, "onResponse: getVersionCode "+response);
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
    public void getArtFeature(int version,final DataCallback<ArtFeature> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_ART_FEATURE)
                .addParams("version",String.valueOf(version))
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
    public void getPergolaIntroduction(int version,final DataCallback<PergolaIntroduction> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_PERGOLA_INTRODUCTION)
                .addParams("version",String.valueOf(version))
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
    public void getStitchIntroduction(int version,final DataCallback<StitchIntroduction> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_STITCH_INTRODUCTION)
                .addParams("version",String.valueOf(version))
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
    public void getThreadList(int version,final DataCallback<List<ThreadItem>> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_THREAD_LIST)
                .addParams("version",String.valueOf(version))
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
    public void getThreadWithId(int version,String threadId, final DataCallback<ThreadIntroduction> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_THREAD_INTRODUCTION)
                .addParams("version",String.valueOf(version))
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
    public void getEmbroideryWithId(int version,String embroideryId, final DataCallback<EmbroideryIntroduction> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_EMBROIDERY_INTRODUCTION)
                .addParams("version",String.valueOf(version))
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
    public void getStitchList(int version,final DataCallback<List<StitchItem>> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_STITCH_LIST)
                .addParams("version",String.valueOf(version))
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
    public void getStitchInfoWithId(int version,String stitchId, final DataCallback<StitchInfoDetail> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_STITCH_INFO)
                .addParams("version",String.valueOf(version))
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
    public void getArtistList(int version,final DataCallback<List<Artist>> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_ARTIST_LIST)
                .addParams("version",String.valueOf(version))
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
    public void getArtistInfoWithId(int version,String artistId, final DataCallback<Artist> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_ARTIST_INFO)
                .addParams("id",artistId)
                .addParams("version",String.valueOf(version))
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
    public void getQuizList(int version,final DataCallback<List<QuizItem>> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_QUIZ_LIST)
                .addParams("version",String.valueOf(version))
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

    @Override
    public void getTeachingVideoList(int version, final DataCallback<List<TeachingContentItem>> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_TEACHING_VIDEO)
                .addParams("version",String.valueOf(version))
                .addParams("type","0")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError: ", e);
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG,"onResponse getTeachingVideoList "+ response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("msg");

                            if (code.equals("200")){
                                JSONArray data = jsonObject.getJSONArray("data");
                                callback.onSuccess(ResponseParser.parseTeachingContentItemList(data));

                            }else{
                                callback.onFailure(msg);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    /**
     *
     * @param version
     * @param callback
     */
    @Override
    public void getAllWorkList(int version, final DataCallback<List<EmbroideryWorkItem>> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_ALL_WORK)
                .addParams("version",String.valueOf(version))
                .addParams("type","0")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "onError: ", e);
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG,"onResponse getAllWorkList "+ response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("msg");

                            if (code.equals("200")){
                                JSONArray data = jsonObject.getJSONArray("data");
                                callback.onSuccess(ResponseParser.parseAllWorkItemList(data));

                            }else{
                                callback.onFailure(msg);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void getOrigin(int version, final DataCallback<ArtFeature> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_ORIGIN)
                .addParams("version",String.valueOf(version))
                .addParams("id","0")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "get Origin onResponse: " + response);
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


    @Override
    public void getFutureDevelopment(int version, final DataCallback<ArtFeature> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_FUTURE_DEVELOPMENT)
                .addParams("version",String.valueOf(version))
                .addParams("id","2")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "get Future Development onResponse: " + response);
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

    @Override
    public void getCultureMeaning(int version, final DataCallback<ArtFeature> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_CULTURE_MEANING)
                .addParams("version",String.valueOf(version))
                .addParams("id","1")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "get culture meaning onResponse: " + response);
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

    @Override
    public void getDevelopmentProcess(int version, final DataCallback<List<DevelopmentItem>> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_DEVELOPMENT_PROCESS)
                .addParams("version",String.valueOf(version))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "get development process onResponse: " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            String msg = jsonObject.getString("msg");

                            if (code.equals("200")){

                                JSONArray data = jsonObject.getJSONArray("data");
                                callback.onSuccess(ResponseParser.parseDevelopmentItem(data));

                            }else{
                                callback.onFailure(msg);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void getDevelopmentItem(int version, int id, final DataCallback<ArtFeature> callback) {
        OkHttpUtils.post()
                .url(UrlConstants.URL_GET_DEVELOPMENT_ITEM)
                .addParams("version",String.valueOf(version))
                .addParams("id",id+"")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, "get development item onResponse: " + response);
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
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
