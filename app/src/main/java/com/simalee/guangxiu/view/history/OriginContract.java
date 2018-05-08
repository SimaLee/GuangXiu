package com.simalee.guangxiu.view.history;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.base.BaseView;
import com.simalee.guangxiu.data.entity.ArtFeature;

/**
 * Created by zb.yang on 2018/5/7.
 */

public class OriginContract {
    interface OriginView extends BaseView{
        void showOrigin(ArtFeature artFeature);
    }

    interface OriginPresenter {
        void loadOrigin();
    }


}
