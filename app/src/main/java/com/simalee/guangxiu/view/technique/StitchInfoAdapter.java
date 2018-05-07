package com.simalee.guangxiu.view.technique;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.data.entity.StitchItem;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class StitchInfoAdapter extends RecyclerView.Adapter<StitchInfoAdapter.ViewHolder> {

    private static final String TAG = "StitchInfoAdapter";

    private WeakReference<Context> mContext;
    private List<StitchItem> mStitchItemList;

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    private OnItemClickListener mItemClickListener;

    public StitchInfoAdapter(Context context, List<StitchItem> stitchItemList) {
        mContext = new WeakReference<Context>(context);
        mStitchItemList = stitchItemList;
    }

    public void replaceData(List<StitchItem> itemList){
        if(mStitchItemList != null){

           mStitchItemList.clear();
           mStitchItemList.addAll(itemList);
           notifyDataSetChanged();
        }
    }

    public void appendData(List<StitchItem> itemList){
        int oldSize = mStitchItemList.size();
        mStitchItemList.addAll(itemList);
        int newSize = mStitchItemList.size();
        notifyItemRangeChanged(oldSize,newSize);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stitch,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StitchItem item = mStitchItemList.get(position);
        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return mStitchItemList == null? 0:mStitchItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mStitchImage;
        private TextView mStitchName;

        public ViewHolder(View itemView) {
            super(itemView);
            mStitchImage = itemView.findViewById(R.id.iv_stitch);
            mStitchName = itemView.findViewById(R.id.tv_stitch_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemClickListener != null){
                        int position = getAdapterPosition();
                        mItemClickListener.onItemClick(position,mStitchItemList.get(position));
                    }
                }
            });
        }
        public void bindData(StitchItem item){
            mStitchName.setText(item.getName());
            Glide.with(mContext.get())
                    .load(item.getImage())
                    .error(R.mipmap.ic_launcher)
                    .into(mStitchImage);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position,StitchItem item);
    }
}
