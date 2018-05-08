package com.simalee.guangxiu.data;

import android.content.Context;
import android.net.ConnectivityManager;

import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.data.entity.PergolaIntroduction;
import com.simalee.guangxiu.data.entity.SimpleIntroduction;
import com.simalee.guangxiu.data.entity.Version;
import com.simalee.guangxiu.data.model.DataCallback;
import com.simalee.guangxiu.data.model.LocalDataSource;
import com.simalee.guangxiu.data.model.RemoteDataSource;
import com.simalee.guangxiu.utils.NetUtils;

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
    public void getIntroduction(DataCallback<SimpleIntroduction> callback) {
        if (!NetUtils.isNetworkConnected(mApplicationContext)){

            mLocalDataSource.getIntroduction(callback);

        }else{
            mRemoteDataSource.getIntroduction(callback);
        }
    }

    @Override
    public void getVersionCode(DataCallback<Version> callback) {
        //获取资料的版本号
        mRemoteDataSource.getVersionCode(callback);
    }

    @Override
    public void getArtFeature(DataCallback<ArtFeature> callback) {
        //后续需要判断版本号
        if (!NetUtils.isNetworkConnected(mApplicationContext)){
            mLocalDataSource.getArtFeature(callback);
        }else{

            mRemoteDataSource.getArtFeature(callback);
        }
    }

    @Override
    public void getPergolaIntroduction(DataCallback<PergolaIntroduction> callback) {
        //todo 本地保存
        if (!NetUtils.isNetworkConnected(mApplicationContext)){
            mLocalDataSource.getPergolaIntroduction(callback);
        }else{
            mRemoteDataSource.getPergolaIntroduction(callback);
        }
    }
}
