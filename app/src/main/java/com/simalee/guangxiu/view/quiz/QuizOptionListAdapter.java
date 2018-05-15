package com.simalee.guangxiu.view.quiz;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.data.entity.QuizOptionItem;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Lee Sima on 2018/5/11.
 */

public class QuizOptionListAdapter extends BaseAdapter {

    private static final String TAG = "QuizOptionListAdapter";

    private List<QuizOptionItem> mQuizOptionItemList;
    private List<Boolean> mSelectedList;
    private Context mContext;
    private LayoutInflater mInflater;

    public QuizOptionListAdapter(Context context,List<QuizOptionItem> optionItems){
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mQuizOptionItemList = optionItems;
        fillSelectedList();
    }

    private void fillSelectedList() {
        mSelectedList = new ArrayList<>();
        int size = mQuizOptionItemList.size();
        for (int i = 0; i < size;i++){
            mSelectedList.add(false);
        }
    }


    @Override
    public int getCount() {
        return mQuizOptionItemList == null? 0: mQuizOptionItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return mQuizOptionItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if (convertView == null){

            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_quiz,null);
            viewHolder.ll_layout = convertView.findViewById(R.id.ll_item);
            viewHolder.cb_item = convertView.findViewById(R.id.cb_item);
            viewHolder.tv_sequence = convertView.findViewById(R.id.tv_sequence);
            viewHolder.tv_option = convertView.findViewById(R.id.tv_option);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.ll_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ll position: "+position);
                if (mSelectedList.get(position)){
                    //单选 选择完后至少有一个选项
//                    mSelectedList.set(position,false);
//                    notifyDataSetChanged();

                }else{
                    notifyOptionSelected(position);

                }
            }
        });

        viewHolder.cb_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyOptionSelected(position);
            }
        });
        viewHolder.cb_item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    if (mOnOptionSelectedListener != null){
                        mOnOptionSelectedListener.onOptionSelected(position,isChecked);
                    }
                }
            }
        });
        QuizOptionItem optionItem = mQuizOptionItemList.get(position);
        viewHolder.tv_sequence.setText(getOptionIndicator(optionItem.getId()) + ".");
        viewHolder.tv_option.setText(optionItem.getDescription());
        viewHolder.cb_item.setChecked(mSelectedList.get(position));
        Log.d(TAG, "getView: cb position:"+position + " checked:"+mSelectedList.get(position));
        return convertView;
    }

    public void notifyOptionSelected(int position) {
        if (position < 0){
            return;
        }
        mSelectedList.set(position,true);
        for (int i = 0; i< mSelectedList.size();i++){
            if (i == position){
                continue;
            }
            mSelectedList.set(i,false);
        }
        notifyDataSetChanged();
    }
    public boolean isOptionSelected(int position){
        return mSelectedList.get(position);
    }

    private String getOptionIndicator(int number){
        char res = (char)('A' + number);
        return String.valueOf(res);
    }

    class ViewHolder{
        LinearLayout ll_layout;
        CheckBox cb_item;
        TextView tv_sequence;
        TextView tv_option;
    }


    private OnOptionSelectedListener mOnOptionSelectedListener;

    public void setOnOptionSelectedListener(OnOptionSelectedListener onOptionSelectedListener) {
        mOnOptionSelectedListener = onOptionSelectedListener;
    }

    public interface OnOptionSelectedListener{
        void onOptionSelected(int position,boolean isSelected);
    }

}
