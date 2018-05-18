package com.simalee.guangxiu.view.cartoon;

import com.simalee.guangxiu.base.BaseView;
import com.simalee.guangxiu.data.entity.EmbroideryWorkItem;

import java.util.List;

/**
 * Created by zb.yang on 2018/5/13.
 */

public class GalleryContarct  {
    interface GalleryView extends BaseView{
        void showGalleryView(List<EmbroideryWorkItem> list);
    }

    interface GalleryPresenter{
        void loadGalleryView();
    }
}
