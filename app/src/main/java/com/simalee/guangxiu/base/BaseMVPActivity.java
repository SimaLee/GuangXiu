package com.simalee.guangxiu.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;


/**
 * Created by Lee Sima on 2018/5/3.
 */

public abstract class BaseMVPActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{

    private static final String TAG = "BaseMVPActivity";

    protected P mPresenter;
    protected ProgressDialog mProgressDialog;

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

    @Override
    public void showLoading() {
        if (mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if(mProgressDialog != null){
            if (mProgressDialog.isShowing()){
                mProgressDialog.dismiss();
            }
        }
    }

    @Override
    public void showErrorMsg(String msg) {

        if (TextUtils.isEmpty(msg)){
            return;
        }
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
