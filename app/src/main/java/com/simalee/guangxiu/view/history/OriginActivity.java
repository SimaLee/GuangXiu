package com.simalee.guangxiu.view.history;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.widget.MultiItemContainerNew;

/**
 * Created by zb.yang on 2018/5/7.
 */

public class OriginActivity extends BaseMVPActivity<OriginPresenter> implements OriginContract.OriginView{
    public static final String TAG = "OriginActivity";

    private MultiItemContainerNew multiItemContainer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_origin;
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
        mPresenter.loadOrigin();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new OriginPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void showOrigin(ArtFeature artFeature) {
        multiItemContainer.addItems(artFeature.getItemList());
    }
}
