package com.simalee.guangxiu.data;

import com.simalee.guangxiu.data.entity.SimpleIntroduction;
import com.simalee.guangxiu.data.entity.Version;
import com.simalee.guangxiu.data.model.DataCallback;
import com.simalee.guangxiu.data.model.LocalDataSource;
import com.simalee.guangxiu.data.model.RemoteDataSource;

/**
 * Created by Lee Sima on 2018/5/1.
 *
 */

public class DataManager implements DataSource{

    private static final String TAG = "DataManager";

    private static volatile DataManager sInstance = null;

    private final LocalDataSource mLocalDataSource;
    private final RemoteDataSource mRemoteDataSource;



    private DataManager(){
        mLocalDataSource = new LocalDataSource();
        mRemoteDataSource = new RemoteDataSource();
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

    }

    @Override
    public void getVersionCode(DataCallback<Version> callback) {
        //获取资料的版本号
    }
}
