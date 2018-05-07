package com.simalee.guangxiu.view.technique;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;

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
    }

    @Override
    public void onStitchClick() {
        Log.d(TAG, "onStitchClick: ");
    }

    @Override
    public void onThreadClick() {
        Log.d(TAG, "onThreadClick: ");
    }

    @Override
    public void showPergolaIntroduction() {

    }

    @Override
    public void showStitchIntroduction() {

    }

    @Override
    public void showThreadList() {

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
