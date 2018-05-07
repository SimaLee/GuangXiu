package com.simalee.guangxiu.view.technique;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.data.entity.ThreadItem;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class ThreadListAdapter extends RecyclerView.Adapter<ThreadListAdapter.ViewHolder> {

    private static final String TAG = "ThreadListAdapter";

    private WeakReference<Context> mContext;
    private List<ThreadItem>  mThreadItemList;

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    private OnItemClickListener mItemClickListener;

    public ThreadListAdapter(Context context,List<ThreadItem> itemList){
        mContext = new WeakReference<Context>(context);
        mThreadItemList = itemList;
    }

    public void replaceData(List<ThreadItem> itemList){
        if (mThreadItemList != null){
            mThreadItemList.clear();
            mThreadItemList.addAll(itemList);
            notifyDataSetChanged();
        }
    }

    public void appendData(List<ThreadItem> itemList){
        int oldSize = mThreadItemList.size();
        mThreadItemList.addAll(itemList);
        int newSize = mThreadItemList.size();
        notifyItemRangeChanged(oldSize,newSize);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thread,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ThreadItem item = mThreadItemList.get(position);
        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return mThreadItemList == null? 0 : mThreadItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mThreadImage;
        private TextView mThreadName;

        public ViewHolder(View itemView) {
            super(itemView);
            mThreadImage = itemView.findViewById(R.id.iv_thread);
            mThreadName = itemView.findViewById(R.id.tv_thread_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemClickListener != null){
                        int position = getAdapterPosition();
                        mItemClickListener.onItemClick(position,mThreadItemList.get(position));
                    }
                }
            });
        }
        public void bindData(ThreadItem item){
            mThreadName.setText(item.getName());
            Glide.with(mContext.get())
                    .load(item.getImage())
                    .error(R.mipmap.ic_launcher)
                    .into(mThreadImage);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position,ThreadItem item);
    }
}
