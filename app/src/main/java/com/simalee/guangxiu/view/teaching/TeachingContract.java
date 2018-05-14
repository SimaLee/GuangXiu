package com.simalee.guangxiu.view.teaching;

import com.simalee.guangxiu.base.BaseView;

/**
 * Created by zb.yang on 2018/5/10.
 */

public class TeachingContract {
    interface TeachingTypeView extends BaseView{
        void showTeachingType();
    }

    interface ITeachingTypePresenter{
        void loadTeachingType();
    }
}
