package com.simalee.guangxiu.data;


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

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/1.
 */

public interface DataSource{

    /**
     * 获取广绣的简要介绍
     * @param callback
     */
    void getIntroduction(DataCallback<SimpleIntroduction> callback);

    /**
     * 获取数据版本号
     * @param callback
     */
    void getVersionCode(DataCallback<Version> callback);

    /**
     * 获取广绣的艺术特点
     * @param callback
     */
    void getArtFeature(DataCallback<ArtFeature> callback);

    /**
     * 获取广绣的花架介绍
     * @param callback
     */
    void getPergolaIntroduction(DataCallback<PergolaIntroduction> callback);

    /**
     * 获取绣针介绍
     * @param callback
     */
    void getStitchIntroduction(DataCallback<StitchIntroduction> callback);

    /**
     * 获取绣线列表
     * @param callback
     */
    void getThreadList(DataCallback<List<ThreadItem>> callback);

    /**
     * 获取指定绣线的简介
     * @param threadId
     * @param callback
     */
    void getThreadWithId(String threadId, DataCallback<ThreadIntroduction> callback);

    /**
     * 获取指定绣种的描述
     * @param embroideryId
     * @param callback
     */
    void getEmbroideryWithId(String embroideryId, DataCallback<EmbroideryIntroduction> callback);

    /**
     * 获取针法列表
     * @param callback
     */
    void getStitchList(DataCallback<List<StitchItem>> callback);

    void getStitchInfoWithId(String stitchId, DataCallback<StitchInfoDetail> callback);
}
