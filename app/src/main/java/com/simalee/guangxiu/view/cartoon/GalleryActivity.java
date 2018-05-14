package com.simalee.guangxiu.view.cartoon;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simalee.guangxiu.R;

/**
 * Created by zb.yang on 2018/5/13.
 */

public class GalleryActivity extends AppCompatActivity {
    public static final String TAG = "GalleryActivity";

    private DrawerLayout drawer;
    private LinearLayout navigationView;
    private RightSideslipLay menuHeaderView;
    private TextView mFrameTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (LinearLayout) findViewById(R.id.navView);
        mFrameTv = (TextView) findViewById(R.id.screenTv);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);

        menuHeaderView = new RightSideslipLay(GalleryActivity.this);
        navigationView.addView(menuHeaderView);
        mFrameTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openMenu();
            }
        });

    }

    public void closeMenu() {
        drawer.closeDrawer(GravityCompat.END);
    }

    public void openMenu() {
        drawer.openDrawer(GravityCompat.END);
    }
}
