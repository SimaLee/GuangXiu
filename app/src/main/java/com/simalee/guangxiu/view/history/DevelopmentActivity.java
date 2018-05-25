package com.simalee.guangxiu.view.history;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.DevelopmentItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zb.yang on 2018/5/7.
 */

public class DevelopmentActivity extends BaseMVPActivity<DevelopmentPresenter> implements DevelopmentContract.DevelopmentView {
    public static final String TAG = "DevelopmentActivity";

    RecyclerView mRecyclerView;
    List<DevelopmentItem> mList = new ArrayList<>();
    DevelopmentTimeLineAdapter mAdapter;

    @Override
    public void showDevelopmentView(List<DevelopmentItem> data) {
        mList = data;
        mAdapter.setDevelopmentItemList(data);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_development;
    }

    @Override
    protected void initViews() {
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(new ItemDecoration(this,80));
        mAdapter = new DevelopmentTimeLineAdapter(this, mList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {
        mPresenter.loadDevelopmentView();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new DevelopmentPresenter();
        mPresenter.attachView(this);
    }
}
