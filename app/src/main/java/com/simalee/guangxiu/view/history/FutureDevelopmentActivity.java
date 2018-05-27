package com.simalee.guangxiu.view.history;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.widget.MultiItemContainerNew;

/**
 * Created by zb.yang on 2018/5/7.
 */

public class FutureDevelopmentActivity extends BaseMVPActivity<FutureDevelopmentPresenter> implements FutureDevelopmentContract.FutureDevelopmentView {
    public static final String TAG = "FutureDevelopmentActivity";

    private MultiItemContainerNew multiItemContainer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_future_development;
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
        mPresenter.loadFutureDevelopment();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new FutureDevelopmentPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void showFutureDevelopment(ArtFeature artFeature) {
        multiItemContainer.addItems(artFeature.getItemList());
    }
}
