package com.simalee.guangxiu.data.model;

import com.simalee.guangxiu.data.DataSource;
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

import java.util.List;

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

    @Override
    public void getArtFeature(DataCallback<ArtFeature> callback) {

    }

    @Override
    public void getPergolaIntroduction(DataCallback<PergolaIntroduction> callback) {

    }

    @Override
    public void getStitchIntroduction(DataCallback<StitchIntroduction> callback) {

    }

    @Override
    public void getThreadList(DataCallback<List<ThreadItem>> callback) {

    }

    @Override
    public void getThreadWithId(String threadId, DataCallback<ThreadIntroduction> callback) {

    }

    @Override
    public void getEmbroideryWithId(String embroideryId, DataCallback<EmbroideryIntroduction> callback) {

    }

    @Override
    public void getStitchList(DataCallback<List<StitchItem>> callback) {

    }

    @Override
    public void getStitchInfoWithId(String stitchId, DataCallback<StitchInfoDetail> callback) {

    }
}
