package com.simalee.guangxiu.view.technique;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.DataManager;
import com.simalee.guangxiu.data.entity.TextImageItem;
import com.simalee.guangxiu.data.entity.ThreadIntroduction;
import com.simalee.guangxiu.data.entity.ThreadItem;
import com.simalee.guangxiu.data.model.DataCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class ThreadPresenter extends BasePresenter<TechniqueContract.ThreadView> implements TechniqueContract.IThreadPresenter {
    private static final String TAG = "ThreadPresenter";

    public ThreadPresenter() {
    }

    @Override
    public void loadThreadList() {
        DataManager.getInstance().getThreadList(new DataCallback<List<ThreadItem>>() {
            @Override
            public void onSuccess(List<ThreadItem> data) {
                if (isViewAttached()){
                    mView.showThreadList(data);
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

    @Override
    public void loadThreadIntroduction(String threadId) {
        DataManager.getInstance().getThreadWithId(threadId,new DataCallback<ThreadIntroduction>() {
            @Override
            public void onSuccess(ThreadIntroduction data) {
                if (isViewAttached()){
                    mView.showThreadIntroduction(data);
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


    private List<ThreadItem> fakeThreadList() {
        List<ThreadItem> list = new ArrayList<>();
        ThreadItem item;
        for (int i = 0; i< 30; i++){
            item = new ThreadItem();
            item.setId(i+"");
            item.setName(i+"股线");
            item.setImage("no image");
            list.add(item);
        }
        return list;
    }

    private ThreadIntroduction fakeThreadIntroduction() {

        List<TextImageItem> itemList = new ArrayList<>();

        TextImageItem item1 = new TextImageItem();
        item1.setSequence(0);
        item1.setType(TextImageItem.TYPE_TEXT);
        item1.setText("\t\t这是第一个Text100-100" +
                "\t\t绣线:纱线、花线、绒线、金银线、尼龙线、头发、马棕、孔雀毛、\n" +
                "彩珠,皆是用优质天然纤维或化学轻纺纱加工而成的刺绣用线。其中绒线、\n" +
                "真丝、金线、银线、金荣混合等几大类为广绣所使用的基本材料。金银绣\n" +
                "线和金绒混合绣等传统工艺最负盛名。");
        itemList.add(item1);

        TextImageItem item2 = new TextImageItem();
        item2.setSequence(1);
        item2.setType(TextImageItem.TYPE_TEXT);
        item2.setText("\t\t底料:材料旨在最出色地体现出绣品之美,正如柳宗悦在《工艺文化》\n" +
                "一书所言:“器物之美的一半是材料之美。”广绣以底料来归纳品类,主要\n" +
                "是真丝绒绣、金银线绣、丝绣和珠绣四类。明代以来,广绣在材料的选择\n" +
                "上不断尝试,广泛吸纳。18世纪中叶,广东曾流行“皮金绣”,即纳丝绣的\n" +
                "一种,底料多用羊皮金作衬,绣制出金光闪烁、奇美无比的绣品。而清代,\n" +
                "名噪一时的广绣戏服,用料选择颇为广泛,丝绸、麻布、棉花等数十个品\n" +
                "种均能作底料使用");
        itemList.add(item2);

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

        ThreadIntroduction feature = new ThreadIntroduction();
        feature.setItemList(itemList);
        return feature;
    }
}
