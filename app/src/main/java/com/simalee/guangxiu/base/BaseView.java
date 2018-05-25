package com.simalee.guangxiu.base;

/**
 * Created by Lee Sima on 2018/4/24.
 */

public interface BaseView {

     /**
      * 显示加载动画
      */
     void showLoading();

     /**
      * 隐藏加载动画
      */
     void hideLoading();

     /**
      * 显示错误信息
      * @param msg
      */
     void showErrorMsg(String msg);

}
