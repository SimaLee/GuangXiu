package com.simalee.guangxiu.view.quiz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.SuperKotlin.pictureviewer.ImagePagerActivity;
import com.SuperKotlin.pictureviewer.PictureConfig;
import com.bumptech.glide.Glide;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.app.UrlConstants;
import com.simalee.guangxiu.data.entity.QuizItem;
import com.simalee.guangxiu.data.entity.QuizOptionItem;
import com.simalee.guangxiu.utils.UrlUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/11.
 */

public class QuizFragment extends Fragment {
    private static final String TAG = "QuizFragment";

    private static final String KEY_INDEX = "key_index";
    private static final String KEY_ITEM = "key_item";

    private static final String BUNDLE_SELECTED_INDEX = "bundle_selected_index";
    public static final String BUNDLE_QUIZ_CHECKED = "bundle_quiz_checked";

    public static final int INDEX_INVALID = -1;

    private QuizItem mQuizItem;
    private int mQuizIndex = INDEX_INVALID;

    private int mSelectedIndex = INDEX_INVALID;
    private boolean mQuizChecked = false;

    private TextView mQuestionView;
    private ImageView mQuizImageView;
    private ListView mOptionsListView;
    private TextView mExplanationIndicatorView;
    private TextView mExplanationView;

    private QuizOptionListAdapter mOptionListAdapter;

    private CheckAnswerReceiver mCheckAnswerReceiver;

    public QuizFragment(){

    }

    public static QuizFragment getInstance(int index,QuizItem item){

        QuizFragment instance = new QuizFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_INDEX,index);
        bundle.putSerializable(KEY_ITEM,item);
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            mQuizIndex = getArguments().getInt(KEY_INDEX);
            mQuizItem = (QuizItem) getArguments().getSerializable(KEY_ITEM);

        }
        mCheckAnswerReceiver = new CheckAnswerReceiver();
        IntentFilter filter = new IntentFilter(QuizActivity.ACTION_CHECK_ANSWER);
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(mCheckAnswerReceiver,filter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mCheckAnswerReceiver != null){
            LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(mCheckAnswerReceiver);
            mCheckAnswerReceiver = null;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_quiz,container,false);
        //
        mQuestionView = rootView.findViewById(R.id.tv_quiz_question);
        mQuizImageView = rootView.findViewById(R.id.iv_quiz_image);
        mOptionsListView = rootView.findViewById(R.id.lv_options);
        mExplanationIndicatorView = rootView.findViewById(R.id.tv_explanation_indicator);
        mExplanationView = rootView.findViewById(R.id.tv_quiz_explanation);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (TextUtils.isEmpty(mQuizItem.getImage()) || "null".equals(mQuizItem.getImage())){
            mQuizImageView.setVisibility(View.GONE);
        }else{
            mQuizImageView.setVisibility(View.VISIBLE);
            Glide.with(this)
                    .load(UrlUtils.getImageUrl(mQuizItem.getImage()))
                    .error(R.mipmap.embroidery_default)
                    .into(mQuizImageView);

            mQuizImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.d(TAG, "onClick: quizImage: " + mQuizItem.getImage());
                    ArrayList<String> imageUrlList = new ArrayList<>();
                    if (mQuizItem != null){
                        imageUrlList.add(UrlUtils.getImageUrl(mQuizItem.getImage()));
                    }

                    PictureConfig config = new PictureConfig.Builder()
                            .setListData(imageUrlList)//图片数据List<String> list
                            .setPosition(0)//图片下标（从第position张图片开始浏览）
                            .setDownloadPath("pictureviewer")//图片下载文件夹地址
                            .setIsShowNumber(false)//是否显示数字下标
                            .needDownload(true)//是否支持图片下载
                            .setPlacrHolder(R.mipmap.embroidery_default)//占位符图片（图片加载完成前显示的资源图片，来源drawable或者mipmap）
                            .build();

                    ImagePagerActivity.startActivity(getContext(), config);
                }
            });
        }

        mOptionListAdapter = new QuizOptionListAdapter(view.getContext(),mQuizItem.getOptions());
        mOptionsListView.setAdapter(mOptionListAdapter);
        mOptionListAdapter.setOnOptionSelectedListener(new QuizOptionListAdapter.OnOptionSelectedListener() {
            @Override
            public void onOptionSelected(int position, boolean isSelected) {
                if (isSelected){
                    //记录选中的选项
                    mSelectedIndex = position;
                }
            }
        });

        //恢复选择
        if (savedInstanceState != null){
            mSelectedIndex = savedInstanceState.getInt(BUNDLE_SELECTED_INDEX);
            mQuizChecked = savedInstanceState.getBoolean(BUNDLE_QUIZ_CHECKED);
            mOptionListAdapter.notifyOptionSelected(mSelectedIndex);
        }

        mQuestionView.setText(mQuizItem.getSequence() + ". "+mQuizItem.getQuestion());
        //初始的时候不显示解析
        mExplanationView.setText(generateExplanation());
        mExplanationView.setMovementMethod(ScrollingMovementMethod.getInstance());

        if (mQuizChecked){
            showExplanation(true);
        }else{
            showExplanation(false);
        }

    }

    /**
     * 生成解析文案
     * @return
     */
    private String generateExplanation() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\t正确答案为: ");
        stringBuilder.append(mOptionListAdapter.getOptionIndicator(mQuizItem.getAnswerId()));
        stringBuilder.append(".\n\t");
        stringBuilder.append(mQuizItem.getExplanation());

        return stringBuilder.toString();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_SELECTED_INDEX, mSelectedIndex);
        outState.putBoolean(BUNDLE_QUIZ_CHECKED,mQuizChecked);
    }

    public void checkAnswer(){
        //todo 揭示答案时的效果
        mQuizChecked = true;
        if (mSelectedIndex == mQuizItem.getAnswerId()){
            Toast.makeText(getContext(),"恭喜你答对了！",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(),"很遗憾你答错了！",Toast.LENGTH_SHORT).show();
        }
        showExplanation(true);
    }

    /**
     * 设置答案解析是否显示
     * @param isShow
     */
    private void showExplanation(boolean isShow){
        if (isShow){
            mExplanationIndicatorView.setVisibility(View.VISIBLE);
            mExplanationView.setVisibility(View.VISIBLE);
        }else{
            mExplanationIndicatorView.setVisibility(View.INVISIBLE);
            mExplanationView.setVisibility(View.INVISIBLE);
        }
    }

    private QuizItem testItem() {

        QuizItem item = new QuizItem();
        item.setImage("");
        item.setQuestion("这里是问题");
        item.setExplanation("这里是问题解释");
        item.setAnswerId(0);
        item.setSequence(0);

        List<QuizOptionItem> optionItems = new ArrayList<>();
        optionItems.add(new QuizOptionItem(0,"选项A"));
        optionItems.add(new QuizOptionItem(1,"选项B"));
        optionItems.add(new QuizOptionItem(2,"选项C"));
        item.setOptions(optionItems);

        return item;
    }


    private class CheckAnswerReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();
            if (action.equals(QuizActivity.ACTION_CHECK_ANSWER)){
                int receiveIndex = intent.getIntExtra(QuizActivity.KEY_PAGE_INDEX,-1);
                Log.d(TAG, "onReceive: fragment index:"+mQuizIndex + " receive " + receiveIndex);
                if (receiveIndex == mQuizIndex){
                    checkAnswer();
                }
            }
        }
    }

}
