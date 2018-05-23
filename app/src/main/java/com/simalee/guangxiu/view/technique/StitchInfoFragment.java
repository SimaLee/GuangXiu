package com.simalee.guangxiu.view.technique;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPFragment;
import com.simalee.guangxiu.data.entity.StitchInfoDetail;
import com.simalee.guangxiu.data.entity.StitchItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/22.
 */

public class StitchInfoFragment extends BaseMVPFragment<StitchInfoPresenter> implements TechniqueContract.StitchInfoView {

    private static final String TAG = "StitchInfoFragment";


    private RecyclerView mRecyclerView;
    private StitchInfoAdapter mAdapter;
    private TextView mNoDataView;


    public StitchInfoFragment() {
        super();
    }

    public static StitchInfoFragment getInstance(){
        StitchInfoFragment instance = new StitchInfoFragment();
        Bundle bundle = new Bundle();
        instance.setArguments(bundle);
        return instance;
    }



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
    protected void initViews(View rootView) {
        mNoDataView = rootView.findViewById(R.id.tv_no_data);
        mRecyclerView = rootView.findViewById(R.id.rv_stitch_list);

        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,2));
        GridSpacingItemDecoration itemDecoration = new GridSpacingItemDecoration(2,80,true);
        mRecyclerView.addItemDecoration(itemDecoration);

        mAdapter = new StitchInfoAdapter(mContext,new ArrayList<StitchItem>());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initListeners() {

        mAdapter.setItemClickListener(new StitchInfoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, StitchItem item) {
                Log.d(TAG, "onItemClick: "+item);
                Intent intent = new Intent(mContext,StitchInfoDetailActivity.class);
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
        if (stitchItemList == null ||stitchItemList.size() == 0){
            mNoDataView.setVisibility(View.VISIBLE);
        }else{
            mNoDataView.setVisibility(View.GONE);
            mAdapter.replaceData(stitchItemList);
        }
    }

    @Override
    public void showStitchInfo(StitchInfoDetail stitchInfoDetail) {
        //do nothing
    }
}
