package com.simalee.guangxiu.view.technique;

import com.simalee.guangxiu.base.BaseView;
import com.simalee.guangxiu.data.entity.ArtFeature;

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

        void showPergolaIntroduction();
        void showStitchIntroduction();
        void showThreadList();
    }

    interface IMaterialPresenter{
        void performPergolaClick();//花架
        void performStitchClick();
        void performThreadClick();

        void loadPergolaIntroduction();
        void loadStitchIntroduction();
        void loadThreadList();
    }

    //绣种介绍
    interface EmbroideryView extends BaseView{
        void showEmbroidery();
    }

    interface  IEmbroideryPresenter{
        void loadEmbroidery();
    }

    //针法介绍
    interface StitchInfoView extends BaseView{
        void showStitchInfo();
    }
    interface IStitchInfoPresenter{
        void loadStitichInfo();
    }
}
