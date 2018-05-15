package com.simalee.guangxiu.view.cartoon;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.data.entity.ThemeFilterItem;
import com.simalee.guangxiu.data.entity.UseWorkFilterItem;

import java.util.ArrayList;

/**
 * 属性选择的布局及逻辑
 */
public class RightSideslipLay extends RelativeLayout {
    private static final String TAG = "RightSideslipLay";
    private Context mCtx;

    private View contentView;
    private RecyclerView useRCV;
    private RecyclerView themeRCV;
    private Button resetBtn;
    private Button sureBtn;
    private ThemeFilterAdapter themeFilterAdapter;
    private UseFilterAdapter useFilterAdapter;
    private ArrayList<ThemeFilterItem> themeFilterItems;
    private ArrayList<UseWorkFilterItem> useWorkFilterItems;
    private SureClickListener sureClickListener;


    public RightSideslipLay(Context context) {
        super(context);
        mCtx = context;
        inflateView();
        initData();
        initListener();
    }

    private void inflateView() {
        contentView = View.inflate(mCtx, R.layout.drawer_content, this);
        useRCV = (RecyclerView)contentView.findViewById(R.id.useRCV);
        themeRCV = (RecyclerView)contentView.findViewById(R.id.themeRCV);
        resetBtn = (Button)findViewById(R.id.resetBtn);
        sureBtn = (Button)findViewById(R.id.sureBtn);
    }

    private void initData(){
        themeFilterItems = new ArrayList<>();
        for(int i = 0;i<ThemeFilterItem.themeTypeNameArrays.length;i++){
            ThemeFilterItem item = new ThemeFilterItem(i);
            themeFilterItems.add(item);
        }
        useWorkFilterItems = new ArrayList<>();
        for(int i = 0;i<UseWorkFilterItem.filterNames.length;i++){
            UseWorkFilterItem item = new UseWorkFilterItem(i);
            useWorkFilterItems.add(item);
        }
        themeFilterAdapter = new ThemeFilterAdapter(mCtx,themeFilterItems);
        useFilterAdapter = new UseFilterAdapter(mCtx,useWorkFilterItems);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mCtx,3);
        themeRCV.setLayoutManager(gridLayoutManager);
        themeRCV.setAdapter(themeFilterAdapter);
        GridLayoutManager gridLayoutManagerForUse = new GridLayoutManager(mCtx,3);
        useRCV.setLayoutManager(gridLayoutManagerForUse);
        useRCV.setAdapter(useFilterAdapter);
    }

    private void initListener(){
        resetBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                themeFilterAdapter.resetItemList();
                useFilterAdapter.resetItemList();
            }
        });

        sureBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sureClickListener!=null){
                    sureClickListener.sureClickListener(useFilterAdapter.getFilterItems(),themeFilterAdapter.getFilterItems());
                }
            }
        });
    }

    public void setSureClickListener(SureClickListener sureClickListener){
        if(sureClickListener!=null){
            this.sureClickListener = sureClickListener;
        }
    }

    public interface SureClickListener{
        void sureClickListener(ArrayList<UseWorkFilterItem> useWorkFilterItems,ArrayList<ThemeFilterItem> themeFilterItems);
    }
}
