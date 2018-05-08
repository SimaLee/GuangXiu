package com.simalee.guangxiu.view.technique;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.TextImageItem;
import com.simalee.guangxiu.widget.MultiItemContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/6.
 */

public class TechniqueActivity extends BaseMVPActivity<TechniquePresenter> implements TechniqueContract.TechniqueView {

    private static final String TAG = "TechniqueActivity";


    private TextView mArtView;
    private TextView mMaterialView;
    private TextView mEmbroideryKindView;
    private TextView mStitchView;

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
    public void onArtFeatureClick() {
        Log.d(TAG, "onArtFeatureClick: 艺术特点");
        Intent intent = new Intent(this,ArtFeatureActivity.class);
        startActivity(intent);
    }

    @Override
    public void onMaterialClick() {
        Log.d(TAG, "onMaterialClick: 材料介绍");
        Intent intent = new Intent(this,MaterialActivity.class);
        startActivity(intent);
    }

    @Override
    public void onEmbroideryKindClick() {
        Log.d(TAG, "onEmbroideryKindClick: 绣种介绍");
        Intent intent = new Intent(this,EmbroideryActivity.class);
        startActivity(intent);
    }

    @Override
    public void onStitchClick() {
        Log.d(TAG, "onStitchClick: 针法介绍");
        Intent intent = new Intent(this,StitchInfoActivity.class);
        startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_technique;
    }

    @Override
    protected void initViews() {
        mArtView = findViewById(R.id.tv_art);
        mMaterialView = findViewById(R.id.tv_material);
        mEmbroideryKindView = findViewById(R.id.tv_embroidery_kind);
        mStitchView = findViewById(R.id.tv_stitch);
    }

    @Override
    protected void initListeners() {
        mArtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performArtClick();
            }
        });

        mMaterialView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performMaterialClick();
            }
        });

        mEmbroideryKindView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performEmbroideryKindClick();
            }
        });

        mStitchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performStitchClick();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new TechniquePresenter();
        mPresenter.attachView(this);
    }
}
