package com.simalee.guangxiu.view.technique;

import android.util.Log;
import android.widget.TextView;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.ThreadIntroduction;
import com.simalee.guangxiu.data.entity.ThreadItem;
import com.simalee.guangxiu.widget.MultiItemContainer;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class ThreadIntroductionActivity extends BaseMVPActivity<ThreadPresenter> implements TechniqueContract.ThreadView {

    private static final String TAG = "ThreadIntroActivity";

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
        return R.layout.activity_thread_introduction;
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
        String id = getIntent().getStringExtra("id");
        String title = getIntent().getStringExtra("name");
        Log.d(TAG, "initData: id:"+id);
        mTitleView.setText(title);
        mPresenter.loadThreadIntroduction(id);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new ThreadPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void showThreadList(List<ThreadItem> threadItemList) {
        //do nothing
    }

    @Override
    public void showThreadIntroduction(ThreadIntroduction introduction) {
        mContainer.addItems(introduction.getItemList());
    }
}
