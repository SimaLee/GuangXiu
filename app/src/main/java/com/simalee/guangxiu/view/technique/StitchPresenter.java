package com.simalee.guangxiu.view.technique;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.DataManager;
import com.simalee.guangxiu.data.entity.StitchIntroduction;
import com.simalee.guangxiu.data.entity.TextImageItem;
import com.simalee.guangxiu.data.model.DataCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class StitchPresenter extends BasePresenter<TechniqueContract.StitchView> implements TechniqueContract.IStitchPresenter {
    private static final String TAG = "StitchPresenter";

    public StitchPresenter() {
    }

    @Override
    public void loadStitchIntroduction() {
        mView.showLoading();
        DataManager.getInstance().getStitchIntroduction(new DataCallback<StitchIntroduction>() {
            @Override
            public void onSuccess(StitchIntroduction data) {
                if (isViewAttached()){
                    mView.hideLoading();
                    mView.showStitchIntroduction(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                if (isViewAttached()){
                    mView.hideLoading();
                    mView.showErrorMsg(msg);
                }
            }

            @Override
            public void onError() {
                if (isViewAttached()){
                    mView.hideLoading();
                    mView.showErrorMsg("获取数据失败！");
                }
            }
        });

    }

    private StitchIntroduction testMultiItemContainer() {

        List<TextImageItem> itemList = new ArrayList<>();

        TextImageItem item1 = new TextImageItem();
        item1.setSequence(0);
        item1.setType(TextImageItem.TYPE_TEXT);
        item1.setText("\t\t这是第一个Text100-100" +
                "\t\t广绣针法丰富，平面针法外，还有浮雕式的立体针法以及其他特殊针法。主要分为绒绣针法和金银线绣（钉金绣）针法。绒绣共 60 多种针法，主要有直扭针、捆咬针、续插针、辅助针、编绣、饶绣、变体绣等 7 大类；金银线绣针法包括平绣、织锦绣、编绣、绕绣、凸绣、" +
                "贴花绣等 6 大类 30 余种针法。");
        itemList.add(item1);


        TextImageItem item3 = new TextImageItem();
        item3.setSequence(0);
        item3.setType(TextImageItem.TYPE_IMAGE);
        item3.setHeight(500);
        item3.setWidth(500);
        item3.setImageurl("http://c.hiphotos.baidu.com/image/pic/item/0824ab18972bd407cf293db177899e510eb30994.jpg");
        itemList.add(item3);

        StitchIntroduction introduction = new StitchIntroduction();
        introduction.setItemList(itemList);
        return introduction;
    }
}
