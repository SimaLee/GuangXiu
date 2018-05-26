package com.simalee.guangxiu.widget;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/26.
 */

public interface IContainer<T> {

    /**
     * 往容器内添加item列表
     * @param itemList
     */
    void addItems(List<T> itemList);

    /**
     * 往容器内添加item
     * @param item
     */
    void addItem(T item);

    /**
     * 将当前容器内的数据替换为itemList
     * @param itemList
     */
    void replaceItems(List<T> itemList);

    /**
     * 清空容器内的item
     */
    void clear();
}
