package com.simalee.guangxiu.view.vr;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.DataManager;

/**
 * Created by zb.yang on 2018/5/22.
 */

public class MyLocalWorksPresenter extends BasePresenter<MyLocalWorksContract.MyLocalWorksView> implements MyLocalWorksContract.MyLocalWorksPresenter {
    @Override
    public void loadMyLocalWorksView() {
        if(isViewAttached()){
            mView.showMyLocalWorksView(DataManager.getInstance().getLocalEmbroideryWorks());
        }
    }
}
