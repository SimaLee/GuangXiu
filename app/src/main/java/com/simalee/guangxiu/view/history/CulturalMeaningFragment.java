package com.simalee.guangxiu.view.history;

import android.os.Bundle;
import android.view.View;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPFragment;
import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.widget.MultiItemContainerNew;

/**
 * Created by Lee Sima on 2018/5/22.
 */

public class CulturalMeaningFragment extends BaseMVPFragment<CulturalMeaningPresenter> implements CulturalMeaningContract.CulturalView {

    private static final String TAG = "CulturalMeaningFragment";


    private MultiItemContainerNew multiItemContainer;

    public CulturalMeaningFragment() {
        super();
    }

    public static CulturalMeaningFragment getInstance(){
        CulturalMeaningFragment instance = new CulturalMeaningFragment();
        Bundle bundle = new Bundle();
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    public void showCulturalMeaning(ArtFeature artFeature) {
        multiItemContainer.addItems(artFeature.getItemList());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cultural_meaning;
    }

    @Override
    protected void initViews(View rootView) {
        multiItemContainer = (MultiItemContainerNew)rootView.findViewById(R.id.container);

    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {
        mPresenter.loadCulturalMeaning();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new CulturalMeaningPresenter();
        mPresenter.attachView(this);
    }
}
