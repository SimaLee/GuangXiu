package com.simalee.guangxiu.view.technique;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPFragment;
import com.simalee.guangxiu.data.entity.EmbroideryIntroduction;
import com.simalee.guangxiu.widget.MultiItemContainerNew;

/**
 * Created by Lee Sima on 2018/5/22.
 */

public class EmbroideryFragment extends BaseMVPFragment<EmbroideryPresenter> implements TechniqueContract.EmbroideryView {

    private static final String TAG = "EmbroideryFragment";

    private MultiItemContainerNew mContainer;
    private TabLayout mTabLayout;
    private TextView mNoDataView;

    private static final int INDEX_DAILY = 0;
    private static final int INDEX_APPRECIATE = 1;
    private static final int INDEX_SACRIFICE = 2;


    public EmbroideryFragment() {
        super();
    }

    public static EmbroideryFragment getInstance(){
        EmbroideryFragment instance = new EmbroideryFragment();
        Bundle bundle = new Bundle();
        instance.setArguments(bundle);
        return instance;
    }


    @Override
    public void openIntroduction(String id, String name) {
        //do nothing
    }

    @Override
    public void showEmbroideryIntroduction(EmbroideryIntroduction introduction) {
        if (introduction.getItemList().size() == 0){
            mNoDataView.setVisibility(View.VISIBLE);
        }else{
            mNoDataView.setVisibility(View.GONE);
            mContainer.addItems(introduction.getItemList());
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_embroidery;
    }

    @Override
    protected void initViews(View rootView) {
        mContainer = rootView.findViewById(R.id.container);
        mTabLayout = rootView.findViewById(R.id.tab_type);
        mNoDataView = rootView.findViewById(R.id.tv_no_data);

        addTabs();
    }

    private void addTabs() {
        TabLayout.Tab dailyTab = mTabLayout.newTab();
        dailyTab.setText("日用品");
        mTabLayout.addTab(dailyTab);

        TabLayout.Tab appreciateTab = mTabLayout.newTab();
        appreciateTab.setText("欣赏品");
        mTabLayout.addTab(appreciateTab);

        TabLayout.Tab sacrificeTab = mTabLayout.newTab();
        sacrificeTab.setText("祭祀品");
        mTabLayout.addTab(sacrificeTab);

    }

    @Override
    protected void initListeners() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d(TAG, "onTabSelected: position: " + position);
                clearContainer();
                mPresenter.loadEmbroideryIntroduction(mPresenter.getEmbroideryIdAt(position));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mTabLayout.getTabAt(INDEX_DAILY).select();

    }

    /**
     * 清除当前的内容
     */
    private void clearContainer() {
        mContainer.clear();
    }

    @Override
    protected void initData() {
        mPresenter.loadEmbroideryIntroduction(mPresenter.getEmbroideryIdAt(INDEX_DAILY));
    }

    @Override
    protected void createPresenter() {
        mPresenter = new EmbroideryPresenter();
        mPresenter.attachView(this);
    }
}
