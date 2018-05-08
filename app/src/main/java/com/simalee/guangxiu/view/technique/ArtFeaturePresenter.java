package com.simalee.guangxiu.view.technique;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.data.entity.TextImageItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class ArtFeaturePresenter extends BasePresenter<TechniqueContract.ArtFeatureView> implements TechniqueContract.IArtFeaturePresenter {
    private static final String TAG = "ArtFeaturePresenter";

    public ArtFeaturePresenter(){

    }

    @Override
    public void loadArtFeature() {

        if (isViewAttached()){
            mView.showArtFeature(fakeArtFeature());
        }
    }

    private ArtFeature fakeArtFeature() {

        List<TextImageItem> itemList = new ArrayList<>();

        TextImageItem item1 = new TextImageItem();
        item1.setSequence(0);
        item1.setType(TextImageItem.TYPE_TEXT);
        item1.setText("\t\t这是第一个Text100-100\t\t唐朝开元年间（713-741年），政府改变了以往丝绸对外贸易只许官方专营的做法，允许外国商人与本国居民进行民间贸易，在广州设立市舶使负责管理，并设立“蕃坊”供外商居住，方便贸易开展。丝织业在内的纺织业发展带动了刺绣发展，岭南绣品种类繁多，工艺精湛，深受皇族钟爱。");
        itemList.add(item1);

        TextImageItem item2 = new TextImageItem();
        item2.setSequence(1);
        item2.setType(TextImageItem.TYPE_TEXT);
        item2.setText("\t\t这是第二个Text100-100\t\t宋建隆二年（961 年），朝廷诏令各地种桑养蚕，发展丝织业。广绣开始从深闺小院和皇室内庭走向市场，发展为一项重要的民间副业。由于宋仁宗嘉佑年间（1056-1063 年），朝廷派人重修大庾通道，极大地改善了这条通道的交通状况，使外省的丝绸产品源源不断流入广东。这为广绣吸纳外来绣种的工艺和技法提供了可能，也使广绣受到北绣欣赏品的影响，欣赏品的工艺日臻成熟。 " +
                "100-100\t\t南宋末年，由于官吏贪暴，抽解过重，加上棉布业兴起，福建泉州口岸开放，宋、元军队在广州进行了多年拉锯战，广州的丝绸业逐渐走向衰落。宋室南迁后，大批民间艺人（包括陶瓷、刺绣、泥塑等）从中原地区走江浙、过福建，把先进的技艺带到广东，使广绣的技艺又有了进一步的提高。");
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

        ArtFeature feature = new ArtFeature();
        feature.setItemList(itemList);
        return feature;
    }

}
