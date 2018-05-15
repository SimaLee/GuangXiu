package com.simalee.guangxiu.view.quiz;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.QuizItem;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/11.
 */

public class QuizActivity extends BaseMVPActivity<QuizPresenter> implements QuizContract.QuizView {
    private static final String TAG = "QuizActivity";

    public static final String ACTION_CHECK_ANSWER = "com.simalee.guangxiu.check_answer";
    public static final String KEY_PAGE_INDEX = "key_page_index";//当前选中的page的位置

    private TextView mQuizIntroductionView;
    private Button mPreviousView;
    private Button mNextView;
    private Button mConfirmView;

    private ViewPager mQuizViewPager;
    private QuizPageAdapter mPageAdapter;

    private int mQuizSize;

    /**
     * 初始化为0 第一个fragment的index
     */
    private int mCurrentQuizIndex = 0;

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
    public void showQuizList(List<QuizItem> quizItemList) {
        if (quizItemList == null || quizItemList.size() == 0){
            return;
        }
        mQuizSize = quizItemList.size();

        mPageAdapter = new QuizPageAdapter(getSupportFragmentManager(),quizItemList);
        mQuizViewPager.setAdapter(mPageAdapter);
        mQuizViewPager.setOffscreenPageLimit(2);
    }

    @Override
    public void showPreQuiz() {
        int position = mQuizViewPager.getCurrentItem();
        if (position == 0){
            Toast.makeText(this,"已经到第一题了",Toast.LENGTH_SHORT).show();
            return;
        }
        int preIndex = position - 1;
        if (preIndex >= 0 && preIndex<mQuizSize){
            mQuizViewPager.setCurrentItem(preIndex,true);
        }
    }

    @Override
    public void showNextQuiz() {
        int position = mQuizViewPager.getCurrentItem();
        if (position == mQuizSize - 1 ){
            Toast.makeText(this,"已经到最后一题了",Toast.LENGTH_SHORT).show();
            return;
        }
        int nextIndex = position + 1;
        if (nextIndex >= 0 && nextIndex < mQuizSize){
            mQuizViewPager.setCurrentItem(nextIndex,true);
        }
    }

    @Override
    public void showAnswer() {
        sendCheckAnswerBroadcast();
    }

    /**
     * 通知对应的fragment解析答案
     */
    private void sendCheckAnswerBroadcast() {
        Intent checkIntent = new Intent(ACTION_CHECK_ANSWER);
        checkIntent.putExtra(KEY_PAGE_INDEX,mCurrentQuizIndex);
        LocalBroadcastManager.getInstance(this).sendBroadcast(checkIntent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_quiz;
    }

    @Override
    protected void initViews() {
        mQuizIntroductionView  = findViewById(R.id.tv_quiz_introduction);
        mPreviousView = findViewById(R.id.tv_previous);
        mNextView = findViewById(R.id.tv_next);
        mConfirmView = findViewById(R.id.tv_confirm);
        mQuizViewPager = findViewById(R.id.vp_quiz_container);

        mQuizViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected: current: " + position);
                mCurrentQuizIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        checkQuizFragment();
    }

    private void checkQuizFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        QuizFragment quizFragment = QuizFragment.getInstance(0,new QuizItem());
        transaction.add(R.id.container,quizFragment);
        transaction.commit();
    }

    @Override
    protected void initListeners() {
        mPreviousView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.loadPreQuiz();
            }
        });
        mNextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.loadNextQuiz();
            }
        });
        mConfirmView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.checkAnswer();
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.loadQuizList();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new QuizPresenter();
        mPresenter.attachView(this);
    }
}
