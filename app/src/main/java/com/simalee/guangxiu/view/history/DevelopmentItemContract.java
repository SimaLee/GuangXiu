package com.simalee.guangxiu.view.history;

import com.simalee.guangxiu.base.BaseView;
import com.simalee.guangxiu.data.entity.ArtFeature;

/**
 * Created by zb.yang on 2018/5/17.
 */

public class DevelopmentItemContract {
    interface DevelopmentItemView extends BaseView{
        void showDevelopmentItemView(ArtFeature artFeature);
    }

    interface DevelopmentItemPresenter{
        void loadDevelopmentItemView(int id);
    }
}
