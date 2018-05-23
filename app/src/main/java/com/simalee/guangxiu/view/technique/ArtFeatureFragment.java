package com.simalee.guangxiu.view.technique;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPFragment;
import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.widget.MultiItemContainerNew;

/**
 * Created by Lee Sima on 2018/5/22.
 */

public class ArtFeatureFragment extends BaseMVPFragment<ArtFeaturePresenter> implements TechniqueContract.ArtFeatureView {
    private static final String TAG = "ArtFeatureFragment";


    private MultiItemContainerNew mContainer;
    private TextView mNoDataView;

    public ArtFeatureFragment() {
        super();
    }

    public static ArtFeatureFragment getInstance(){
        ArtFeatureFragment instance = new ArtFeatureFragment();
        Bundle bundle = new Bundle();
        instance.setArguments(bundle);
        return instance;
    }


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
        if (feature.getItemList().size() == 0){
            mNoDataView.setVisibility(View.VISIBLE);
        }else{
            mNoDataView.setVisibility(View.GONE);
            mContainer.addItems(feature.getItemList());
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_art_feature;
    }

    @Override
    protected void initViews(View rootView) {
        mContainer = rootView.findViewById(R.id.container);
        mNoDataView = rootView.findViewById(R.id.tv_no_data);
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
