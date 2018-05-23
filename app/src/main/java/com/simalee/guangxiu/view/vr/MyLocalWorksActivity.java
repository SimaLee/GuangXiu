package com.simalee.guangxiu.view.vr;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.LocalEmbroideryWork;
import com.simalee.guangxiu.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by zb.yang on 2018/5/22.
 */

public class MyLocalWorksActivity extends BaseMVPActivity<MyLocalWorksPresenter> implements MyLocalWorksContract.MyLocalWorksView {
    private static final String TAG = "MyLocalWorksActivity";

    private ImageView addWorksIV;
    private RecyclerView mLocalWorksRec;
    private TextView noWorksTV;

    private List<LocalEmbroideryWork> mLocalEmbtoideryWorks;
    private MyLocalWorksAdapter myLocalWorksAdapter;
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showMyLocalWorksView(List<LocalEmbroideryWork> data) {
        if(data != null) {
            Log.i(TAG,data.toString());
            mLocalEmbtoideryWorks =data;
            myLocalWorksAdapter.setEmbroideryWorkItems(data);
        }else{

        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_local_works;
    }

    @Override
    protected void initViews() {
        addWorksIV = (ImageView)findViewById(R.id.addWorksIv);
        mLocalWorksRec = (RecyclerView)findViewById(R.id.localWorksRCV);
        noWorksTV = (TextView)findViewById(R.id.noWorksTV);
        mLocalWorksRec.setLayoutManager(new LinearLayoutManager(MyLocalWorksActivity.this));
        mLocalEmbtoideryWorks = new ArrayList<>();
        myLocalWorksAdapter = new MyLocalWorksAdapter(MyLocalWorksActivity.this,mLocalEmbtoideryWorks);
        mLocalWorksRec.setAdapter(myLocalWorksAdapter);
    }

    @Override
    protected void initListeners() {
        addWorksIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopUpWindow();
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.loadMyLocalWorksView();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new MyLocalWorksPresenter();
        mPresenter.attachView(this);
    }


    private void showPopUpWindow() {

        View contentView = LayoutInflater.from(MyLocalWorksActivity.this).inflate(R.layout.popupwindow_image_type, null);
        final PopupWindow mPopWindow = new PopupWindow(contentView,
                WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        mPopWindow.setContentView(contentView);
        //设置点击空白地方消失
        mPopWindow.setFocusable(true);
        mPopWindow.setBackgroundDrawable(new BitmapDrawable());
        //设置空白地方的背景色
        WindowManager.LayoutParams lp = MyLocalWorksActivity.this.getWindow().getAttributes();
        lp.alpha = 0.6f;
        MyLocalWorksActivity.this.getWindow().setAttributes(lp);
        //设置popupWindow消失的时候做的事情 即把背景色恢复
        mPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp =  MyLocalWorksActivity.this.getWindow().getAttributes();
                lp.alpha = 1f;
                MyLocalWorksActivity.this.getWindow().setAttributes(lp);
            }
        });

        Button bt_panorama = (Button) contentView.findViewById(R.id.bt_panorama);
        Button bt_photo = (Button) contentView.findViewById(R.id.bt_photo);

        bt_panorama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyLocalWorksActivity.this,AddEmbroideryWorkActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(AddEmbroideryWorkActivity.KEY,LocalEmbroideryWork.PANO_TYPE);
                intent.putExtras(bundle);
                startActivity(intent);
                mPopWindow.dismiss();
            }
        });

        bt_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyLocalWorksActivity.this,AddEmbroideryWorkActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(AddEmbroideryWorkActivity.KEY,LocalEmbroideryWork.PHOTO_TYPE);
                intent.putExtras(bundle);
                startActivity(intent);
                mPopWindow.dismiss();
            }
        });

        //显示PopupWindow
        View rootview = LayoutInflater.from( MyLocalWorksActivity.this).inflate(R.layout.activity_my_local_works, null);
        mPopWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
    }
}
