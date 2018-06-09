package com.simalee.guangxiu.view.teaching;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.data.entity.TeachingTypeItem;

import java.util.ArrayList;

/**
 * Created by zb.yang on 2018/5/11.
 */

public class TeachingTypeAdapter extends RecyclerView.Adapter<TeachingTypeAdapter.TeachingTypeViewHolder> {

    private Context mContext;
    private ArrayList<TeachingTypeItem> teachingTypeItems;
    private SelectTypeBtnClickListener selectTypeBtnClickListener;
    private int currentPosition = 0;

    public TeachingTypeAdapter(Context context,ArrayList<TeachingTypeItem> teachingTypeItems) {
        super();
        mContext = context;
        this.teachingTypeItems = teachingTypeItems;
    }

    @Override
    public TeachingTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_teaching_type, parent, false);
        TeachingTypeViewHolder viewHolder = new TeachingTypeViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TeachingTypeViewHolder holder, final int position) {
        final TeachingTypeItem teachingTypeItem = teachingTypeItems.get(position);
        holder.bindData(teachingTypeItem);
        holder.typeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectTypeBtnClickListener!=null){
                    String name = teachingTypeItem.getTypeName();
                    for(int i = 0;i<TeachingTypeItem.typeNameArray.length;i++){
                        if(name.equals(TeachingTypeItem.typeNameArray[i])){
                            selectTypeBtnClickListener.selectTypeBtnClickListener(position,i);
                            currentPosition = position;
                            break;
                        }
                    }

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if(teachingTypeItems!=null)
            return teachingTypeItems.size();
        return 0;
    }

    public class TeachingTypeViewHolder extends RecyclerView.ViewHolder{
        private Button typeBtn;
        public TeachingTypeViewHolder(View itemView) {
            super(itemView);
            typeBtn = (Button)itemView.findViewById(R.id.selectTeachingTypeBtn);
        }

        public void bindData(TeachingTypeItem teachingTypeItem){
            typeBtn.setText(teachingTypeItem.getTypeName());
            if(teachingTypeItem.isClick()){
                typeBtn.setTextColor(mContext.getResources().getColor(R.color.buttonClickColor));
            }else{
                typeBtn.setTextColor(mContext.getResources().getColor(R.color.buttonUnClickColor));
            }
        }
    }

    public interface SelectTypeBtnClickListener{
        void selectTypeBtnClickListener(int position,int type);
    }

    public void setTypeBtnClickListener(SelectTypeBtnClickListener listener){
        this.selectTypeBtnClickListener = listener;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setTeachingTypeItems(ArrayList<TeachingTypeItem> list){
        if(list==null){
            return;
        }
        teachingTypeItems = list;
        notifyDataSetChanged();
    }
}
