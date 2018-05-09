package com.simalee.guangxiu.data;

import android.content.Context;
import android.net.ConnectivityManager;

import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.data.entity.EmbroideryIntroduction;
import com.simalee.guangxiu.data.entity.PergolaIntroduction;
import com.simalee.guangxiu.data.entity.SimpleIntroduction;
import com.simalee.guangxiu.data.entity.StitchInfoDetail;
import com.simalee.guangxiu.data.entity.StitchIntroduction;
import com.simalee.guangxiu.data.entity.StitchItem;
import com.simalee.guangxiu.data.entity.ThreadIntroduction;
import com.simalee.guangxiu.data.entity.ThreadItem;
import com.simalee.guangxiu.data.entity.Version;
import com.simalee.guangxiu.data.model.DataCallback;
import com.simalee.guangxiu.data.model.LocalDataSource;
import com.simalee.guangxiu.data.model.RemoteDataSource;
import com.simalee.guangxiu.utils.NetUtils;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/1.
 *
 */

public class DataManager implements DataSource{

    private static final String TAG = "DataManager";

    private static Context mApplicationContext;
    private static volatile DataManager sInstance = null;

    private final LocalDataSource mLocalDataSource;
    private final RemoteDataSource mRemoteDataSource;



    private DataManager(){
        mLocalDataSource = new LocalDataSource();
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


    @Override
    public void getIntroduction(final DataCallback<SimpleIntroduction> callback) {
        if (!NetUtils.isNetworkConnected(mApplicationContext)){

            mLocalDataSource.getIntroduction(callback);

        }else{
            mRemoteDataSource.getIntroduction(new DataCallback<SimpleIntroduction>() {
                @Override
                public void onSuccess(SimpleIntroduction data) {
                    //todo 数据保存
                    callback.onSuccess(data);
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getIntroduction(callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }

    @Override
    public void getVersionCode(DataCallback<Version> callback) {
        //获取资料的版本号
        mRemoteDataSource.getVersionCode(callback);
    }

    @Override
    public void getArtFeature(final DataCallback<ArtFeature> callback) {
        //后续需要判断版本号
        if (!NetUtils.isNetworkConnected(mApplicationContext)){
            mLocalDataSource.getArtFeature(callback);
        }else{

            mRemoteDataSource.getArtFeature(new DataCallback<ArtFeature>() {
                @Override
                public void onSuccess(ArtFeature data) {
                    //todo 数据保存
                    callback.onSuccess(data);
                }

                @Override
                public void onFailure(String msg) {
                    //网络获取失败时 使用本地数据
                    mLocalDataSource.getArtFeature(callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }

    @Override
    public void getPergolaIntroduction(final DataCallback<PergolaIntroduction> callback) {

        if (!NetUtils.isNetworkConnected(mApplicationContext)){
            mLocalDataSource.getPergolaIntroduction(callback);
        }else{
            mRemoteDataSource.getPergolaIntroduction(new DataCallback<PergolaIntroduction>() {
                @Override
                public void onSuccess(PergolaIntroduction data) {
                    callback.onSuccess(data);
                    //todo 数据保存
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getPergolaIntroduction(callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }

    @Override
    public void getStitchIntroduction(final DataCallback<StitchIntroduction> callback) {
        if (!NetUtils.isNetworkConnected(mApplicationContext)){
            mLocalDataSource.getStitchIntroduction(callback);
        }else{
            mRemoteDataSource.getStitchIntroduction(new DataCallback<StitchIntroduction>() {
                @Override
                public void onSuccess(StitchIntroduction data) {
                    callback.onSuccess(data);
                    //todo 保存数据
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getStitchIntroduction(callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }

    @Override
    public void getThreadList(final DataCallback<List<ThreadItem>> callback) {
        if (!NetUtils.isNetworkConnected(mApplicationContext)){
            mLocalDataSource.getThreadList(callback);
        }else{
            mRemoteDataSource.getThreadList(new DataCallback<List<ThreadItem>>() {
                @Override
                public void onSuccess(List<ThreadItem> data) {
                    callback.onSuccess(data);
                    //todo 保存数据
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getThreadList(callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }

    @Override
    public void getThreadWithId(final String threadId, final DataCallback<ThreadIntroduction> callback) {
        if (!NetUtils.isNetworkConnected(mApplicationContext)){
            mLocalDataSource.getThreadWithId(threadId,callback);
        }else{
            mRemoteDataSource.getThreadWithId(threadId, new DataCallback<ThreadIntroduction>() {
                @Override
                public void onSuccess(ThreadIntroduction data) {
                    callback.onSuccess(data);
                    //todo 数据保存
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getThreadWithId(threadId,callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }

    @Override
    public void getEmbroideryWithId(final String embroideryId, final DataCallback<EmbroideryIntroduction> callback) {
        if (!NetUtils.isNetworkConnected(mApplicationContext)){
            mLocalDataSource.getEmbroideryWithId(embroideryId,callback);
        }else{
            mRemoteDataSource.getEmbroideryWithId(embroideryId, new DataCallback<EmbroideryIntroduction>() {
                @Override
                public void onSuccess(EmbroideryIntroduction data) {
                    callback.onSuccess(data);
                    //todo 数据保存
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getEmbroideryWithId(embroideryId,callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }

    @Override
    public void getStitchList(final DataCallback<List<StitchItem>> callback) {
        if (!NetUtils.isNetworkConnected(mApplicationContext)){
            mLocalDataSource.getStitchList(callback);
        }else{
            mRemoteDataSource.getStitchList(new DataCallback<List<StitchItem>>() {
                @Override
                public void onSuccess(List<StitchItem> data) {
                    callback.onSuccess(data);
                    //todo 数据保存
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getStitchList(callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }

    @Override
    public void getStitchInfoWithId(final String stitchId, final DataCallback<StitchInfoDetail> callback) {
        if (!NetUtils.isNetworkConnected(mApplicationContext)){
            mLocalDataSource.getStitchInfoWithId(stitchId,callback);
        }else{
            mRemoteDataSource.getStitchInfoWithId(stitchId, new DataCallback<StitchInfoDetail>() {
                @Override
                public void onSuccess(StitchInfoDetail data) {
                    callback.onSuccess(data);
                    //todo 数据保存
                }

                @Override
                public void onFailure(String msg) {
                    mLocalDataSource.getStitchInfoWithId(stitchId,callback);
                }

                @Override
                public void onError() {

                }
            });
        }
    }
}
