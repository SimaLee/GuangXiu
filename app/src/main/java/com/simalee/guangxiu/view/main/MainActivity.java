package com.simalee.guangxiu.view.main;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.view.artist.ArtistListActivity;
import com.simalee.guangxiu.view.cartoon.GalleryActivity;
import com.simalee.guangxiu.view.history.HistoryIntroductionActivity;
import com.simalee.guangxiu.view.quiz.QuizActivity;
import com.simalee.guangxiu.view.teaching.TeachingActivity;
import com.simalee.guangxiu.view.technique.TechniqueActivity;


public class MainActivity extends BaseMVPActivity<MainPresenter> implements MainContract.MainView{

    private static final String TAG = "MainActivity";

    private TextView mLogoView;
    private Button mHistoryView;
    private Button mTechniqueView;
    private Button mArtistsView;
    private Button mCartoonView;
    private Button mTeachingView;
    private Button mQuizView;


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mPresenter != null){
            mPresenter.detachView();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
     protected void initViews() {

        mLogoView = findViewById(R.id.tv_logo);
        mHistoryView = findViewById(R.id.tv_history);
        mTechniqueView = findViewById(R.id.tv_technique);
        mArtistsView = findViewById(R.id.tv_artists);
        mCartoonView = findViewById(R.id.tv_cartoon);
        mTeachingView = findViewById(R.id.tv_teaching);
        mQuizView = findViewById(R.id.tv_quiz);

    }

    @Override
    protected void initListeners() {
        mLogoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performLogoClick();
            }
        });

        mHistoryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performHistoryClick();
            }
        });

        mTechniqueView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performTechniqueClick();
            }
        });

        mArtistsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performArtistClick();
            }
        });

        mCartoonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performCartoonClick();
            }
        });

        mTeachingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performTeachingClick();
            }
        });

        mQuizView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.performQuizClick();
            }
        });

    }

    @Override
    protected void initData() {
        mPresenter.checkVersion();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);

    }

    @Override
    public void onLogoClick() {
        Log.d(TAG, "onLogoClick: ");
        shortToast("点击了logo");
        Intent intent = new Intent(MainActivity.this,IntroductionActivity.class);
        startActivity(intent);
    }

    @Override
    public void onHistoryClick() {
        Log.d(TAG, "onHistoryClick: ");
        shortToast("点击了历史");
        Intent intent = new Intent(MainActivity.this, HistoryIntroductionActivity.class);
        startActivity(intent);
    }

    @Override
    public void onTechniqueClick() {
        Log.d(TAG, "onTechniqueClick: ");
        shortToast("点击了技艺");
        Intent intent = new Intent(this, TechniqueActivity.class);
        startActivity(intent);
    }

    @Override
    public void onArtistClick() {
        Log.d(TAG, "onArtistClick: ");
        shortToast("点击了名家");
        Intent intent = new Intent(this, ArtistListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCartoonClick() {
        Log.d(TAG, "onCartoonClick: ");
        shortToast("点击了动画");
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);
    }

    @Override
    public void onTeachingClick() {
        Log.d(TAG, "onTeachingClick: ");
        shortToast("点击了教学");
        Intent intent = new Intent(this, TeachingActivity.class);
        startActivity(intent);
    }

    @Override
    public void onQuizClick() {
        shortToast("点击了答题模块");
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    private void shortToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
