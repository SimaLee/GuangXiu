package com.simalee.guangxiu.view.technique;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPFragment;
import com.simalee.guangxiu.data.entity.PergolaIntroduction;
import com.simalee.guangxiu.data.entity.StitchIntroduction;
import com.simalee.guangxiu.data.entity.ThreadItem;
import com.simalee.guangxiu.widget.MultiItemContainerNew;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/22.
 */

public class MaterialFragment extends BaseMVPFragment<MaterialPresenter> implements TechniqueContract.MaterialView {
    private static final String TAG = "MaterialFragment";

    private static final int INDEX_PERGOLA = 0;
    private static final int INDEX_NEEDLE = 1;
    private static final int INDEX_THREAD = 2;


    private MultiItemContainerNew mPergolaContainer;//
    private MultiItemContainerNew mNeedleContainer;//
    private RecyclerView mRecyclerView;//绣线单独的容器
    private TabLayout mTabLayout;
    private TextView mNoDataView;

    private ThreadListAdapter mThreadListAdapter;

    public MaterialFragment(){
        super();
    }
    public static MaterialFragment getInstance(){
        MaterialFragment instance = new MaterialFragment();
        Bundle bundle = new Bundle();
        instance.setArguments(bundle);
        return instance;
    }


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
    public void onPergolaClick() {

    }

    @Override
    public void onStitchClick() {

    }

    @Override
    public void onThreadClick() {

    }

    @Override
    public void showPergolaIntroduction(PergolaIntroduction introduction) {

        changeViewVisibility(INDEX_PERGOLA);

        if (introduction.getItemList() == null || introduction.getItemList().size() == 0){
            mNoDataView.setVisibility(View.VISIBLE);
        }else{
            mNoDataView.setVisibility(View.INVISIBLE);
            mPergolaContainer.replaceItems(introduction.getItemList());
        }
    }

    @Override
    public void showStitchIntroduction(StitchIntroduction introduction) {

        changeViewVisibility(INDEX_NEEDLE);

        if (introduction.getItemList() == null || introduction.getItemList().size() == 0){
            mNoDataView.setVisibility(View.VISIBLE);
        }else{
            mNoDataView.setVisibility(View.INVISIBLE);
            mNeedleContainer.replaceItems(introduction.getItemList());
        }
    }

    @Override
    public void showThreadList(List<ThreadItem> threadItemList) {
        changeViewVisibility(INDEX_THREAD);
        if (threadItemList == null || threadItemList.size() == 0){
            mNoDataView.setVisibility(View.VISIBLE);
        }else{
            mNoDataView.setVisibility(View.INVISIBLE);
            mThreadListAdapter.replaceData(threadItemList);
        }
    }

    private void changeViewVisibility(int index) {
        if (INDEX_PERGOLA == index){
            mPergolaContainer.setVisibility(View.VISIBLE);
            mNeedleContainer.setVisibility(View.INVISIBLE);
            mRecyclerView.setVisibility(View.INVISIBLE);
            return;
        }

        if (INDEX_NEEDLE == index){
            mPergolaContainer.setVisibility(View.INVISIBLE);
            mNeedleContainer.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.INVISIBLE);
            return;
        }

        if (INDEX_THREAD == index){
            mPergolaContainer.setVisibility(View.INVISIBLE);
            mNeedleContainer.setVisibility(View.INVISIBLE);
            mRecyclerView.setVisibility(View.VISIBLE);
            return;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_material;
    }

    @Override
    protected void initViews(View rootView) {
        mPergolaContainer = rootView.findViewById(R.id.container_pergola);
        mNeedleContainer = rootView.findViewById(R.id.container_needle);
        mRecyclerView = rootView.findViewById(R.id.rv_thread_list);
        mNoDataView = rootView.findViewById(R.id.tv_no_data);
        mTabLayout = rootView.findViewById(R.id.tab_type);

        mThreadListAdapter = new ThreadListAdapter(mContext,new ArrayList<ThreadItem>());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mThreadListAdapter);

        addTabs();

    }

    private void addTabs() {
        TabLayout.Tab pergolaTab = mTabLayout.newTab();
        pergolaTab.setText("花架介绍");
        mTabLayout.addTab(pergolaTab);

        TabLayout.Tab needleTab = mTabLayout.newTab();
        needleTab.setText("绣针介绍");
        mTabLayout.addTab(needleTab);

        TabLayout.Tab threadTab = mTabLayout.newTab();
        threadTab.setText("绣线介绍");
        mTabLayout.addTab(threadTab);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d(TAG, "onTabSelected: "+ position);
                handleTabSelected(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void handleTabSelected(int position) {
        Log.d(TAG, "handleTabSelected: position " + position);
        if (INDEX_PERGOLA == position){
            changeViewVisibility(INDEX_PERGOLA);
            mPresenter.loadPergolaIntroduction();
            return;
        }

        if (INDEX_NEEDLE == position){
            changeViewVisibility(INDEX_NEEDLE);
            mPresenter.loadStitchIntroduction();
            return;
        }

        if (INDEX_THREAD == position){
            changeViewVisibility(INDEX_THREAD);
            mPresenter.loadThreadList();
            return;
        }
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {
        mPresenter.loadPergolaIntroduction();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new MaterialPresenter();
        mPresenter.attachView(this);
    }
}
