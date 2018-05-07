package com.simalee.guangxiu.view.technique;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.widget.MultiItemContainer;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class ArtFeatureActivity extends BaseMVPActivity<ArtFeaturePresenter> implements TechniqueContract.ArtFeatureView {

    private static final String TAG = "ArtFeatureActivity";

    private MultiItemContainer mContainer;

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showArtFeature(ArtFeature feature) {
        mContainer.addItems(feature.getItemList());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_art_feature;
    }

    @Override
    protected void initViews() {
        mContainer = findViewById(R.id.container);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {
        mPresenter.loadArtFeature();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new ArtFeaturePresenter();
        mPresenter.attachView(this);
    }
}
