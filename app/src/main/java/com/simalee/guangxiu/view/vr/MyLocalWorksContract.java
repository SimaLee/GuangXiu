package com.simalee.guangxiu.view.vr;

import com.simalee.guangxiu.base.BaseView;
import com.simalee.guangxiu.data.entity.LocalEmbroideryWork;

import java.util.List;

/**
 * Created by zb.yang on 2018/5/22.
 */

public class MyLocalWorksContract {
    interface MyLocalWorksView extends BaseView{
        void showMyLocalWorksView(List<LocalEmbroideryWork> data);
    }

    interface MyLocalWorksPresenter{
        void loadMyLocalWorksView();
    }
}
