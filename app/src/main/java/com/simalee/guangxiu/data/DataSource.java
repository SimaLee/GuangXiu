package com.simalee.guangxiu.data;


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

    void getVersionCode(DataCallback<Version> callback);
}
