package com.simalee.guangxiu.view.technique;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.DataManager;
import com.simalee.guangxiu.data.entity.EmbroideryIntroduction;
import com.simalee.guangxiu.data.entity.TextImageItem;
import com.simalee.guangxiu.data.model.DataCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/8.
 */

public class EmbroideryPresenter extends BasePresenter<TechniqueContract.EmbroideryView> implements TechniqueContract.IEmbroideryPresenter {
    private static final String TAG = "EmbroideryPresenter";

    public EmbroideryPresenter() {
    }

    private static final String ID_APPRECIATE = 111+"";
    private static final String ID_DAILY = 112+"";
    private static final String ID_SACRIFICE = 113+"";

    public static final String NAME_APPRECIATE = "欣赏品";
    public static final String NAME_DAILY = "日用品";
    public static final String NAME_SACRIFICE = "祭祀用品";
    @Override
    public void performDailyClick() {
        if (isViewAttached()){
            mView.openIntroduction(ID_DAILY,NAME_DAILY);
        }
    }

    @Override
    public void performAppreciateClick() {
        if (isViewAttached()) {
            mView.openIntroduction(ID_APPRECIATE,NAME_APPRECIATE);
        }
    }

    @Override
    public void performSacrificeClick() {
        if (isViewAttached()) {
            mView.openIntroduction(ID_SACRIFICE,NAME_SACRIFICE);
        }
    }

    @Override
    public void loadEmbroideryIntroduction(String id) {

        DataManager.getInstance().getEmbroideryWithId(id, new DataCallback<EmbroideryIntroduction>() {
            @Override
            public void onSuccess(EmbroideryIntroduction data) {
                if (isViewAttached()){
                    mView.showEmbroideryIntroduction(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                if (isViewAttached()){
                    mView.showError();
                }
            }

            @Override
            public void onError() {
                if (isViewAttached()){
                    mView.showError();
                }
            }
        });

    }

    public String getEmbroideryIdAt(int position){
        if (position < 0 || position >= 3){
            throw new IndexOutOfBoundsException("can't get id for: " + position);
        }
        if (position == 0){
            return ID_DAILY;
        }
        if (position == 1){
            return ID_APPRECIATE;

        }if (position == 2){
            return ID_SACRIFICE;
        }
        return "";
    }

    private EmbroideryIntroduction fakeIntroduction() {

        List<TextImageItem> itemList = new ArrayList<>();

        TextImageItem item1 = new TextImageItem();
        item1.setSequence(0);
        item1.setType(TextImageItem.TYPE_TEXT);
        item1.setText("\t\t日用品：日用品包含了日常生活的各个方面：头巾、披巾、靠垫、枕套、绣衣、绣鞋、香囊、金银绒褂裙等");
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
        item4.setText("这是第四个Text");
        itemList.add(item4);

        EmbroideryIntroduction introduction = new EmbroideryIntroduction();
        introduction.setItemList(itemList);
        return introduction;
    }
}
