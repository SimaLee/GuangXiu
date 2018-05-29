package com.simalee.guangxiu.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.data.DataManager;
import com.simalee.guangxiu.data.entity.Version;
import com.simalee.guangxiu.data.model.DataCallback;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

/**
 * Created by Lee Sima on 2018/5/22.
 */

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity";

    private TextView mView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mView = findViewById(R.id.tv_welcome);
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this,NewMainActivity.class);
                startActivity(intent);
            }
        });
        //启动数据库连接 用于调试数据库
        SQLiteStudioService.instance().start(this);
        DataManager.getInstance().getVersionCode(new DataCallback<Version>() {
            @Override
            public void onSuccess(Version data) {
                Log.d(TAG, "onSuccess: 获取版本号成功");
            }

            @Override
            public void onFailure(String msg) {

            }

            @Override
            public void onError() {

            }
        });

    }
}
