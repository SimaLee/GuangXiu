package com.simalee.guangxiu.view.technique;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.ProcessItem;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/23.
 */

public class ProcessActivity extends BaseMVPActivity<ProcessPresenter> implements ProcessContract.ProcessView {

    private static final String TAG = "ProcessActivity";

    private ViewPager mProcessViewPager;
    private ImageView mPreviousView;
    private ImageView mNextView;

    private ProcessPageAdapter mPageAdapter;


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
    public void showProcessItemList(List<ProcessItem> processItemList) {
        Log.d(TAG, "showProcessItemList: " + processItemList);
        if (processItemList == null || processItemList.size() == 0){
            return;
        }

        mPageAdapter = new ProcessPageAdapter(getSupportFragmentManager(),processItemList);
        mProcessViewPager.setAdapter(mPageAdapter);
        mProcessViewPager.setOffscreenPageLimit(2);

    }

    @Override
    public void showPreProcess() {
        Log.d(TAG, "showPreProcess: ");
    }

    @Override
    public void showNextProcess() {
        Log.d(TAG, "showNextProcess: ");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_process;
    }

    @Override
    protected void initViews() {
        mProcessViewPager = findViewById(R.id.vp_process);
        mPreviousView = findViewById(R.id.iv_arrow_left);
        mNextView = findViewById(R.id.iv_arrow_right);
    }

    @Override
    protected void initListeners() {
        mPreviousView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.loadPreProcess();
            }
        });
        mNextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.loadNextProcess();
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.loadProcessItemList();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new ProcessPresenter();
        mPresenter.attachView(this);
    }
}
