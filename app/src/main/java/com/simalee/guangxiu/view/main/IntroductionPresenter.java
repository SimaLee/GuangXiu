package com.simalee.guangxiu.view.main;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.DataManager;
import com.simalee.guangxiu.data.entity.SimpleIntroduction;
import com.simalee.guangxiu.data.model.DataCallback;

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
        DataManager.getInstance().getIntroduction(new DataCallback<SimpleIntroduction>() {
            @Override
            public void onSuccess(SimpleIntroduction data) {
                if (isViewAttached()){
                    mView.showIntroduction(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                if (isViewAttached()) {
                    mView.showError();
                }
            }

            @Override
            public void onError() {
                if (isViewAttached()) {
                    mView.showError();
                }
            }
        });
    }
}
