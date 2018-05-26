package com.simalee.guangxiu.view.main;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseActivity;
import com.simalee.guangxiu.view.artist.ArtistFragment;
import com.simalee.guangxiu.view.cartoon.WorksFragment;
import com.simalee.guangxiu.view.teaching.TeachingFragment;

import org.w3c.dom.Text;

/**
 * Created by Lee Sima on 2018/5/22.
 */

public class NewMainActivity extends BaseActivity {

    private static final String TAG = "NewMainActivity";

    private Fragment[] mFragments = {
            IntroductionFragment.getInstance(),
            WorksFragment.getInstance(),
            ArtistFragment.getInstance(),
            TeachingFragment.getInstance(),};

    private String[] names = {"广绣","作品","名家","教学"};

    private final int[] mImages = {
            R.drawable.ic_g_translate_black_24dp,
            R.drawable.ic_assignment_black_24dp,
            R.drawable.ic_account_circle_black_24dp,
            R.drawable.ic_import_contacts_black_24dp
    };

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MainPageAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_main;
    }

    @Override
    protected void initViews() {
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.viewPager);
        mAdapter = new MainPageAdapter(getSupportFragmentManager(),mFragments);

        setUpTabs();
    }

    private void setUpTabs() {
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(2);

        mTabLayout.setupWithViewPager(mViewPager,false);

        //设置底部的tab栏
        int tabCount = mTabLayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {

            View view = LayoutInflater.from(this).inflate(R.layout.tab_main,null);
            ImageView iv_tab = view.findViewById(R.id.iv_tab);
            iv_tab.setImageResource(mImages[i]);
            TextView tv_tab = view.findViewById(R.id.tv_tab);
            tv_tab.setText(names[i]);

            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(view);
        }

        //去掉滑动
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                mViewPager.setCurrentItem(position,false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onBackPressed() {
        if (mVideoBackPressedListener != null){
            //优先响应视频播放界面的回调
            if (mVideoBackPressedListener.onVideoBackPressed()){
                return;
            }
        }
        super.onBackPressed();
    }

    public interface OnVideoBackPressedListener{
        //是否消费返回键事件 返回true 不再传递给上层
        boolean onVideoBackPressed();
    }

    public void setVideoBackPressedListener(OnVideoBackPressedListener videoBackPressedListener) {
        mVideoBackPressedListener = videoBackPressedListener;
    }

    private OnVideoBackPressedListener mVideoBackPressedListener;
}
