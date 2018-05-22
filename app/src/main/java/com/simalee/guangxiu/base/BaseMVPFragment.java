package com.simalee.guangxiu.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Lee Sima on 2018/5/22.
 */

public abstract class BaseMVPFragment<P extends BasePresenter> extends Fragment {

    private static final String TAG = "BaseMVPFragment";

    protected Context mContext;
    protected P mPresenter;

    //Fragment是否可见
    private boolean isUIVisible;
    //onViewCreated是否执行完毕
    private boolean isViewCreated;

    public BaseMVPFragment(){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(),container,false);
        //控件初始化
        initViews(rootView);
        initListeners();

        isViewCreated = true;

        lazyLoad();

        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            isUIVisible = true;
            lazyLoad();

            onFragmentVisible(isVisibleToUser);

        }else{
            isUIVisible = false;
            onFragmentVisible(isVisibleToUser);
        }
    }

    /**
     * 在Fragment 是否可见时的处理函数
     * @param isVisibleToUser
     */
    protected void onFragmentVisible(boolean isVisibleToUser){
        //do nothing
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }


    /**
     * 防止数据重复加载
     */
    private void lazyLoad() {

        if (isUIVisible && isViewCreated){

            initData();

            isUIVisible = false;
            isViewCreated = false;
        }

    }


    /**
     * @return 获取layoutid
     */
    protected abstract  int getLayoutId();

    /**
     * 完成view的初始化
     */
    protected abstract void initViews(View rootView);

    /**
     * 完成事件的绑定
     */
    protected abstract void initListeners();

    /**
     * 完成数据的初始化 在onResume中被调用
     */
    protected abstract void initData();

    /**
     * 创建presenter
     */
    protected abstract void createPresenter();
}
