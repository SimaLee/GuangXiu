package com.simalee.guangxiu.view.main;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseFragment;
import com.simalee.guangxiu.view.history.HistoryIntroductionActivity;
import com.simalee.guangxiu.view.history.NewHistoryActivity;
import com.simalee.guangxiu.view.quiz.QuizActivity;
import com.simalee.guangxiu.view.technique.NewTechniqueActivity;
import com.simalee.guangxiu.view.technique.ProcessActivity;
import com.simalee.guangxiu.view.technique.TechniqueActivity;
import com.simalee.guangxiu.view.vr.MyLocalWorksActivity;

/**
 * Created by Lee Sima on 2018/5/22.
 */

public class IntroductionFragment extends BaseFragment {

    private static final String TAG = "IntroductionFragment";

    private LinearLayout mHistoryView;
    private LinearLayout mTechniqueView;
    private LinearLayout mProcessView;
    private LinearLayout mQuizView;
    private LinearLayout mLocalWorksView;

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
        mLocalWorksView = rootView.findViewById(R.id.ll_my_local_works);
    }

    @Override
    protected void initListeners() {
        mHistoryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: history");
                Intent intent = new Intent(mContext, NewHistoryActivity.class);
                startActivity(intent);
            }
        });

        mTechniqueView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: technique");
                Intent intent = new Intent(mContext, NewTechniqueActivity.class);
                startActivity(intent);
            }
        });

        mProcessView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: process");
                Intent intent = new Intent(mContext, ProcessActivity.class);
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

        mLocalWorksView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MyLocalWorksActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

    }
}
