package com.simalee.guangxiu.view.history;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.DevelopmentItem;
import com.simalee.guangxiu.widget.MultiItemContainer;

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
        return R.layout.activity_development;
    }

    @Override
    protected void initViews() {
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(new ItemDecoration(this,80));
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {
        for (int i = 0; i < 7; i++) {
            DevelopmentItem item = new DevelopmentItem();
            item.setShortDescription("我从未见过如此厚颜无耻之人");
            item.setTimePoint("明");
            mList.add(item);
        }

        mAdapter = new DevelopmentTimeLineAdapter(this, mList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new DevelopmentPresenter();
        mPresenter.attachView(this);
    }
}
