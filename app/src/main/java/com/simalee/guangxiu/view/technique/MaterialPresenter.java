package com.simalee.guangxiu.view.technique;

import com.simalee.guangxiu.base.BasePresenter;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class MaterialPresenter extends BasePresenter<TechniqueContract.MaterialView> implements TechniqueContract.IMaterialPresenter {

    private static final String TAG = "MaterialPresenter";

    public MaterialPresenter() {
    }

    @Override
    public void performPergolaClick() {
        if (isViewAttached()){
            mView.onPergolaClick();
        }
    }

    @Override
    public void performStitchClick() {
        if (isViewAttached()){
            mView.onStitchClick();
        }
    }

    @Override
    public void performThreadClick() {
        if (isViewAttached()){
            mView.onThreadClick();
        }
    }

    @Override
    public void loadPergolaIntroduction() {

    }

    @Override
    public void loadStitchIntroduction() {

    }

    @Override
    public void loadThreadList() {

    }
}
