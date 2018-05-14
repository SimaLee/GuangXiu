package com.simalee.guangxiu.view.main;


import com.simalee.guangxiu.base.BaseView;

/**
 * Created by Lee Sima on 2018/4/24.
 */

public interface MainContract {

    interface MainView extends BaseView{

        void onLogoClick();
        void onHistoryClick();
        void onTechniqueClick();
        void onArtistClick();
        void onCartoonClick();
        void onTeachingClick();
        void onQuizClick();

        void showToast(String msg);
    }

    /**
     * MainPresenter的契约操作定义
     */
    interface IMainPresenter {

        void performLogoClick();
        void performHistoryClick();
        void performTechniqueClick();
        void performArtistClick();
        void performCartoonClick();
        void performTeachingClick();
        void performQuizClick();

        void checkVersion();
    }
}
