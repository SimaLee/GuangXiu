package com.simalee.guangxiu.view.technique;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.PergolaIntroduction;
import com.simalee.guangxiu.widget.MultiItemContainer;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class PergolaIntroductionActivity extends BaseMVPActivity<PergolaPresenter> implements TechniqueContract.PergolaView {

    private static final String TAG = "PergolaIntroductionActi";

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
    protected int getLayoutId() {
        return R.layout.activity_pergola_introduction;
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
        mPresenter.loadPergolaIntroduction();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new PergolaPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void showPergolaIntroduction(PergolaIntroduction introduction) {
        mContainer.addItems(introduction.getItemList());
    }
}
