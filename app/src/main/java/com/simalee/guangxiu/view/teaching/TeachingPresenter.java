package com.simalee.guangxiu.view.teaching;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.entity.TeachingContentItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zb.yang on 2018/5/10.
 */

public class TeachingPresenter extends BasePresenter<TeachingContract.TeachingTypeView>implements TeachingContract.ITeachingTypePresenter{
    @Override
    public void loadTeachingType() {

    }

    public ArrayList<TeachingContentItem> getVideoListData() {
        ArrayList<TeachingContentItem> videoList = new ArrayList<>();
        videoList.add(new TeachingContentItem("办公室小野开番外了，居然在办公室开澡堂！老板还点赞？",
                98000,
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-17_17-30-43.jpg"
                ,"http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-10_10-20-26.mp4",0));
        videoList.add(new TeachingContentItem("小野在办公室用丝袜做茶叶蛋 边上班边看《外科风云》",
                413000,
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-10_10-09-58.jpg",
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-10_10-20-26.mp4",1));
        videoList.add(new TeachingContentItem("花盆叫花鸡，怀念玩泥巴，过家家，捡根竹竿当打狗棒的小时候",
                439000,
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-03_12-52-08.jpg",
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-03_13-02-41.mp4",2));
        videoList.add(new TeachingContentItem("针织方便面，这可能是史上最不方便的方便面",
                178000,
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/04/2017-04-28_18-18-22.jpg",
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/04/2017-04-28_18-20-56.mp4",3));
        videoList.add(new TeachingContentItem("小野的下午茶，办公室不只有KPI，也有诗和远方",
                450000,
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/04/2017-04-26_10-00-28.jpg",
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/04/2017-04-26_10-06-25.mp4",0));
        videoList.add(new TeachingContentItem("可乐爆米花，嘭嘭嘭......收花的人说要把我娶回家",
                176000,
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/04/2017-04-21_16-37-16.jpg",
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/04/2017-04-21_16-41-07.mp4",1));
        videoList.add(new TeachingContentItem("可乐爆米花，嘭嘭嘭......收花的人说要把我娶回家",
                176000,
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/04/2017-04-21_16-37-16.jpg",
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/04/2017-04-21_16-41-07.mp4",2));
        videoList.add(new TeachingContentItem("可乐爆米花，嘭嘭嘭......收花的人说要把我娶回家",
                176000,
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/04/2017-04-21_16-37-16.jpg",
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/04/2017-04-21_16-41-07.mp4",3));
        videoList.add(new TeachingContentItem("可乐爆米花，嘭嘭嘭......收花的人说要把我娶回家",
                176000,
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/04/2017-04-21_16-37-16.jpg",
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/04/2017-04-21_16-41-07.mp4",1));
        videoList.add(new TeachingContentItem("可乐爆米花，嘭嘭嘭......收花的人说要把我娶回家",
                176000,
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/04/2017-04-21_16-37-16.jpg",
                "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/04/2017-04-21_16-41-07.mp4",0));
        return videoList;
    }
}