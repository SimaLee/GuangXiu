package com.simalee.guangxiu.view.main;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

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

    private TextView mTipsView;
    private VideoView mVideoView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        initViews();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!mVideoView.isPlaying()){
            mVideoView.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mVideoView.canPause()){
            mVideoView.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopPlayVideo();
    }

    private void initViews() {
        mTipsView = findViewById(R.id.tv_welcome);
        mTipsView.setVisibility(View.INVISIBLE);
        mTipsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });

        mVideoView = findViewById(R.id.video_introduction);
        setupVideoView();
    }

    private void startMainActivity() {
        Intent intent = new Intent(SplashActivity.this,NewMainActivity.class);
        startActivity(intent);
        this.finish();
    }

    private void setupVideoView() {

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.d(TAG, "onPrepared: ");
            }
        });

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.d(TAG, "onCompletion: ");
                stopPlayVideo();
                startMainActivity();
            }
        });

        mVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Log.d(TAG, "onError: ");
                stopPlayVideo();
                return true;
            }
        });
        //使用本地的uri
        Uri introductionUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.introduction);
        mVideoView.setVideoURI(introductionUri);
    }

    /**
     * 停止播放视频 并跳转
     */
    private void stopPlayVideo(){
        try {
            mVideoView.stopPlayback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initData() {
        //启动数据库连接 用于调试数据库
        SQLiteStudioService.instance().start(this);
        DataManager.getInstance().getVersionCode(new DataCallback<Version>() {
            @Override
            public void onSuccess(Version data) {
                showSkipTips();
            }

            @Override
            public void onFailure(String msg) {
                shortToast(msg);
                showSkipTips();
            }

            @Override
            public void onError() {
                showSkipTips();
            }
        });
    }

    /**
     * 显示跳过信息
     */
    private void showSkipTips(){
        mTipsView.setVisibility(View.VISIBLE);
    }

    private void shortToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

}
