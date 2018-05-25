package com.simalee.guangxiu.view.history;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.DataManager;
import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.data.model.DataCallback;

/**
 * Created by zb.yang on 2018/5/17.
 */

public class DevelopmentItemPresenter extends BasePresenter<DevelopmentItemContract.DevelopmentItemView> implements DevelopmentItemContract.DevelopmentItemPresenter {
    @Override
    public void loadDevelopmentItemView(int id) {
        mView.showLoading();
        DataManager.getInstance().getDevelopmentItem(id, new DataCallback<ArtFeature>() {
            @Override
            public void onSuccess(ArtFeature data) {
                if(isViewAttached()){
                    mView.hideLoading();
                    mView.showDevelopmentItemView(data);
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
}
