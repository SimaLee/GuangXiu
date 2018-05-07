package com.simalee.guangxiu.view.history;

import com.simalee.guangxiu.base.BasePresenter;

/**
 * Created by zb.yang on 2018/5/7.
 */

public class HistoryIntroductionPresenter extends BasePresenter<HistoryIntroductionContract.HistoryIntroductionView> implements HistoryIntroductionContract.IHistoryIntroductionPresenter{
    @Override
    public void performOriginClick() {
        mView.onOriginClick();
    }

    @Override
    public void performDevelopmentClick() {
        mView.onDevelopmentClick();
    }

    @Override
    public void performFutureDevelopmentClick() {
        mView.onFutureDevelopmentClick();
    }

    @Override
    public void performCulturalMeaningClick() {
        mView.onCulturalMeaningClick();
    }
}
