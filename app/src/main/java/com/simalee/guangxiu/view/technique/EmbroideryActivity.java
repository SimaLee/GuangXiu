package com.simalee.guangxiu.view.technique;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.EmbroideryIntroduction;

/**
 * Created by Lee Sima on 2018/5/8.
 */

public class EmbroideryActivity extends BaseMVPActivity<EmbroideryPresenter> implements TechniqueContract.EmbroideryView {

    private static final String TAG = "EmbroideryActivity";


    private TextView mDailyView;
    private TextView mAppriciateView;
    private TextView mSacrificeView;
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
        return R.layout.activity_embroidery;
    }

    @Override
    protected void initViews() {
        mDailyView = findViewById(R.id.tv_daily);
        mAppriciateView = findViewById(R.id.tv_appreciate);
        mSacrificeView = findViewById(R.id.tv_sacrifice);
    }

    @Override
    protected void initListeners() {
        mDailyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performDailyClick();
            }
        });
        mAppriciateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performAppreciateClick();
            }
        });
        mSacrificeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performSacrificeClick();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new EmbroideryPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void openIntroduction(String id, String name) {
        Intent intent = new Intent(this,EmbroideryIntroductionActivity.class);
        intent.putExtra("id",id);
        intent.putExtra("name",name);
        startActivity(intent);
    }

    @Override
    public void showEmbroideryIntroduction(EmbroideryIntroduction introduction) {
        //do nothing
    }
}
