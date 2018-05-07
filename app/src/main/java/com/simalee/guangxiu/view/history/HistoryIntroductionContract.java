package com.simalee.guangxiu.view.history;

import com.simalee.guangxiu.base.BaseView;

/**
 * Created by zb.yang on 2018/5/7.
 */

public class HistoryIntroductionContract {
    interface HistoryIntroductionView extends BaseView{
        void onOriginClick();
        void onDevelopmentClick();
        void onFutureDevelopmentClick();
        void onCulturalMeaningClick();
    }

    interface IHistoryIntroductionPresenter{
        void performOriginClick();
        void performDevelopmentClick();
        void performFutureDevelopmentClick();
        void performCulturalMeaningClick();
    }
}
