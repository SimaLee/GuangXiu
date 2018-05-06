package com.simalee.guangxiu.base;

/**
 * Created by Lee Sima on 2018/4/24.
 */

public class BasePresenter<V extends BaseView>{

    protected V mView;

    /**
     * 绑定View 一般在初始化的时候调用
     * @param mvpView
     */
    public void attachView(V mvpView){
        this.mView = mvpView;
    }

    /**
     * 解除绑定 一般在onDestroy方法中调用
     */
    public void detachView(){
        this.mView = null;
    }

    /**
     * 是否与view关联 在执行回调之前需要判断关联的view是否处于生命周期
     * @return
     */
    public boolean isViewAttached(){
        return mView != null;
    }

    public V getView(){
        return mView;
    }
}
