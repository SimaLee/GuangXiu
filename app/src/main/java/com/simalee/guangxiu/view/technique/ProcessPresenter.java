package com.simalee.guangxiu.view.technique;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.entity.ProcessItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/23.
 */

public class ProcessPresenter extends BasePresenter<ProcessContract.ProcessView> implements ProcessContract.IProcessPresenter {
    private static final String TAG = "ProcessPresenter";

    public ProcessPresenter(){

    }

    @Override
    public void loadProcessItemList() {
        if (isViewAttached()){
            mView.showProcessItemList(fakePrecessItemList());
        }
    }

    private List<ProcessItem> fakePrecessItemList() {
        List<ProcessItem> result = new ArrayList<>();

        ProcessItem item = new ProcessItem();
        item.setName("设计");
        result.add(item);

        ProcessItem item1 = new ProcessItem();
        item1.setName("上稿");
        result.add(item1);

        ProcessItem item2 = new ProcessItem();
        item2.setName("上绣架");
        result.add(item2);

        return result;
    }

    @Override
    public void loadPreProcess() {
        if (isViewAttached()){
            mView.showPreProcess();
        }
    }

    @Override
    public void loadNextProcess() {
        if (isViewAttached()){
            mView.showNextProcess();
        }
    }
}
