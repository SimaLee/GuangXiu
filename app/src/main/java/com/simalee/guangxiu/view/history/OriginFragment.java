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

public class OriginFragment extends BaseMVPFragment<OriginPresenter> implements OriginContract.OriginView {

    private static final String TAG = "HistoryIntroductionFrag";

    private MultiItemContainerNew multiItemContainer;


    public OriginFragment() {
        super();
    }

    public static OriginFragment getInstance(){
        OriginFragment instance = new OriginFragment();
        Bundle bundle = new Bundle();
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_origin;
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
