package com.simalee.guangxiu.view.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Lee Sima on 2018/5/22.
 */

public class MainPageAdapter extends FragmentPagerAdapter {

    private static final String TAG = "MainPageAdapter";

    private Fragment[] mFragments;

    public MainPageAdapter(FragmentManager fm,Fragment fragments[]) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments == null? 0: mFragments.length;
    }

}
