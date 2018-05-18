package com.simalee.guangxiu.view.teaching;

import com.simalee.guangxiu.base.BaseView;
import com.simalee.guangxiu.data.entity.TeachingContentItem;

import java.util.List;

/**
 * Created by zb.yang on 2018/5/10.
 */

public class TeachingContract {
    interface TeachingTypeView extends BaseView{
        void showTeachingType(List<TeachingContentItem> data);
    }

    interface ITeachingTypePresenter{
        void loadTeachingType();
    }
}
