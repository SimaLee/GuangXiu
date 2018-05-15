package com.simalee.guangxiu.data.entity;

/**
 * Created by zb.yang on 2018/5/14.
 */

public class UseWorkFilterItem {
    public static String[] filterNames = {"日用品","欣赏品","祭祀用品"};
    private String filterName;
    private int type;
    private boolean isClicked = false;

    public UseWorkFilterItem(int type) {
        super();
        if(type>=filterNames.length || type<0)
            return;
        this.type = type;
        filterName = filterNames[type];
    }

    public static String[] getFilterNames() {
        return filterNames;
    }

    public static void setFilterNames(String[] filterNames) {
        UseWorkFilterItem.filterNames = filterNames;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

}
