package com.simalee.guangxiu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by Lee Sima on 2018/5/3.
 */

public abstract class BaseMVPActivity<P extends BasePresenter> extends AppCompatActivity {

    private static final String TAG = "BaseMVPActivity";

    protected P mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() != 0){
            setContentView(getLayoutId());
        }
        initViews();
        initListeners();
        createPresenter();

        initData();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.detachView();
        }
    }

    /**
     * @return 获取layoutid
     */
    protected abstract  int getLayoutId();

    /**
     * 完成view的初始化
     */
    protected abstract void initViews();

    /**
     * 完成事件的绑定
     */
    protected abstract void initListeners();
    /**
     * 完成数据的初始化
     */
    protected abstract void initData();

    /**
     * 创建presenter
     */
    protected abstract void createPresenter();
}
