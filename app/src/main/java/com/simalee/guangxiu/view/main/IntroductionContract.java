package com.simalee.guangxiu.view.main;

import com.simalee.guangxiu.base.BaseView;
import com.simalee.guangxiu.data.entity.SimpleIntroduction;

/**
 * Created by Lee Sima on 2018/5/5.
 */

public interface IntroductionContract {

    interface IntroView extends BaseView{
        void showIntroduction(SimpleIntroduction introduction);
        void showIntroductionFailure(String msg);
    }

    interface IIntroPresenter{
        void loadIntroduction();
    }

}
