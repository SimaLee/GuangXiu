package com.simalee.guangxiu.view.history;

import android.content.Intent;
import android.os.Bundle;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.data.entity.DevelopmentItem;
import com.simalee.guangxiu.widget.MultiItemContainerNew;

/**
 * Created by zb.yang on 2018/5/17.
 */

public class DevelopmentItemActivity extends BaseMVPActivity<DevelopmentItemPresenter> implements DevelopmentItemContract.DevelopmentItemView {
    private static final String TAG = "DevelopmentItem";

    private MultiItemContainerNew multiItemContainer;


    @Override
    public void showDevelopmentItemView(ArtFeature artFeature) {
        multiItemContainer.addItems(artFeature.getItemList());
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_development_item;
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
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        DevelopmentItem developmentItem = bundle.getParcelable(DevelopmentItem.TAG);
        if(developmentItem!=null) {
            mPresenter.loadDevelopmentItemView(developmentItem.getDevelopmentItemId());
        }
    }

    @Override
    protected void createPresenter() {
        mPresenter = new DevelopmentItemPresenter();
        mPresenter.attachView(this);
    }
}
