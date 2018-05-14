package com.simalee.guangxiu.view.cartoon;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.utils.UiUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性选择的布局及逻辑
 */
public class RightSideslipLay extends RelativeLayout {
    private Context mCtx;

    public RightSideslipLay(Context context) {
        super(context);
        mCtx = context;
        inflateView();
    }

    private void inflateView() {
        View.inflate(getContext(), R.layout.drawer_content, this);
    }

}
