package com.simalee.guangxiu.data.model;

import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;

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
import com.simalee.guangxiu.data.model.database.dao.ArtFeatureDao;
import com.simalee.guangxiu.data.model.database.dao.SimpleIntroductionDao;
import com.simalee.guangxiu.data.model.database.dao.VersionDao;
import com.simalee.guangxiu.data.model.database.dao.VersionPair;
import com.simalee.guangxiu.utils.PreferenceUtil;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/1.
 */

public class LocalDataSource implements DataSource {
    private static final String TAG = "LocalDataSource";

    private Context mContext;


    private VersionDao mVersionDao;
    private SimpleIntroductionDao mSimpleIntroductionDao;
    private ArtFeatureDao mArtFeatureDao;

    public LocalDataSource(Context context){
        mContext = context;
        mVersionDao = new VersionDao(context);
        mSimpleIntroductionDao = new SimpleIntroductionDao(context);
        mArtFeatureDao = new ArtFeatureDao(context);

    }


    @Override
    public void getVersionCode(DataCallback<Version> callback) {
        //本地不需使用
    }

    @Override
    public void getIntroduction(int version, DataCallback<SimpleIntroduction> callback) {

        if (callback == null){
            return;
        }

        Log.d(TAG, "getIntroduction: version " +version);
        SimpleIntroduction result = mSimpleIntroductionDao.getSimpleIntroduction(version);

        if (result != null){
            callback.onSuccess(result);
        }else{
            callback.onFailure("加载广绣简要介绍失败！");
        }
    }

    /**
     * 保存广绣简要介绍 更新数据版本号
     * @param version
     * @param introduction
     */
    public void saveIntroduction(int version,SimpleIntroduction introduction){
        Log.d(TAG, "saveIntroduction: " + introduction);
        boolean success = mSimpleIntroductionDao.saveSimpleIntroduction(version,introduction);

        if (success){
            int ret = updateVersion(VersionDao.INDEX_VER_DESC);
            if (ret != -1){
                Log.i(TAG, "saveIntroduction: update version code successfully");
            }
        }else{
            Log.e(TAG, "saveIntroduction: fail to update version code");
        }
    }

    @Override
    public void getArtFeature(int version, DataCallback<ArtFeature> callback) {
        if (callback == null){
            return;
        }

        ArtFeature result = mArtFeatureDao.getArtFeature(version);

        if (result != null){
            callback.onSuccess(result);
        }else{
            callback.onFailure("加载广绣艺术特点失败!");
        }
    }

    /**
     * 保存广绣艺术特点 更新数据版本号
     * @param version
     * @param artFeature
     * @return
     */
    public void saveArtFeature(int version,ArtFeature artFeature){

        if (artFeature.getItemList().size() == 0){
            return;
        }

        Log.d(TAG, "saveArtFeature: " + artFeature);
        boolean success = mArtFeatureDao.saveArtFeature(version,artFeature);

        if (success){

            int ret = updateVersion(VersionDao.INDEX_VER_ART);
            if (ret != -1){
                Log.i(TAG, "saveArtFeature: update version code successfully");
            }else{
                Log.e(TAG, "saveArtFeature: fail to update version code");
            }
        }else{
            Log.e(TAG, "saveArtFeature: fail to save ArtFeature");
        }
    }

    @Override
    public void getPergolaIntroduction(int version, DataCallback<PergolaIntroduction> callback) {

    }

    @Override
    public void getStitchIntroduction(int version, DataCallback<StitchIntroduction> callback) {

    }

    @Override
    public void getThreadList(int version, DataCallback<List<ThreadItem>> callback) {

    }

    @Override
    public void getThreadWithId(int version, String threadId, DataCallback<ThreadIntroduction> callback) {

    }

    @Override
    public void getEmbroideryWithId(int version, String embroideryId, DataCallback<EmbroideryIntroduction> callback) {

    }

    @Override
    public void getStitchList(int version, DataCallback<List<StitchItem>> callback) {

    }

    @Override
    public void getStitchInfoWithId(int version, String stitchId, DataCallback<StitchInfoDetail> callback) {

    }

    @Override
    public void getArtistList(int version, DataCallback<List<Artist>> callback) {

    }

    @Override
    public void getArtistInfoWithId(int version, String artistId, DataCallback<Artist> callback) {

    }

    @Override
    public void getQuizList(int version, DataCallback<List<QuizItem>> callback) {

    }

    /**
     * 保存版本号信息
     * 当且仅当第一次安装成功之后 第一次请求版本信息时调用{@link VersionDao#initVersion(Version)}
     * 其他情况下调用{@link VersionDao#saveNewVersion(Version)}
     * @param version
     */
    public void saveVersion(Version version){
        if (isFirstRequest()){
            mVersionDao.initVersion(version);
            Log.d(TAG, "saveVersion: isFirst");
            markNotFirstRequest();
        }else{
            mVersionDao.saveNewVersion(version);
            Log.d(TAG, "saveVersion: isNotFirst");
        }
    }

    /**
     * 更新preference中第一次请求的记录
     */
    private void markNotFirstRequest() {
        PreferenceUtil.setFirstVersionRequest(mContext,false);
    }

    /**
     * 根据preference 中的信息判断是否第一次请求版本信息
     * @return
     */
    public boolean isFirstRequest() {
        return PreferenceUtil.getFirstVersionRequest(mContext);
    }

    /**
     * 获取对应的版本信息 {@link VersionDao} index限定
     * @param index
     * @return
     */
    public VersionPair getVersionInfo(int index){
        return mVersionDao.getVersionPairAt(index);
    }

    /**
     * @param index
     * @return
     */
    public int updateVersion(int index){
        return mVersionDao.updateVersion(index);
    }

    @Override
    public void getTeachingVideoList(int version, DataCallback<List<TeachingContentItem>> callback) {

    }

    @Override
    public void getAllWorkList(int version, DataCallback<List<EmbroideryWorkItem>> callback) {

    }

    @Override
    public void getOrigin(int version, DataCallback<ArtFeature> callback) {

    }

    @Override
    public void getFutureDevelopment(int version, DataCallback<ArtFeature> callback) {

    }

    @Override
    public void getCultureMeaning(int version, DataCallback<ArtFeature> callback) {

    }

    @Override
    public void getDevelopmentProcess(int version, DataCallback<List<DevelopmentItem>> callback) {

    }

    @Override
    public void getDevelopmentItem(int version, int id, DataCallback<ArtFeature> callback) {

    }
}
