package com.simalee.guangxiu.view.technique;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.entity.StitchInfoDetail;
import com.simalee.guangxiu.data.entity.StitchItem;
import com.simalee.guangxiu.data.entity.TextImageItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class StitchInfoPresenter extends BasePresenter<TechniqueContract.StitchInfoView> implements TechniqueContract.IStitchInfoPresenter {

    private static final String TAG = "StitchInfoPresenter";

    public StitchInfoPresenter() {

    }

    @Override
    public void loadStitchList() {
        if (isViewAttached()){
            mView.showStitchList(fakeStitchList());
        }
    }

    @Override
    public void loadStitchInfo(String stitchId) {
        if (isViewAttached()){
            mView.showStitchInfo(fakeStitchInfoDetail());
        }
    }

    private List<StitchItem> fakeStitchList() {
        List<StitchItem> list = new ArrayList<>();
        StitchItem item;
        for (int i = 0; i< 20; i++){
            item = new StitchItem();
            item.setId(i+"");
            item.setName("针法"+i);
            item.setImage("no image");
            list.add(item);
        }
        return list;
    }

    private StitchInfoDetail fakeStitchInfoDetail() {

        List<TextImageItem> itemList = new ArrayList<>();

        TextImageItem item1 = new TextImageItem();
        item1.setSequence(0);
        item1.setType(TextImageItem.TYPE_TEXT);
        item1.setText("\t\t这是第一个Text100-100" +
                "\t\t直针绣：直针绣是一种用垂直线条组成的针法\n" +
                "绣法：用垂直线条，在纹样的这边，绣到那边。线路朝一个方向平列，施色单纯，同时须注意边口匀整。这一针法与铺针的不同之处是直针比较短密，而且能够独立绣东西；铺针则针路较长，多作底层之用。");
        itemList.add(item1);

        TextImageItem item3 = new TextImageItem();
        item3.setSequence(0);
        item3.setType(TextImageItem.TYPE_IMAGE);
        item3.setHeight(500);
        item3.setWidth(500);
        item3.setImageurl("http://c.hiphotos.baidu.com/image/pic/item/0824ab18972bd407cf293db177899e510eb30994.jpg");
        itemList.add(item3);

        TextImageItem item4 = new TextImageItem();
        item4.setSequence(3);
        item4.setType(TextImageItem.TYPE_TEXT);
        item4.setText("\t\t这是第四个Text");
        itemList.add(item4);

        StitchInfoDetail stitchInfoDetail = new StitchInfoDetail();
        stitchInfoDetail.setItemList(itemList);
        return stitchInfoDetail;
    }
}
