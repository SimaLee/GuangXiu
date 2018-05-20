package com.simalee.guangxiu.view.cartoon;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.EmbroideryWorkItem;
import com.simalee.guangxiu.data.entity.ThemeFilterItem;
import com.simalee.guangxiu.data.entity.UseWorkFilterItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zb.yang on 2018/5/13.
 */

public class GalleryActivity extends BaseMVPActivity<GalleryPresenter> implements GalleryContarct.GalleryView, RightSideslipLay.SureClickListener{
    public static final String TAG = "GalleryActivity";

    private DrawerLayout drawer;
    private LinearLayout navigationView;
    private RightSideslipLay menuHeaderView;
    private ImageView mFrameTv;
    private RecyclerView worksRCV;

    private ArrayList<EmbroideryWorkItem> mEmbroideryWorkItems;
    private GalleryAdapter mGalleryAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_gallery;
    }

    @Override
    protected void initViews() {
        worksRCV = (RecyclerView)findViewById(R.id.worksRCV);
        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (LinearLayout) findViewById(R.id.navView);
        mFrameTv = (ImageView) findViewById(R.id.filterIv);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);

        menuHeaderView = new RightSideslipLay(GalleryActivity.this);
        navigationView.addView(menuHeaderView);
        worksRCV.setLayoutManager(new LinearLayoutManager(GalleryActivity.this));
        mEmbroideryWorkItems = new ArrayList<>();
        mGalleryAdapter = new GalleryAdapter(GalleryActivity.this,mEmbroideryWorkItems);
        worksRCV.setAdapter(mGalleryAdapter);
    }

    @Override
    protected void initListeners() {
        mFrameTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });
        menuHeaderView.setSureClickListener(this);
    }

    @Override
    protected void initData() {
       mPresenter.loadGalleryView();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new GalleryPresenter();
        mPresenter.attachView(this);
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
    public void showGalleryView(List<EmbroideryWorkItem> list) {
        mEmbroideryWorkItems = (ArrayList<EmbroideryWorkItem>)list;
        mGalleryAdapter.setEmbroideryWorkItems(mEmbroideryWorkItems);
    }

    public void closeMenu() {
        drawer.closeDrawer(GravityCompat.END);
    }

    public void openMenu() {
        drawer.openDrawer(GravityCompat.END);
    }

    @Override
    public void sureClickListener(ArrayList<UseWorkFilterItem> useWorkFilterItems, ArrayList<ThemeFilterItem> themeFilterItems) {
        closeMenu();
        Log.i(TAG,"sureClickListener-----");
        ArrayList<EmbroideryWorkItem> embroideryWorkItems = new ArrayList<>();
        int clickSize = 0;
        for(int i = 0;i<mEmbroideryWorkItems.size();i++){
            boolean isBreak = false;
            EmbroideryWorkItem item = mEmbroideryWorkItems.get(i);
            for(int j = 0;j<useWorkFilterItems.size();j++){
                UseWorkFilterItem useWorkFilterItem = useWorkFilterItems.get(j);
                if(!useWorkFilterItem.isClicked()){
                    continue;
                }
                clickSize++;
                if(item.isUseType(useWorkFilterItem.getType())){
                   embroideryWorkItems.add(item);
                   isBreak = true;
                   break;
                }else{
                   continue;
                }
            }
            if(isBreak){
                continue;
            }
            for(int z = 0;z<themeFilterItems.size();z++){
                ThemeFilterItem themeFilterItem = themeFilterItems.get(z);
                if(!themeFilterItem.isClick()){
                    continue;
                }
                clickSize++;
                if(item.isThemeType(themeFilterItem.getType())){
                    embroideryWorkItems.add(item);
                    break;
                }else{
                    continue;
                }
            }
        }
        if(clickSize == 0){
            embroideryWorkItems = mEmbroideryWorkItems;
        }
        mGalleryAdapter.setEmbroideryWorkItems(embroideryWorkItems);
    }
}
