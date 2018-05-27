package com.simalee.guangxiu.view.cartoon;

import android.util.Log;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.DataManager;
import com.simalee.guangxiu.data.entity.EmbroideryWorkItem;
import com.simalee.guangxiu.data.model.DataCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zb.yang on 2018/5/14.
 */

public class GalleryPresenter extends BasePresenter<GalleryContarct.GalleryView> implements GalleryContarct.GalleryPresenter {

    @Override
    public void loadGalleryView() {
        mView.showLoading();
        DataManager.getInstance().getAllWorkList(new DataCallback<List<EmbroideryWorkItem>>() {
            @Override
            public void onSuccess(List<EmbroideryWorkItem> data) {
                if(isViewAttached()){
                    mView.hideLoading();
                    mView.showGalleryView(data);
                    Log.i("loadGallery",data.toString());
                }
            }

            @Override
            public void onFailure(String msg) {
                if(isViewAttached()){
                    mView.hideLoading();
                    mView.showErrorMsg(msg);
                }
            }

            @Override
            public void onError() {
                if(isViewAttached()){
                    mView.hideLoading();
                    mView.showErrorMsg("获取数据失败！");
                }
            }
        });
    }

    public ArrayList<EmbroideryWorkItem> getTestData(){
        ArrayList<EmbroideryWorkItem> arrayList = new ArrayList<>();
        EmbroideryWorkItem embroideryWorkItem = new EmbroideryWorkItem("http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-17_17-30-43.jpg",
                "藏獒与虎","苏绣已有2000多年的历史，发源于苏州，在北宋时已形成了独特的风格。明代始，苏州绣工们又着重吸取了上海露香园顾绣的精湛技艺，加以融会贯通。到清代初年，已成为一个影响广泛的著名丝绣流派，直到今天仍然长盛不衰。苏绣工艺是以绣针引彩线，在丝绸、棉布等面料上刺缀运针，通过绣迹构成花样、图案、文字以取得艺术效果。\n" +
                "苏绣既是高雅的实用品，又是精美的手工艺品，素以绣工精细，针法活泼，图案秀丽弛名中外，它具有绣面平整妥帖、色调柔和典雅、丝线疏密均整、丝理圆润的特点，能以近百种不同的针法秀出各种题材，多次被国家领导人作为国家级礼品送给外宾。","沈寿",11);
        EmbroideryWorkItem embroideryWorkItem2 = new EmbroideryWorkItem("http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-17_17-30-43.jpg",
                "菡萏潇湘-中午","苏绣已有2000多年的历史，发源于苏州，在北宋时已形成了独特的风格。明代始，苏州绣工们又着重吸取了上海露香园顾绣的精湛技艺，加以融会贯通。到清代初年，已成为一个影响广泛的著名丝绣流派，直到今天仍然长盛不衰。苏绣工艺是以绣针引彩线，在丝绸、棉布等面料上刺缀运针，通过绣迹构成花样、图案、文字以取得艺术效果。\n" +
                "苏绣既是高雅的实用品，又是精美的手工艺品，素以绣工精细，针法活泼，图案秀丽弛名中外，它具有绣面平整妥帖、色调柔和典雅、丝线疏密均整、丝理圆润的特点，能以近百种不同的针法秀出各种题材，多次被国家领导人作为国家级礼品送给外宾。","卫芳",12);
        EmbroideryWorkItem embroideryWorkItem3 = new EmbroideryWorkItem("http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-17_17-30-43.jpg",
                "菡萏潇湘-清晨","苏绣已有2000多年的历史，发源于苏州，在北宋时已形成了独特的风格。明代始，苏州绣工们又着重吸取了上海露香园顾绣的精湛技艺，加以融会贯通。到清代初年，已成为一个影响广泛的著名丝绣流派，直到今天仍然长盛不衰。苏绣工艺是以绣针引彩线，在丝绸、棉布等面料上刺缀运针，通过绣迹构成花样、图案、文字以取得艺术效果。\n" +
                "苏绣既是高雅的实用品，又是精美的手工艺品，素以绣工精细，针法活泼，图案秀丽弛名中外，它具有绣面平整妥帖、色调柔和典雅、丝线疏密均整、丝理圆润的特点，能以近百种不同的针法秀出各种题材，多次被国家领导人作为国家级礼品送给外宾。f","李艳",23);
        EmbroideryWorkItem embroideryWorkItem4 = new EmbroideryWorkItem("http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-17_17-30-43.jpg",
                "猫","苏绣已有2000多年的历史，发源于苏州，在北宋时已形成了独特的风格。明代始，苏州绣工们又着重吸取了上海露香园顾绣的精湛技艺，加以融会贯通。到清代初年，已成为一个影响广泛的著名丝绣流派，直到今天仍然长盛不衰。苏绣工艺是以绣针引彩线，在丝绸、棉布等面料上刺缀运针，通过绣迹构成花样、图案、文字以取得艺术效果。\n" +
                "苏绣既是高雅的实用品，又是精美的手工艺品，素以绣工精细，针法活泼，图案秀丽弛名中外，它具有绣面平整妥帖、色调柔和典雅、丝线疏密均整、丝理圆润的特点，能以近百种不同的针法秀出各种题材，多次被国家领导人作为国家级礼品送给外宾。","江再红",34);
        arrayList.add(embroideryWorkItem);
        arrayList.add(embroideryWorkItem2);
        arrayList.add(embroideryWorkItem3);
        arrayList.add(embroideryWorkItem4);
        return arrayList;
    }
}
