package com.simalee.guangxiu.view.technique;

import android.widget.TextView;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.StitchInfoDetail;
import com.simalee.guangxiu.data.entity.StitchItem;
import com.simalee.guangxiu.widget.MultiItemContainer;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class StitchInfoDetailActivity extends BaseMVPActivity<StitchInfoPresenter> implements TechniqueContract.StitchInfoView {

    private static final String TAG = "StitchInfoDetailActivit";

    private MultiItemContainer mContainer;
    private TextView mTitleView;
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
        return R.layout.activity_stitch_info_detail;
    }

    @Override
    protected void initViews() {
        mContainer = findViewById(R.id.container);
        mTitleView = findViewById(R.id.tv_title);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {
        String id = getIntent().getStringExtra("id");
        String name = getIntent().getStringExtra("name");
        mTitleView.setText(name);
        mPresenter.loadStitchInfo(id);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new StitchInfoPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void showStitchList(List<StitchItem> stitchItemList) {
        //do nothing
    }

    @Override
    public void showStitchInfo(StitchInfoDetail stitchInfoDetail) {
        mContainer.addItems(stitchInfoDetail.getItemList());
    }


}
