package com.simalee.guangxiu.view.main;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.SimpleIntroduction;

/**
 * Created by Lee Sima on 2018/5/5.
 */

public class IntroductionActivity extends BaseMVPActivity<IntroductionPresenter> implements IntroductionContract.IntroView{

    private static final String TAG = "IntroductionActivity";


    private TextView mIntroduction;
    private ImageView mImage;

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
    public void showIntroduction(SimpleIntroduction introduction) {
        Log.d(TAG, "showIntroduction: " + introduction);
        mIntroduction.setText(introduction.getDescription());
        Glide.with(this)
                .load(introduction.getBackgroundImg())
                .fitCenter()
                .error(R.mipmap.bg_introduction_default)
                .into(mImage);
    }

    @Override
    public void showIntroductionFailure(String msg) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_introduction;
    }

    @Override
    protected void initViews() {
        mIntroduction = findViewById(R.id.tv_introduction);
        mImage = findViewById(R.id.iv_image);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {
        mPresenter.loadIntroduction();
    }

    @Override
    protected void  createPresenter() {
        mPresenter = new IntroductionPresenter();
        mPresenter.attachView(this);
    }

}
