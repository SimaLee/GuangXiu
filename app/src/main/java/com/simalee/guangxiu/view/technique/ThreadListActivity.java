package com.simalee.guangxiu.view.technique;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.ThreadIntroduction;
import com.simalee.guangxiu.data.entity.ThreadItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class ThreadListActivity extends BaseMVPActivity<ThreadPresenter> implements TechniqueContract.ThreadView {

    private static final String TAG = "ThreadListActivity";

    private RecyclerView mRecyclerView;
    private ThreadListAdapter mAdapter;

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
        return R.layout.activity_thread_list;
    }

    @Override
    protected void initViews() {
        mRecyclerView = findViewById(R.id.rv_thread_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        mAdapter = new ThreadListAdapter(this,new ArrayList<ThreadItem>());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initListeners() {
        mAdapter.setItemClickListener(new ThreadListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, ThreadItem item) {
                Log.d(TAG, "onItemClick: item +" + item);
                Intent intent = new Intent(ThreadListActivity.this,ThreadIntroductionActivity.class);
                intent.putExtra("id",item.getId());
                intent.putExtra("name",item.getName());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.loadThreadList();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new ThreadPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void showThreadList(List<ThreadItem> threadItemList) {
        mAdapter.replaceData(threadItemList);
    }

    @Override
    public void showThreadIntroduction(ThreadIntroduction introduction) {
        //do nothing
    }
}
