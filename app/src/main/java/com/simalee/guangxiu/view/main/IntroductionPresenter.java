package com.simalee.guangxiu.view.main;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.entity.SimpleIntroduction;

/**
 * Created by Lee Sima on 2018/5/5.
 */

public class IntroductionPresenter extends BasePresenter<IntroductionContract.IntroView> implements IntroductionContract.IIntroPresenter{

    private static final String TAG = "IntroductionPresenter";

    public IntroductionPresenter(){

    }

    @Override
    public void loadIntroduction() {
        //数据加载
        mView.showIntroduction(new SimpleIntroduction("广绣简要介绍" ,"图片url"));
    }
}
