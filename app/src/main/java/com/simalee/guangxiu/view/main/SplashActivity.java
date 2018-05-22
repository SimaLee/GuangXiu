package com.simalee.guangxiu.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.simalee.guangxiu.R;

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
    }
}
