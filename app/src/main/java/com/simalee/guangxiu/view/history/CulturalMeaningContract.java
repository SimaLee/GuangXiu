package com.simalee.guangxiu.view.history;

import com.simalee.guangxiu.base.BaseView;
import com.simalee.guangxiu.data.entity.ArtFeature;

/**
 * Created by zb.yang on 2018/5/7.
 */

public class CulturalMeaningContract {
    interface CulturalView extends BaseView{
        void showCulturalMeaning(ArtFeature artFeature);
    }

    interface CulturalPresenter{
        void loadCulturalMeaning();
    }
}
