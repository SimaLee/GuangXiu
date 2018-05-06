package com.simalee.guangxiu.data.model;

/**
 * Created by Lee Sima on 2018/5/1.
 */

public interface DataCallback<T> {

    /**
     * 获取数据成功时的回调
     * @param data 返回的数据
     */
    void onSuccess(T data);

    /**
     * 请求成功，由于msgCode导致无法返回正常数据
     * @param msg
     */
    void onFailure(String msg);

    /**
     * 请求数据失败，指在请求网络API接口请求方式时，出现无法联网、
     * 缺少权限，内存泄露等原因导致无法连接到请求数据源。
     */
    void onError();
}
