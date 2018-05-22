package com.simalee.guangxiu.view.technique;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseActivity;
import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.view.history.OriginFragment;

/**
 * Created by Lee Sima on 2018/5/22.
 */

public class NewTechniqueActivity extends BaseActivity {

    private static final String TAG = "NewTechniqueActivity";

    private Fragment[] mFragments = {
            ArtFeatureFragment.getInstance(),
            EmbroideryFragment.getInstance(),
            MaterialFragment.getInstance(),
            StitchInfoFragment.getInstance()};

    private String[] mTitles = {"艺术特点","绣种介绍","材料介绍","针法介绍"};

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TechniquePageAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_technique;
    }

    @Override
    protected void initViews() {
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.viewPager);

        mAdapter = new TechniquePageAdapter(getSupportFragmentManager(),mFragments,mTitles);

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
