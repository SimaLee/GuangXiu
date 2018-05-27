package com.simalee.guangxiu.view.technique;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.ProcessItem;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/23.
 */

public class ProcessActivity extends BaseMVPActivity<ProcessPresenter> implements ProcessContract.ProcessView {

    private static final String TAG = "ProcessActivity";

    private ViewPager mProcessViewPager;
    private ImageView mPreviousView;
    private ImageView mNextView;

    private ProcessPageAdapter mPageAdapter;
    private int mProcessSize;


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showProcessItemList(List<ProcessItem> processItemList) {
        Log.d(TAG, "showProcessItemList: " + processItemList);
        if (processItemList == null || processItemList.size() == 0){
            return;
        }
        mProcessSize = processItemList.size();

        mPageAdapter = new ProcessPageAdapter(getSupportFragmentManager(),processItemList);
        mProcessViewPager.setAdapter(mPageAdapter);
        mProcessViewPager.setOffscreenPageLimit(3);
        mProcessViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected: " + position);
                notifyArrowChanged(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 用于更新箭头是否显示
     * @param position
     */
    private void notifyArrowChanged(int position) {

        if (position == 0){

            mPreviousView.setVisibility(View.INVISIBLE);
            mNextView.setVisibility(View.VISIBLE);

        }else if (position == mProcessSize - 1){

            mPreviousView.setVisibility(View.VISIBLE);
            mNextView.setVisibility(View.INVISIBLE);

        }else{

            mPreviousView.setVisibility(View.VISIBLE);
            mNextView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showPreProcess() {
        Log.d(TAG, "showPreProcess: ");
        int position = mProcessViewPager.getCurrentItem();
        if (position == 0){
            Toast.makeText(this,"第一道工序了哦",Toast.LENGTH_SHORT).show();
            return;
        }
        int preIndex = position - 1;
        if (preIndex >= 0 && preIndex < mProcessSize){
            mProcessViewPager.setCurrentItem(preIndex,true);
        }
    }

    @Override
    public void showNextProcess() {
        Log.d(TAG, "showNextProcess: ");
        int position = mProcessViewPager.getCurrentItem();
        if (position == mProcessSize - 1 ){
            Toast.makeText(this,"没有更多工序了哦",Toast.LENGTH_SHORT).show();
            return;
        }
        int nextIndex = position + 1;
        if (nextIndex >= 0 && nextIndex < mProcessSize){
            mProcessViewPager.setCurrentItem(nextIndex,true);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_process;
    }

    @Override
    protected void initViews() {
        mProcessViewPager = findViewById(R.id.vp_process);
        mPreviousView = findViewById(R.id.iv_arrow_left);
        //初始时不显示
        mPreviousView.setVisibility(View.INVISIBLE);
        mNextView = findViewById(R.id.iv_arrow_right);
    }

    @Override
    protected void initListeners() {
        mPreviousView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.loadPreProcess();
            }
        });
        mNextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.loadNextProcess();
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.loadProcessItemList();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new ProcessPresenter();
        mPresenter.attachView(this);
    }
}
