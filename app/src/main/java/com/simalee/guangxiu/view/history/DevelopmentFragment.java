package com.simalee.guangxiu.view.history;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPFragment;
import com.simalee.guangxiu.data.entity.DevelopmentItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/22.
 */

public class DevelopmentFragment extends BaseMVPFragment<DevelopmentPresenter> implements DevelopmentContract.DevelopmentView {

    private static final String TAG = "DevelopmentFragment";

    RecyclerView mRecyclerView;
    List<DevelopmentItem> mList = new ArrayList<>();
    DevelopmentTimeLineAdapter mAdapter;



    public DevelopmentFragment() {
        super();
    }

    public static DevelopmentFragment getInstance(){
        DevelopmentFragment instance = new DevelopmentFragment();
        Bundle bundle = new Bundle();
        instance.setArguments(bundle);
        return instance;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_development;
    }

    @Override
    protected void initViews(View rootView) {
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(new ItemDecoration(mContext,80));
        mAdapter = new DevelopmentTimeLineAdapter(mContext, mList);
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

    @Override
    public void showDevelopmentView(List<DevelopmentItem> data) {
        mList = data;
        mAdapter.setDevelopmentItemList(data);
    }
}
