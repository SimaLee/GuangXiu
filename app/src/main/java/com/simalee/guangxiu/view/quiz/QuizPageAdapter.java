package com.simalee.guangxiu.view.quiz;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.simalee.guangxiu.data.entity.QuizItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lee Sima on 2018/5/12.
 */

public class QuizPageAdapter extends FragmentStatePagerAdapter {

    List<QuizItem> mQuizItemList;
    Map<Integer,Fragment> mCacheFragmentMap;

    public QuizPageAdapter(FragmentManager fm,List<QuizItem> quizItems) {
        super(fm);
        mQuizItemList = quizItems;
        mCacheFragmentMap = new HashMap<>(mQuizItemList.size());
    }

    @Override
    public Fragment getItem(int position) {
        Fragment cacheFragment  = mCacheFragmentMap.get(position);
        if (cacheFragment == null){
            cacheFragment = QuizFragment.getInstance(position,mQuizItemList.get(position));
            mCacheFragmentMap.put(position,cacheFragment);
        }
        return cacheFragment;
    }

    @Override
    public int getCount() {
        return mQuizItemList.size();
    }
}
