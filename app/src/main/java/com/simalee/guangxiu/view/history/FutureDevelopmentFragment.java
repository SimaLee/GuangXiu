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

public class FutureDevelopmentFragment extends BaseMVPFragment<FutureDevelopmentPresenter> implements FutureDevelopmentContract.FutureDevelopmentView {
    private static final String TAG = "FutureDevelopmentFragme";


    private MultiItemContainerNew multiItemContainer;

    public FutureDevelopmentFragment() {
        super();
    }
    public static FutureDevelopmentFragment getInstance(){
        FutureDevelopmentFragment instance = new FutureDevelopmentFragment();
        Bundle bundle = new Bundle();
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    public void showFutureDevelopment(ArtFeature artFeature) {
        multiItemContainer.addItems(artFeature.getItemList());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_future_development;
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
        mPresenter.loadFutureDevelopment();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new FutureDevelopmentPresenter();
        mPresenter.attachView(this);
    }
}
