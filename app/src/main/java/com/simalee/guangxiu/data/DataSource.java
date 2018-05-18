package com.simalee.guangxiu.data;


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
import com.simalee.guangxiu.data.model.DataCallback;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/1.
 */

public interface DataSource{


    /**
     * 获取数据版本号
     * @param callback
     */
    void getVersionCode(DataCallback<Version> callback);

    /**
     * 获取广绣的简要介绍
     * @param version
     * @param callback
     */
    void getIntroduction(int version,DataCallback<SimpleIntroduction> callback);

    /**
     * 获取广绣的艺术特点
     * @param version
     * @param callback
     */
    void getArtFeature(int version,DataCallback<ArtFeature> callback);

    /**
     * 获取广绣的花架介绍
     * @param version
     * @param callback
     */
    void getPergolaIntroduction(int version,DataCallback<PergolaIntroduction> callback);

    /**
     * 获取绣针介绍
     * @param version
     * @param callback
     */
    void getStitchIntroduction(int version,DataCallback<StitchIntroduction> callback);

    /**
     * 获取绣线列表
     * @param callback
     */
    void getThreadList(int version,DataCallback<List<ThreadItem>> callback);

    /**
     * 获取指定绣线的简介
     * @param version
     * @param threadId
     * @param callback
     */
    void getThreadWithId(int version,String threadId, DataCallback<ThreadIntroduction> callback);

    /**
     * 获取指定绣种的描述
     * @param version
     * @param embroideryId 绣种id
     * @param callback
     */
    void getEmbroideryWithId(int version,String embroideryId, DataCallback<EmbroideryIntroduction> callback);

    /**
     * 获取针法列表
     * @param callback
     */
    void getStitchList(int version,DataCallback<List<StitchItem>> callback);

    /**
     * 获取针法的介绍
     * @param version
     * @param stitchId
     * @param callback
     */
    void getStitchInfoWithId(int version,String stitchId, DataCallback<StitchInfoDetail> callback);

    /**
     * 获取名家列表
     * @param version
     * @param callback
     */
    void getArtistList(int version,DataCallback<List<Artist>> callback);

    /**
     * 获取指定名家介绍
     * @param version
     * @param artistId
     * @param callback
     */
    void getArtistInfoWithId(int version,String artistId,DataCallback<Artist> callback);

    /**
     * 获取答卷数据
     * @param version
     * @param callback
     */
    void getQuizList(int version,DataCallback<List<QuizItem>> callback);

    /**
     * 获取教学视频数据
     *
     */
    void getTeachingVideoList(int version,DataCallback<List<TeachingContentItem>> callback);

    /**
     * 获取所有作品列表
     * @param version
     * @param callback
     */
    void getAllWorkList(int version, DataCallback<List<EmbroideryWorkItem>> callback);

    /**
     * 获取历史起源
     * @param version
     * @param callback
     */
    void getOrigin(int version,DataCallback<ArtFeature> callback);

    /**
     * 获取未来发展
     * @param version
     * @param callback
     */
    void getFutureDevelopment(int version,DataCallback<ArtFeature> callback);

    /**
     * 获取文化寓意
     * @param version
     * @param callback
     */
    void getCultureMeaning(int version,DataCallback<ArtFeature> callback);

    /**
     * 获取发展过程
     * @param version
     * @param callback
     */
    void getDevelopmentProcess(int version, DataCallback<List<DevelopmentItem>> callback);

    void getDevelopmentItem(int version, int id, DataCallback<ArtFeature> callback);
}
