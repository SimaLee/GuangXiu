package com.simalee.guangxiu.view.technique;

import android.widget.TextView;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.EmbroideryIntroduction;
import com.simalee.guangxiu.widget.MultiItemContainer;

/**
 * Created by Lee Sima on 2018/5/8.
 */

public class EmbroideryIntroductionActivity extends BaseMVPActivity<EmbroideryPresenter> implements TechniqueContract.EmbroideryView {

    private static final String TAG = "EmbroideryIntroductionA";

    private MultiItemContainer mContainer;
    private TextView mTitleView;

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
        return R.layout.activity_embroidery_introduction;
    }

    @Override
    protected void initViews() {
        mContainer = findViewById(R.id.container);
        mTitleView = findViewById(R.id.tv_title);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {
        String name = getIntent().getStringExtra("name");
        String id = getIntent().getStringExtra("id");
        mTitleView.setText(name);
        mPresenter.loadEmbroideryIntroduction(id);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new EmbroideryPresenter();
        mPresenter.attachView(this);
    }


    @Override
    public void openIntroduction(String id, String name) {
        //do nothing
    }

    @Override
    public void showEmbroideryIntroduction(EmbroideryIntroduction introduction) {
        mContainer.addItems(introduction.getItemList());
    }
}
