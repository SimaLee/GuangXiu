package com.simalee.guangxiu.view.history;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseActivity;

/**
 * Created by Lee Sima on 2018/5/22.
 */

public class NewHistoryActivity extends BaseActivity {

    private static final String TAG = "NewHistoryActivity";

    private Fragment[] mFragments = {
            OriginFragment.getInstance(),
            DevelopmentFragment.getInstance(),
            FutureDevelopmentFragment.getInstance(),
            CulturalMeaningFragment.getInstance()};

    private String[] mTitles = {"历史起源","发展过程","未来发展","文化寓意"};

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private HistoryPageAdapter mAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_history;
    }

    @Override
    protected void initViews() {
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.viewPager);
        mAdapter = new HistoryPageAdapter(getSupportFragmentManager(),mFragments,mTitles);

        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(2);

        mTabLayout.setupWithViewPager(mViewPager,false);

    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {

    }
}
