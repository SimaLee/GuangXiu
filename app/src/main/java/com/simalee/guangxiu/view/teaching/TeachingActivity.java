package com.simalee.guangxiu.view.teaching;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.TeachingContentItem;
import com.simalee.guangxiu.data.entity.TeachingTypeItem;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by zb.yang on 2018/5/10.
 */

public class TeachingActivity extends BaseMVPActivity<TeachingPresenter>implements TeachingContract.TeachingTypeView ,TeachingTypeAdapter.SelectTypeBtnClickListener{
    public static final String TAG = "TeachingActivity";

    private ArrayList<TeachingTypeItem> mTeachingTypeItems;
    private ArrayList<TeachingContentItem> mTeachingContentItems;
    private HashMap<Integer,ArrayList<TeachingContentItem>> mTeachingContentItemHashMap;
    private RecyclerView mTeachingTypeRCV;
    private RecyclerView mTeachingContentRCV;
    private VideoAdapter videoAdapter;
    private TeachingTypeAdapter teachingTypeAdapter;

    @Override
    public void showTeachingType(List<TeachingContentItem> data) {
        organizeData(data);
//        TeachingContentItem teachingContentItem = data.get(0);
//        Log.i(TAG,teachingContentItem.getCoverUrl());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_teaching_type;
    }

    @Override
    protected void initViews() {
        mTeachingTypeRCV = (RecyclerView)findViewById(R.id.teachingTypeRCV);
        mTeachingContentRCV = (RecyclerView)findViewById(R.id.teachingContentRCV);
        mTeachingContentItemHashMap = new HashMap<>();
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {
        mTeachingTypeItems = new ArrayList<>();
        mTeachingContentItems = new ArrayList<>();
        TeachingTypeItem teachingTypeItem = new TeachingTypeItem(true,0);
        mTeachingTypeItems.add(teachingTypeItem);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mTeachingTypeRCV.setLayoutManager(linearLayoutManager);

        mTeachingContentRCV.setLayoutManager(new LinearLayoutManager(this));
        mTeachingContentRCV.setHasFixedSize(true);

//        organizeData(mPresenter.getVideoListData());

        teachingTypeAdapter = new TeachingTypeAdapter(this,mTeachingTypeItems);
        mTeachingTypeRCV.setAdapter(teachingTypeAdapter);
        teachingTypeAdapter.setTypeBtnClickListener(this);

        videoAdapter = new VideoAdapter(this, mTeachingContentItems);
        mTeachingContentRCV.setAdapter(videoAdapter);
        mTeachingContentRCV.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(RecyclerView.ViewHolder holder) {
                NiceVideoPlayer niceVideoPlayer = ((VideoAdapter.VideoHolder) holder).mVideoPlayer;
                if (niceVideoPlayer == NiceVideoPlayerManager.instance().getCurrentNiceVideoPlayer()) {
                    NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
                }
            }
        });

        mPresenter.loadTeachingType();
    }

    private void organizeData(List<TeachingContentItem> list){
        if(list == null || list.size() <=0){
            return;
        }
        Log.i(TAG,"data list size is "+ list.size());
        for(int i = 0;i<list.size();i++){
            TeachingContentItem teachingContentItem = list.get(i);
            int type = teachingContentItem.getVideoType() ;
            Log.i(TAG,"type = " + type);
            ArrayList<TeachingContentItem> itemList = mTeachingContentItemHashMap.get(type);
            if(itemList == null){
                Log.i(TAG,"create new Arraylist");
                ArrayList<TeachingContentItem> newList = new ArrayList<>();
                newList.add(teachingContentItem);
                mTeachingContentItemHashMap.put(type,newList);
            }else{
                itemList.add(teachingContentItem);
            }
        }
        Set<Integer> typeSet = mTeachingContentItemHashMap.keySet();

        Log.i(TAG,"typeSet size is "+ typeSet.size());
        for(Integer integer: typeSet){
            Log.i(TAG,"add TeachingYpeItem");
            TeachingTypeItem teachingTypeItem = new TeachingTypeItem(false,integer+1);
            mTeachingTypeItems.add(teachingTypeItem);
            mTeachingContentItems.addAll(mTeachingContentItemHashMap.get(integer));
        }

        videoAdapter.setmTeachContentList(mTeachingContentItems);
        teachingTypeAdapter.setTeachingTypeItems(mTeachingTypeItems);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new TeachingPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 在onStop时释放掉播放器
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }
    @Override
    public void onBackPressed() {
        // 在全屏或者小窗口时按返回键要先退出全屏或小窗口，
        // 所以在Activity中onBackPress要交给NiceVideoPlayer先处理。
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }

    @Override
    public void selectTypeBtnClickListener(int position) {
        if(position == teachingTypeAdapter.getCurrentPosition()){
            return;
        }

        for(int i = 0;i<mTeachingTypeItems.size();i++){
            TeachingTypeItem teachingTypeItem = mTeachingTypeItems.get(i);
            if(i==position){
                teachingTypeItem.setClick(true);
            }else{
                teachingTypeItem.setClick(false);
            }
        }


        if(position == 0){
            Set<Integer> typeSet = mTeachingContentItemHashMap.keySet();
            mTeachingContentItems = new ArrayList<>();
            for(Integer integer: typeSet){
                mTeachingContentItems.addAll(mTeachingContentItemHashMap.get(integer));
            }
        }else{
            mTeachingContentItems = mTeachingContentItemHashMap.get(position-1);
        }
        Log.i(TAG,"mTeachingContentItems size is "+ mTeachingContentItems.size());

        teachingTypeAdapter.notifyDataSetChanged();
        videoAdapter.setmTeachContentList(mTeachingContentItems);
    }
}
