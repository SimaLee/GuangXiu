package com.simalee.guangxiu.view.history;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.widget.MultiItemContainerNew;

/**
 * Created by zb.yang on 2018/5/7.
 */

public class CulturalMeaningActivity extends BaseMVPActivity<CulturalMeaningPresenter> implements CulturalMeaningContract.CulturalView {
    public static final String TAG = "CulturalMeaningActivity";

    private MultiItemContainerNew multiItemContainer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cultural_meaning;
    }

    @Override
    protected void initViews() {
        multiItemContainer = (MultiItemContainerNew)findViewById(R.id.container);
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

    @Override
    public void showCulturalMeaning(ArtFeature artFeature) {
        multiItemContainer.addItems(artFeature.getItemList());
    }
}
