package com.simalee.guangxiu.view.technique;

import com.simalee.guangxiu.base.BaseView;
import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.data.entity.EmbroideryIntroduction;
import com.simalee.guangxiu.data.entity.PergolaIntroduction;
import com.simalee.guangxiu.data.entity.StitchInfoDetail;
import com.simalee.guangxiu.data.entity.StitchIntroduction;
import com.simalee.guangxiu.data.entity.StitchItem;
import com.simalee.guangxiu.data.entity.ThreadIntroduction;
import com.simalee.guangxiu.data.entity.ThreadItem;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/6.
 */

public interface TechniqueContract {

    //主页
    interface TechniqueView extends BaseView{
        void onArtFeatureClick();
        void onMaterialClick();
        void onEmbroideryKindClick();
        void onStitchClick();
    }
    interface ITechniquePresenter{
        void performArtClick();
        void performMaterialClick();
        void performEmbroideryKindClick();
        void performStitchClick();
    }

    //艺术特点
    interface ArtFeatureView extends BaseView{
        void showArtFeature(ArtFeature feature);
    }

    interface IArtFeaturePresenter{
        void loadArtFeature();
    }

    //材料介绍
    interface MaterialView extends BaseView{
        void onPergolaClick();//花架
        void onStitchClick();
        void onThreadClick();

        void showPergolaIntroduction(PergolaIntroduction introduction);
        void showStitchIntroduction(StitchIntroduction introduction);
        void showThreadList(List<ThreadItem> threadItemList);
    }

    interface IMaterialPresenter{
        void performPergolaClick();//花架
        void performStitchClick();
        void performThreadClick();

        void loadPergolaIntroduction();
        void loadStitchIntroduction();
        void loadThreadList();

    }

    //花架相关介绍
    interface PergolaView extends BaseView{
        void showPergolaIntroduction(PergolaIntroduction introduction);
    }

    interface IPergolaPresenter {
        void loadPergolaIntroduction();
    }
    //绣针介绍
    interface StitchView extends BaseView{
        void showStitchIntroduction(StitchIntroduction introduction);
    }
    interface IStitchPresenter {
        void loadStitchIntroduction();
    }

    //绣线展示
    interface ThreadView extends BaseView{
        void showThreadList(List<ThreadItem> threadItemList);
        void showThreadIntroduction(ThreadIntroduction introduction);
    }
    interface IThreadPresenter {
        void loadThreadList();
        void loadThreadIntroduction(String threadId);
    }

    //绣种介绍
    interface EmbroideryView extends BaseView{
        void openIntroduction(String id,String name);

        void showEmbroideryIntroduction(EmbroideryIntroduction introduction);
    }

    interface  IEmbroideryPresenter{
        void performDailyClick();
        void performAppreciateClick();
        void performSacrificeClick();

        void loadEmbroideryIntroduction(String id);
    }

    //针法介绍
    interface StitchInfoView extends BaseView{
        void showStitchList(List<StitchItem> stitchItemList);
        void showStitchInfo(StitchInfoDetail stitchInfoDetail);

    }
    interface IStitchInfoPresenter{
        void loadStitchList();
        void loadStitchInfo(String stitchId);
    }
}
