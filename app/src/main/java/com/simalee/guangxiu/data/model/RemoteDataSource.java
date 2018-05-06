package com.simalee.guangxiu.data.model;

import com.simalee.guangxiu.data.DataSource;
import com.simalee.guangxiu.data.entity.SimpleIntroduction;
import com.simalee.guangxiu.data.entity.Version;

/**
 * Created by Lee Sima on 2018/5/1.
 */

public class RemoteDataSource implements DataSource {

    private static final String TAG = "RemoteDataSource";

    public RemoteDataSource(){

    }

    @Override
    public void getIntroduction(DataCallback<SimpleIntroduction> callback) {

    }

    @Override
    public void getVersionCode(DataCallback<Version> callback) {
        //联网完成数据获取
    }
}
