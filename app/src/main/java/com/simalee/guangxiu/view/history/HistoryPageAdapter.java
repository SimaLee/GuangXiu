package com.simalee.guangxiu.view.history;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Lee Sima on 2018/5/22.
 */

public class HistoryPageAdapter extends FragmentPagerAdapter {

    private static final String TAG = "HistoryPageAdapter";

    private Fragment[] mFragments;
    private String[] mTitles;

    public HistoryPageAdapter(FragmentManager fm,Fragment[] fragments,String[] titles) {
        super(fm);
        mFragments = fragments;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0: mFragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
