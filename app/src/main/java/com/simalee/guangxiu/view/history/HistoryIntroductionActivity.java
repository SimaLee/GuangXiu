package com.simalee.guangxiu.view.history;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.base.BaseView;

import java.sql.BatchUpdateException;

/**
 * Created by zb.yang on 2018/5/7.
 */

public class HistoryIntroductionActivity extends BaseMVPActivity<HistoryIntroductionPresenter>implements HistoryIntroductionContract.HistoryIntroductionView {
    private static final String TAG = "HistoryIntroductionActivity";

    private Button originBtn;
    private Button developmentBtn;
    private Button futureDevelopmentBtn;
    private Button culturalMeaningBtn;

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
        return R.layout.activity_history_introduction;
    }

    @Override
    protected void initViews() {
        originBtn = (Button)findViewById(R.id.originBtn);
        developmentBtn = (Button)findViewById(R.id.developmentBtn);
        futureDevelopmentBtn = (Button)findViewById(R.id.futureDevelopmentBtn);
        culturalMeaningBtn = (Button)findViewById(R.id.culturalMeaningBtn);
    }

    @Override
    protected void initListeners() {
        originBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performOriginClick();
            }
        });

        developmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performDevelopmentClick();
            }
        });

        futureDevelopmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performFutureDevelopmentClick();
            }
        });

        culturalMeaningBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performCulturalMeaningClick();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new HistoryIntroductionPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void onOriginClick() {
        Intent intent = new Intent(HistoryIntroductionActivity.this,OriginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDevelopmentClick() {
        Intent intent = new Intent(HistoryIntroductionActivity.this,DevelopmentActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFutureDevelopmentClick() {
        Intent intent = new Intent(HistoryIntroductionActivity.this,FutureDevelopmentActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCulturalMeaningClick() {
        Intent intent = new Intent(HistoryIntroductionActivity.this,CulturalMeaningActivity.class);
        startActivity(intent);
    }
}
