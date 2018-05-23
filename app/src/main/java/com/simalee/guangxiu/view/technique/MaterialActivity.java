package com.simalee.guangxiu.view.technique;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.PergolaIntroduction;
import com.simalee.guangxiu.data.entity.StitchIntroduction;
import com.simalee.guangxiu.data.entity.ThreadItem;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class MaterialActivity extends BaseMVPActivity<MaterialPresenter> implements TechniqueContract.MaterialView {

    private static final String TAG = "MaterialActivity";


    private TextView mPergolaView;
    private TextView mStitchView;
    private TextView mThreadView;

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
    public void onPergolaClick() {
        Log.d(TAG, "onPergolaClick: ");
        Intent intent = new Intent(this,PergolaIntroductionActivity.class);
        startActivity(intent);
    }

    @Override
    public void onStitchClick() {
        Log.d(TAG, "onStitchClick: ");
        Intent intent = new Intent(this,StitchIntroductionActivity.class);
        startActivity(intent);
    }

    @Override
    public void onThreadClick() {
        Log.d(TAG, "onThreadClick: ");
        Intent intent = new Intent(this,ThreadListActivity.class);
        startActivity(intent);
    }

    @Override
    public void showPergolaIntroduction(PergolaIntroduction introduction) {

    }

    @Override
    public void showStitchIntroduction(StitchIntroduction introduction) {

    }

    @Override
    public void showThreadList(List<ThreadItem> threadItemList) {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_material;
    }

    @Override
    protected void initViews() {
        mPergolaView = findViewById(R.id.tv_pergola);
        mStitchView = findViewById(R.id.tv_stitch);
        mThreadView = findViewById(R.id.tv_thread);
    }

    @Override
    protected void initListeners() {
        mPergolaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performPergolaClick();
            }
        });

        mStitchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performStitchClick();
            }
        });

        mThreadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performThreadClick();
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new MaterialPresenter();
        mPresenter.attachView(this);
    }
}
