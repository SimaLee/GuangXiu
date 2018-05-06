package com.simalee.guangxiu.data.model;

import com.simalee.guangxiu.data.DataSource;
import com.simalee.guangxiu.data.entity.SimpleIntroduction;
import com.simalee.guangxiu.data.entity.Version;

/**
 * Created by Lee Sima on 2018/5/1.
 */

public class LocalDataSource implements DataSource {
    private static final String TAG = "LocalDataSource";


    public LocalDataSource(){

    }

    @Override
    public void getIntroduction(DataCallback<SimpleIntroduction> callback) {

    }

    @Override
    public void getVersionCode(DataCallback<Version> callback) {
        //
    }

}
