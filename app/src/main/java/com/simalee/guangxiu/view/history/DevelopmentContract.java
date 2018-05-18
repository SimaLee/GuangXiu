package com.simalee.guangxiu.view.history;

import com.simalee.guangxiu.base.BaseView;
import com.simalee.guangxiu.data.entity.DevelopmentItem;

import java.util.List;

/**
 * Created by zb.yang on 2018/5/7.
 */

public class DevelopmentContract {
    interface DevelopmentView extends BaseView{
        void showDevelopmentView(List<DevelopmentItem> data);
    }

    interface DevelopmentPresenter{
        void loadDevelopmentView();
    }
}
