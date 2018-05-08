package com.simalee.guangxiu.data;


import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.data.entity.PergolaIntroduction;
import com.simalee.guangxiu.data.entity.SimpleIntroduction;
import com.simalee.guangxiu.data.entity.Version;
import com.simalee.guangxiu.data.model.DataCallback;

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
}
