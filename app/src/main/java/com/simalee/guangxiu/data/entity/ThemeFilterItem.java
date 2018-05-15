package com.simalee.guangxiu.data.entity;

/**
 * Created by zb.yang on 2018/5/14.
 */

public class ThemeFilterItem  {
    public static String[] themeTypeNameArrays = {"花鸟","动物","风景","人物","瓷器","书法","礼品"};
    private String typeName;
    private int type;
    private boolean isClick = false;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }

    public ThemeFilterItem(int type) {
        super();
        if(type>=themeTypeNameArrays.length || type<0){
            return;
        }
        this.type = type;
        typeName = themeTypeNameArrays[type];
    }

}
