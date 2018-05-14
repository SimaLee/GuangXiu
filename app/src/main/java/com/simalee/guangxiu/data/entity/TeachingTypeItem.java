package com.simalee.guangxiu.data.entity;

/**
 * Created by zb.yang on 2018/5/11.
 */

public class TeachingTypeItem {
    public static String[] typeNameArray = {"全部","针法介绍","工艺流程","具体教学","名家会晤"};

    private boolean isClick = false;
    private String typeName = "";


    public TeachingTypeItem(boolean isClick, int type) {
        super();
        if(type>=typeNameArray.length){
            return;
        }
        this.isClick = isClick;
        this.typeName = typeNameArray[type];
    }


    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


}
