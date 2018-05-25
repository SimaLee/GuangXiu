package com.simalee.guangxiu.view.history;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.DataManager;
import com.simalee.guangxiu.data.entity.DevelopmentItem;
import com.simalee.guangxiu.data.model.DataCallback;

import java.util.List;

/**
 * Created by zb.yang on 2018/5/7.
 */

public class DevelopmentPresenter extends BasePresenter<DevelopmentContract.DevelopmentView>implements DevelopmentContract.DevelopmentPresenter{
    @Override
    public void loadDevelopmentView() {
        mView.showLoading();
        DataManager.getInstance().getDevelopmentProcess(new DataCallback<List<DevelopmentItem>>() {
            @Override
            public void onSuccess(List<DevelopmentItem> data) {
                if(isViewAttached()){
                    mView.hideLoading();
                    mView.showDevelopmentView(data);
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