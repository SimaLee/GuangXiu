package com.simalee.guangxiu.view.technique;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.StitchIntroduction;
import com.simalee.guangxiu.widget.MultiItemContainerNew;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class StitchIntroductionActivity extends BaseMVPActivity<StitchPresenter> implements TechniqueContract.StitchView {

    private static final String TAG = "StitchIntroductionActit";

    private MultiItemContainerNew mContainer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_stitch_introduction;
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
        mPresenter.loadStitchIntroduction();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new StitchPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void showStitchIntroduction(StitchIntroduction introduction) {
        mContainer.addItems(introduction.getItemList());
    }
}
