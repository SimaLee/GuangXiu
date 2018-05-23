package com.simalee.guangxiu.view.teaching;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPFragment;
import com.simalee.guangxiu.data.entity.TeachingContentItem;
import com.simalee.guangxiu.data.entity.TeachingTypeItem;
import com.simalee.guangxiu.view.main.NewMainActivity;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by Lee Sima on 2018/5/22.
 */

public class TeachingFragment extends BaseMVPFragment<TeachingPresenter> implements TeachingContract.TeachingTypeView,TeachingTypeAdapter.SelectTypeBtnClickListener,NewMainActivity.OnVideoBackPressedListener {

    private static final String TAG = "TeachingFragment";


    private ArrayList<TeachingTypeItem> mTeachingTypeItems;
    private ArrayList<TeachingContentItem> mTeachingContentItems;
    private HashMap<Integer,ArrayList<TeachingContentItem>> mTeachingContentItemHashMap;
    private RecyclerView mTeachingTypeRCV;
    private RecyclerView mTeachingContentRCV;
    private VideoAdapter videoAdapter;
    private TeachingTypeAdapter teachingTypeAdapter;

    public TeachingFragment() {
        super();
    }

    public static TeachingFragment getInstance(){
        TeachingFragment instance = new TeachingFragment();
        Bundle bundle = new Bundle();
        instance.setArguments(bundle);
        return instance;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof NewMainActivity){
            ((NewMainActivity) context).setVideoBackPressedListener(this);
        }
    }

    @Override
    protected void onFragmentVisible(boolean isVisibleToUser) {
        if (!isVisibleToUser){
            Log.d(TAG, "onFragmentVisible: suspend video");
            NiceVideoPlayerManager.instance().suspendNiceVideoPlayer();
        }
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
    public void showTeachingType(List<TeachingContentItem> data) {
        organizeData(data);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_teaching_type;
    }

    @Override
    protected void initViews(View rootView) {
        mTeachingTypeRCV = (RecyclerView)rootView.findViewById(R.id.teachingTypeRCV);
        mTeachingContentRCV = (RecyclerView)rootView.findViewById(R.id.teachingContentRCV);
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mTeachingTypeRCV.setLayoutManager(linearLayoutManager);

        mTeachingContentRCV.setLayoutManager(new LinearLayoutManager(mContext));
        mTeachingContentRCV.setHasFixedSize(true);

//        organizeData(mPresenter.getVideoListData());

        teachingTypeAdapter = new TeachingTypeAdapter(mContext,mTeachingTypeItems);
        mTeachingTypeRCV.setAdapter(teachingTypeAdapter);
        teachingTypeAdapter.setTypeBtnClickListener(this);

        videoAdapter = new VideoAdapter(mContext, mTeachingContentItems);
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

    @Override
    protected void createPresenter() {
        mPresenter = new TeachingPresenter();
        mPresenter.attachView(this);
    }


    private void organizeData(List<TeachingContentItem> list){
        if(list == null || list.size() <=0){
            return;
        }
        mTeachingContentItemHashMap = new HashMap<>();
        mTeachingContentItems = new ArrayList<>();
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
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
        // 在onStop时释放掉播放器
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
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

    @Override
    public boolean onVideoBackPressed() {
        if (!isVisible()){
            return false;
        }
        return NiceVideoPlayerManager.instance().onBackPressd();
    }
}
