package com.simalee.guangxiu.view.technique;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.StitchInfoDetail;
import com.simalee.guangxiu.data.entity.StitchItem;
import com.simalee.guangxiu.widget.MultiItemContainerNew;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class StitchInfoDetailActivity extends BaseMVPActivity<StitchInfoPresenter> implements TechniqueContract.StitchInfoView {

    private static final String TAG = "StitchInfoDetailActivit";

    private MultiItemContainerNew mContainer;
    private TextView mTitleView;
    private TextView mNoDataView;


    @Override
    public void showErrorMsg(String msg) {
        super.showErrorMsg(msg);
        showNoData(true);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_stitch_info_detail;
    }

    @Override
    protected void initViews() {
        mContainer = findViewById(R.id.container);
        mTitleView = findViewById(R.id.tv_title);
        mNoDataView = findViewById(R.id.tv_no_data);
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
        if (stitchInfoDetail == null || stitchInfoDetail.getItemList() == null
                || stitchInfoDetail.getItemList().size() == 0){
            showNoData(true);
        }else{
            showNoData(false);
           mContainer.addItems(stitchInfoDetail.getItemList());
        }
    }

    private void showNoData(boolean isShow) {
        Log.d(TAG, "showNoData: isShow " + isShow);
        if (isShow){
            mNoDataView.setVisibility(View.VISIBLE);
        }else {
            mNoDataView.setVisibility(View.INVISIBLE);
        }
    }


}
