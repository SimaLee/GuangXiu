package com.simalee.guangxiu.view.technique;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.simalee.guangxiu.data.entity.ProcessItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lee Sima on 2018/5/23.
 */

public class ProcessPageAdapter extends FragmentStatePagerAdapter {

    private List<ProcessItem> mProcessItemList;
    private Map<Integer,Fragment> mCacheFragmentMap;

    public ProcessPageAdapter(FragmentManager fm,List<ProcessItem> items) {
        super(fm);
        mProcessItemList = items;
        mCacheFragmentMap = new HashMap<>(items.size());
    }


    @Override
    public Fragment getItem(int position) {
        Fragment cacheFragment  = mCacheFragmentMap.get(position);
        if (cacheFragment == null){
            cacheFragment = ProcessFragment.getInstance(position,mProcessItemList.get(position));
            mCacheFragmentMap.put(position,cacheFragment);
        }
        return cacheFragment;
    }

    @Override
    public int getCount() {
        return mProcessItemList == null? 0: mProcessItemList.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

}
