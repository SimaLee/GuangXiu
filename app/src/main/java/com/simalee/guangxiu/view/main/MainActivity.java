package com.simalee.guangxiu.view.main;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.app.UrlConstants;
import com.simalee.guangxiu.base.BaseMVPActivity;

import com.simalee.guangxiu.view.artist.ArtistListActivity;
import com.simalee.guangxiu.view.artist.ArtistListAdapter;
import com.simalee.guangxiu.view.history.HistoryIntroductionActivity;
import com.simalee.guangxiu.view.technique.TechniqueActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;


public class MainActivity extends BaseMVPActivity<MainPresenter> implements MainContract.MainView{

    private static final String TAG = "MainActivity";

    private TextView mLogoView;
    private TextView mHistoryView;
    private TextView mTechniqueView;
    private TextView mArtistsView;
    private TextView mCartoonView;
    private TextView mTeachingView;


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mPresenter != null){
            mPresenter.detachView();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
     protected void initViews() {

        mLogoView = findViewById(R.id.tv_logo);
        mHistoryView = findViewById(R.id.tv_history);
        mTechniqueView = findViewById(R.id.tv_technique);
        mArtistsView = findViewById(R.id.tv_artists);
        mCartoonView = findViewById(R.id.tv_cartoon);
        mTeachingView = findViewById(R.id.tv_teaching);

    }

    @Override
    protected void initListeners() {
        mLogoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performLogoClick();
            }
        });

        mHistoryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performHistoryClick();
            }
        });

        mTechniqueView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performTechniqueClick();
            }
        });

        mArtistsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performArtistClick();
            }
        });

        mCartoonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performCartoonClick();
            }
        });

        mTeachingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performTeachingClick();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);

    }

    @Override
    public void onLogoClick() {
        Log.d(TAG, "onLogoClick: ");
        shortToast("点击了logo");
        Intent intent = new Intent(MainActivity.this,IntroductionActivity.class);
        startActivity(intent);
    }

    @Override
    public void onHistoryClick() {
        Log.d(TAG, "onHistoryClick: ");
        shortToast("点击了历史");
        Intent intent = new Intent(MainActivity.this, HistoryIntroductionActivity.class);
        startActivity(intent);
    }

    @Override
    public void onTechniqueClick() {
        Log.d(TAG, "onTechniqueClick: ");
        shortToast("点击了技艺");
        Intent intent = new Intent(this, TechniqueActivity.class);
        startActivity(intent);
    }

    @Override
    public void onArtistClick() {
        Log.d(TAG, "onArtistClick: ");
        shortToast("点击了名家");
        Intent intent = new Intent(this, ArtistListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCartoonClick() {
        Log.d(TAG, "onCartoonClick: ");
        shortToast("点击了动画");
    }

    @Override
    public void onTeachingClick() {
        Log.d(TAG, "onTeachingClick: ");
        shortToast("点击了教学");
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
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

    private void shortToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
