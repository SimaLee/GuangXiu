package com.simalee.guangxiu.view.technique;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseFragment;
import com.simalee.guangxiu.data.entity.ProcessItem;
import com.simalee.guangxiu.widget.MultiItemContainerNew;

/**
 * Created by Lee Sima on 2018/5/23.
 */

public class ProcessFragment extends BaseFragment {
    private static final String TAG = "ProcessFragment";


    private static final String KEY_INDEX = "key_index";
    private static final String KEY_ITEM = "key_item";


    private int mProcessIndex;
    private ProcessItem mProcessItem;

    private TextView mTitleView;
    private MultiItemContainerNew mContainer;

    public ProcessFragment() {
        super();
    }

    public static ProcessFragment getInstance(int position,ProcessItem processItem){
        ProcessFragment instance = new ProcessFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_INDEX,position);
        bundle.putSerializable(KEY_ITEM,processItem);
        instance.setArguments(bundle);
        return instance;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            mProcessIndex = getArguments().getInt(KEY_INDEX);
            mProcessItem = (ProcessItem) getArguments().getSerializable(KEY_ITEM);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: index:" + mProcessIndex);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_process;
    }

    @Override
    protected void initViews(View rootView) {
        mTitleView = rootView.findViewById(R.id.tv_title);
        mContainer = rootView.findViewById(R.id.container);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {
        if (mProcessItem == null){
            return;
        }
        mTitleView.setText(mProcessItem.getName());

        if (mProcessItem.getItemList() != null){

            mContainer.replaceItems(mProcessItem.getItemList());
        }
    }
}
