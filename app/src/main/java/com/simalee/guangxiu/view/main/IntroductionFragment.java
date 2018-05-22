package com.simalee.guangxiu.view.main;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseFragment;
import com.simalee.guangxiu.view.history.HistoryIntroductionActivity;
import com.simalee.guangxiu.view.quiz.QuizActivity;
import com.simalee.guangxiu.view.technique.TechniqueActivity;

/**
 * Created by Lee Sima on 2018/5/22.
 */

public class IntroductionFragment extends BaseFragment {

    private static final String TAG = "IntroductionFragment";

    private LinearLayout mHistoryView;
    private LinearLayout mTechniqueView;
    private LinearLayout mProcessView;
    private LinearLayout mQuizView;

    public IntroductionFragment(){

    }

    public static IntroductionFragment getInstance(){
        IntroductionFragment instance = new IntroductionFragment();
        Bundle bundle = new Bundle();
        instance.setArguments(bundle);
        return instance;

    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_introduction;
    }

    @Override
    protected void initViews(View rootView) {
        mHistoryView = rootView.findViewById(R.id.ll_history);
        mTechniqueView = rootView.findViewById(R.id.ll_technique);
        mProcessView = rootView.findViewById(R.id.ll_process);
        mQuizView = rootView.findViewById(R.id.ll_quiz);
    }

    @Override
    protected void initListeners() {
        mHistoryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: history");
                Intent intent = new Intent(mContext, HistoryIntroductionActivity.class);
                startActivity(intent);
            }
        });

        mTechniqueView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: technique");
                Intent intent = new Intent(mContext, TechniqueActivity.class);
                startActivity(intent);
            }
        });

        mProcessView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: process");
                Intent intent = new Intent(mContext, HistoryIntroductionActivity.class);
                startActivity(intent);
            }
        });

        mQuizView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: quiz");
                Intent intent = new Intent(mContext, QuizActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

    }
}
