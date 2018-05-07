package com.simalee.guangxiu.view.technique;

import com.simalee.guangxiu.base.BasePresenter;

/**
 * Created by Lee Sima on 2018/5/6.
 */

public class TechniquePresenter extends BasePresenter<TechniqueContract.TechniqueView> implements TechniqueContract.ITechniquePresenter{

    private static final String TAG = "TechniquePresenter";


    public TechniquePresenter() {
    }

    @Override
    public void performArtClick() {
        mView.onArtFeatureClick();
    }

    @Override
    public void performMaterialClick() {
        if (isViewAttached()) {
            mView.onMaterialClick();
        }
    }

    @Override
    public void performEmbroideryKindClick() {
        if (isViewAttached()) {
            mView.onEmbroideryKindClick();
        }
    }

    @Override
    public void performStitchClick() {
        if (isViewAttached()) {
            mView.onStitchClick();
        }
    }
}
