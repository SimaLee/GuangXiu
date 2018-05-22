package com.simalee.guangxiu.view.technique;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.StitchInfoDetail;
import com.simalee.guangxiu.data.entity.StitchItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class StitchInfoActivity extends BaseMVPActivity<StitchInfoPresenter> implements TechniqueContract.StitchInfoView {

    private static final String TAG = "StitchInfoActivity";

    private RecyclerView mRecyclerView;
    private StitchInfoAdapter mAdapter;

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
        return R.layout.activity_stitch_info;
    }

    @Override
    protected void initViews() {
        mRecyclerView = findViewById(R.id.rv_stitch_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mAdapter = new StitchInfoAdapter(this,new ArrayList<StitchItem>());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initListeners() {
       mAdapter.setItemClickListener(new StitchInfoAdapter.OnItemClickListener() {
           @Override
           public void onItemClick(int position, StitchItem item) {
               Log.d(TAG, "onItemClick: "+item);
               Intent intent = new Intent(StitchInfoActivity.this,StitchInfoDetailActivity.class);
               intent.putExtra("id",item.getId());
               intent.putExtra("name",item.getName());
               startActivity(intent);
           }
       });
    }

    @Override
    protected void initData() {
        mPresenter.loadStitchList();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new StitchInfoPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void showStitchList(List<StitchItem> stitchItemList) {
        mAdapter.replaceData(stitchItemList);
    }

    @Override
    public void showStitchInfo(StitchInfoDetail stitchInfoDetail) {

    }

}
