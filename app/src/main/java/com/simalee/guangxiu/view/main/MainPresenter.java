package com.simalee.guangxiu.view.main;


import com.simalee.guangxiu.base.BasePresenter;

/**
 * Created by Lee Sima on 2018/4/24.
 */

public class MainPresenter extends BasePresenter<MainContract.MainView> implements MainContract.IMainPresenter {

    private static final String TAG = "IMainPresenter";

    public MainPresenter(){
        //empty constructor
    }

    @Override
    public void performLogoClick() {
        mView.onLogoClick();
    }

    @Override
    public void performHistoryClick() {
        mView.onHistoryClick();
    }

    @Override
    public void performTechniqueClick() {
        mView.onTechniqueClick();
    }

    @Override
    public void performArtistClick() {
        mView.onArtistClick();
    }

    @Override
    public void performCartoonClick() {
        mView.onCartoonClick();
    }

    @Override
    public void performTeachingClick() {
        mView.onTeachingClick();
    }
}
