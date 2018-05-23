package com.simalee.guangxiu.view.technique;

import com.simalee.guangxiu.base.BaseView;
import com.simalee.guangxiu.data.entity.ProcessItem;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/23.
 */

public interface ProcessContract {

    interface ProcessView extends BaseView{
        void showProcessItemList(List<ProcessItem> processItemList);
        void showPreProcess();
        void showNextProcess();
    }

    interface IProcessPresenter{
        void loadProcessItemList();
        void loadPreProcess();
        void loadNextProcess();
    }
}
