package com.simalee.guangxiu.data;

import android.content.Context;
import android.util.Log;


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
import com.simalee.guangxiu.data.model.DataCallback;
import com.simalee.guangxiu.data.model.LocalDataSource;
import com.simalee.guangxiu.data.model.RemoteDataSource;
import com.simalee.guangxiu.data.model.database.dao.VersionDao;
import com.simalee.guangxiu.data.model.database.dao.VersionPair;
import com.simalee.guangxiu.utils.NetUtils;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/1.
 *
 */

public class DataManager {

    private static final String TAG = "DataManager";

    private static Context mApplicationContext;
    private static volatile DataManager sInstance = null;

    private final LocalDataSource mLocalDataSource;
    private final RemoteDataSource mRemoteDataSource;



    private DataManager(){
        mLocalDataSource = new LocalDataSource(mApplicationContext);
        mRemoteDataSource = new RemoteDataSource();
    }

    public static void init(Context context){
        mApplicationContext = context.getApplicationContext();
    }

    public static DataManager getInstance(){
        if (sInstance == null){
            synchronized(DataManager.class){
                if (sInstance == null){
                    sInstance = new DataManager();
                }
            }
        }
        return sInstance;
    }


    /**
     * 获取广绣简要介绍
     * @param callback
     */
    public void getIntroduction(final DataCallback<SimpleIntroduction> callback) {

        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);
        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_DESC);
        Log.d(TAG, "getIntroduction: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected || !hasNewVersion ){

            mLocalDataSource.getIntroduction(versionPair.getOldVersion(),callback);

        }else{
            mRemoteDataSource.getIntroduction(versionPair.getOldVersion(),new DataCallback<SimpleIntroduction>() {
                @Override
                public void onSuccess(SimpleIntroduction data) {
                    //todo 数据保存
                    callback.onSuccess(data);
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getIntroduction(versionPair.getOldVersion(),callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }


    /**
     * 获取版本号信息
     * @param callback
     */
    public void getVersionCode(final DataCallback<Version> callback) {

        if (!NetUtils.isNetworkConnected(mApplicationContext)){
            return;
        }
        //获取资料的版本号
        mRemoteDataSource.getVersionCode(new DataCallback<Version>() {
            @Override
            public void onSuccess(Version data) {
                mLocalDataSource.saveVersion(data);
                callback.onSuccess(data);
            }

            @Override
            public void onFailure(String msg) {

            }

            @Override
            public void onError() {

            }
        });
    }


    /**
     * 获取广绣艺术特点
     * @param callback
     */
    public void getArtFeature(final DataCallback<ArtFeature> callback) {

        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);
        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_ART);
        Log.d(TAG, "getArtFeature: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected || !hasNewVersion ){
            mLocalDataSource.getArtFeature(versionPair.getOldVersion(),callback);
        }else{

            mRemoteDataSource.getArtFeature(versionPair.getOldVersion(),new DataCallback<ArtFeature>() {
                @Override
                public void onSuccess(ArtFeature data) {
                    //todo 数据保存
                    callback.onSuccess(data);
                }

                @Override
                public void onFailure(String msg) {
                    //网络获取失败时 使用本地数据
                    mLocalDataSource.getArtFeature(versionPair.getOldVersion(),callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }


    /**
     * 获取花架信息
     * @param callback
     */
    public void getPergolaIntroduction(final DataCallback<PergolaIntroduction> callback) {

        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);
        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_PERGOLA);
        Log.d(TAG, "getPergolaIntroduction: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected ||!hasNewVersion){
            mLocalDataSource.getPergolaIntroduction(versionPair.getOldVersion(),callback);
        }else{
            mRemoteDataSource.getPergolaIntroduction(versionPair.getOldVersion(),new DataCallback<PergolaIntroduction>() {
                @Override
                public void onSuccess(PergolaIntroduction data) {
                    callback.onSuccess(data);
                    //todo 数据保存 版本更新
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getPergolaIntroduction(versionPair.getOldVersion(),callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }


    /**
     * 获取绣针介绍
     * @param callback
     */
    public void getStitchIntroduction(final DataCallback<StitchIntroduction> callback) {

        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);
        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_NEEDLE);
        Log.d(TAG, "getStitchIntroduction: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected ||!hasNewVersion){
            mLocalDataSource.getStitchIntroduction(versionPair.getOldVersion(),callback);
        }else{
            mRemoteDataSource.getStitchIntroduction(versionPair.getOldVersion(),new DataCallback<StitchIntroduction>() {
                @Override
                public void onSuccess(StitchIntroduction data) {
                    callback.onSuccess(data);
                    //todo 保存数据
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getStitchIntroduction(versionPair.getOldVersion(),callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }


    /**
     * 获取绣线列表
     * @param callback
     */
    public void getThreadList(final DataCallback<List<ThreadItem>> callback) {

        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);

        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_THREAD);
        Log.d(TAG, "getThreadList: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected ||!hasNewVersion){
            mLocalDataSource.getThreadList(versionPair.getOldVersion(),callback);
        }else{
            mRemoteDataSource.getThreadList(versionPair.getOldVersion(),new DataCallback<List<ThreadItem>>() {
                @Override
                public void onSuccess(List<ThreadItem> data) {
                    callback.onSuccess(data);
                    //todo 保存数据 这里的版本更新需要考虑二级数据的处理
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getThreadList(versionPair.getOldVersion(),callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }

    /**
     * 获取指定绣线内容
     * @param threadId
     * @param callback
     */
    public void getThreadWithId(final String threadId, final DataCallback<ThreadIntroduction> callback) {

        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);

        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_THREAD);
        Log.d(TAG, "getThreadWithId: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected ||!hasNewVersion){
            mLocalDataSource.getThreadWithId(versionPair.getOldVersion(),threadId,callback);
        }else{
            mRemoteDataSource.getThreadWithId(versionPair.getOldVersion(),threadId, new DataCallback<ThreadIntroduction>() {
                @Override
                public void onSuccess(ThreadIntroduction data) {
                    callback.onSuccess(data);
                    //todo 数据保存
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getThreadWithId(versionPair.getOldVersion(),threadId,callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }


    /**
     * 获取指定绣线介绍
     * @param embroideryId
     * @param callback
     */
    public void getEmbroideryWithId(final String embroideryId, final DataCallback<EmbroideryIntroduction> callback) {

        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);

        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_EMBROIDERY_);
        Log.d(TAG, "getEmbroideryWithId: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected ||!hasNewVersion){
            mLocalDataSource.getEmbroideryWithId(versionPair.getOldVersion(),embroideryId,callback);
        }else{
            mRemoteDataSource.getEmbroideryWithId(versionPair.getOldVersion(),embroideryId, new DataCallback<EmbroideryIntroduction>() {
                @Override
                public void onSuccess(EmbroideryIntroduction data) {
                    callback.onSuccess(data);
                    //todo 数据保存
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getEmbroideryWithId(versionPair.getOldVersion(),embroideryId,callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }


    /**
     * 获取针法列表
     * @param callback
     */
    public void getStitchList(final DataCallback<List<StitchItem>> callback) {

        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);

        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_STITCH);
        Log.d(TAG, "getStitchList: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected ||!hasNewVersion){
            mLocalDataSource.getStitchList(versionPair.getOldVersion(),callback);
        }else{
            mRemoteDataSource.getStitchList(versionPair.getOldVersion(),new DataCallback<List<StitchItem>>() {
                @Override
                public void onSuccess(List<StitchItem> data) {
                    callback.onSuccess(data);
                    //todo 数据保存
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getStitchList(versionPair.getOldVersion(),callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }


    /**
     * 获取针法介绍
     * @param stitchId
     * @param callback
     */
    public void getStitchInfoWithId(final String stitchId, final DataCallback<StitchInfoDetail> callback) {

        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);

        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_STITCH);
        Log.d(TAG, "getStitchInfoWithId: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected ||!hasNewVersion){

            mLocalDataSource.getStitchInfoWithId(versionPair.getOldVersion(),stitchId,callback);
        }else{
            mRemoteDataSource.getStitchInfoWithId(versionPair.getOldVersion(),stitchId, new DataCallback<StitchInfoDetail>() {
                @Override
                public void onSuccess(StitchInfoDetail data) {
                    callback.onSuccess(data);
                    //todo 数据保存
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getStitchInfoWithId(versionPair.getOldVersion(),stitchId,callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }


    /**
     * 获取名家列表
     * @param callback
     */
    public void getArtistList(final DataCallback<List<Artist>> callback) {

        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);

        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_MASTER);
        Log.d(TAG, "getArtistList: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected ||!hasNewVersion){
            mLocalDataSource.getArtistList(versionPair.getOldVersion(),callback);
        }else{
           mRemoteDataSource.getArtistList(versionPair.getOldVersion(),new DataCallback<List<Artist>>() {
               @Override
               public void onSuccess(List<Artist> data) {
                   callback.onSuccess(data);
                   //todo 数据保存
               }

               @Override
               public void onFailure(String msg) {
                    mLocalDataSource.getArtistList(versionPair.getOldVersion(),callback);
               }

               @Override
               public void onError() {

               }
           });
        }
    }


    /**
     * 获取名家介绍
     * @param artistId
     * @param callback
     */
    public void getArtistInfoWithId(final String artistId, final DataCallback<Artist> callback) {

        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);

        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_MASTER);
        Log.d(TAG, "getArtistInfoWithId: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected ||!hasNewVersion){

            mLocalDataSource.getArtistInfoWithId(versionPair.getOldVersion(),artistId,callback);

        }else{
            mRemoteDataSource.getArtistInfoWithId(versionPair.getOldVersion(),artistId, new DataCallback<Artist>() {
                @Override
                public void onSuccess(Artist data) {
                    callback.onSuccess(data);
                    //todo 数据保存
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getArtistInfoWithId(versionPair.getOldVersion(),artistId,callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }


    /**
     * 获取答题模块数据
     * @param callback
     */
    public void getQuizList(final DataCallback<List<QuizItem>> callback) {

        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);

        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_ANSWER);
        Log.d(TAG, "getQuizList: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected ||!hasNewVersion){

            mLocalDataSource.getQuizList(versionPair.getOldVersion(),callback);

        }else{

            mRemoteDataSource.getQuizList(versionPair.getOldVersion(),new DataCallback<List<QuizItem>>() {
                @Override
                public void onSuccess(List<QuizItem> data) {
                    callback.onSuccess(data);
                    //todo 数据保存
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getQuizList(versionPair.getOldVersion(),callback);
                }

                @Override
                public void onError() {

                }
            });

        }
    }


    /**
     * 获取教学视频数据
     * @param callback
     */
    public void getTeachingVideoList(final DataCallback<List<TeachingContentItem>> callback) {

        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);

        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_VIDEO);
        Log.d(TAG, "getTeachingVideoList: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected ||!hasNewVersion){

            mLocalDataSource.getTeachingVideoList(versionPair.getOldVersion(),callback);

        }else{

            mRemoteDataSource.getTeachingVideoList(versionPair.getOldVersion(),new DataCallback<List<TeachingContentItem>>() {
                @Override
                public void onSuccess(List<TeachingContentItem> data) {
                    callback.onSuccess(data);
                    //todo 数据保存
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getTeachingVideoList(versionPair.getOldVersion(),callback);
                }

                @Override
                public void onError() {

                }
            });

        }
    }

    /**
     * 获取作品列表
     * @param callback
     */
    public void getAllWorkList(final DataCallback<List<EmbroideryWorkItem>> callback) {

        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);

        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_MASTER_WORK);
        Log.d(TAG, "getAllWorkList: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected ||!hasNewVersion){

            mLocalDataSource.getAllWorkList(versionPair.getOldVersion(),callback);

        }else{

            mRemoteDataSource.getAllWorkList(versionPair.getOldVersion(),new DataCallback<List<EmbroideryWorkItem>>() {
                @Override
                public void onSuccess(List<EmbroideryWorkItem> data) {
                    callback.onSuccess(data);
                    //todo 数据保存
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getAllWorkList(versionPair.getOldVersion(),callback);
                }

                @Override
                public void onError() {

                }
            });

        }
    }

    public void getOrigin(final DataCallback<ArtFeature> callback){
        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);
        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_ORIGIN);
        Log.d(TAG, "getOrigin: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected || !hasNewVersion ){
            mLocalDataSource.getOrigin(versionPair.getOldVersion(),callback);
        }else{

            mRemoteDataSource.getOrigin(versionPair.getOldVersion(),new DataCallback<ArtFeature>() {
                @Override
                public void onSuccess(ArtFeature data) {
                    //todo 数据保存
                    callback.onSuccess(data);
                }

                @Override
                public void onFailure(String msg) {
                    //网络获取失败时 使用本地数据
                    mLocalDataSource.getOrigin(versionPair.getOldVersion(),callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }

    public void getFutureDevelopment(final DataCallback<ArtFeature> callback){
        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);
        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_DEVELOPMENT);
        Log.d(TAG, "getFutureDevelopment: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected || !hasNewVersion ){
            mLocalDataSource.getFutureDevelopment(versionPair.getOldVersion(),callback);
        }else{

            mRemoteDataSource.getFutureDevelopment(versionPair.getOldVersion(),new DataCallback<ArtFeature>() {
                @Override
                public void onSuccess(ArtFeature data) {
                    //todo 数据保存
                    callback.onSuccess(data);
                }

                @Override
                public void onFailure(String msg) {
                    //网络获取失败时 使用本地数据
                    mLocalDataSource.getFutureDevelopment(versionPair.getOldVersion(),callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }

    public void getCultureMeaning(final DataCallback<ArtFeature> callback){
        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);
        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_MEANING);
        Log.d(TAG, "getCultureMeaning: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected || !hasNewVersion ){
            mLocalDataSource.getCultureMeaning(versionPair.getOldVersion(),callback);
        }else{

            mRemoteDataSource.getCultureMeaning(versionPair.getOldVersion(),new DataCallback<ArtFeature>() {
                @Override
                public void onSuccess(ArtFeature data) {
                    //todo 数据保存
                    callback.onSuccess(data);
                }

                @Override
                public void onFailure(String msg) {
                    //网络获取失败时 使用本地数据
                    mLocalDataSource.getCultureMeaning(versionPair.getOldVersion(),callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }

    public void getDevelopmentProcess(final DataCallback<List<DevelopmentItem>> callback){
        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);
        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_PHASE);
        Log.d(TAG, "getDevelopmentProcess: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected || !hasNewVersion ){
            mLocalDataSource.getDevelopmentProcess(versionPair.getOldVersion(),callback);
        }else{

            mRemoteDataSource.getDevelopmentProcess(versionPair.getOldVersion(),new DataCallback<List<DevelopmentItem>>() {
                @Override
                public void onSuccess(List<DevelopmentItem> data) {
                    //todo 数据保存
                    callback.onSuccess(data);
                }

                @Override
                public void onFailure(String msg) {
                    //网络获取失败时 使用本地数据
                    mLocalDataSource.getDevelopmentProcess(versionPair.getOldVersion(),callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }

    public void getDevelopmentItem(final int id, final DataCallback<ArtFeature> callback){
        boolean isNetworkConnected = NetUtils.isNetworkConnected(mApplicationContext);
        final VersionPair versionPair = mLocalDataSource.getVersionInfo(VersionDao.INDEX_VER_PHASE);
        Log.d(TAG, "getDevelopmentProcess: versionPair " + versionPair);
        boolean hasNewVersion = versionPair.hasNewVersion();

        if (!isNetworkConnected || !hasNewVersion ){
            mLocalDataSource.getDevelopmentItem(versionPair.getOldVersion(),id,callback);
        }else{

            mRemoteDataSource.getDevelopmentItem(versionPair.getOldVersion(),id,new DataCallback<ArtFeature>() {
                @Override
                public void onSuccess(ArtFeature data) {
                    //todo 数据保存
                    callback.onSuccess(data);
                }

                @Override
                public void onFailure(String msg) {
                    //网络获取失败时 使用本地数据
                    mLocalDataSource.getDevelopmentItem(versionPair.getOldVersion(),id,callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }
}
