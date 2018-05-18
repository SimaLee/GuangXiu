package com.simalee.guangxiu.view.history;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.data.entity.DevelopmentItem;

import java.util.List;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 2017/6/9.
 */

public class DevelopmentTimeLineAdapter extends RecyclerView.Adapter<DevelopmentTimeLineAdapter.ViewHolder> {
    private static final String TAG = "DevelopmentTimeLine";
    Context mContext;
    List<DevelopmentItem> mList;

    public void setList(List<DevelopmentItem> list) {
        mList = list;
    }

    public DevelopmentTimeLineAdapter(Context context) {
        mContext = context;
    }

    public DevelopmentTimeLineAdapter(Context context,List<DevelopmentItem> list) {
        mContext = context;
        mList=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.development_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DevelopmentItem developmentItem = mList.get(position);
        if(developmentItem == null)
            return;
        holder.shortDesTV.setText(developmentItem.getDes());
        Glide.with(mContext)
                .load(developmentItem.getImageUrl())
                .placeholder(R.mipmap.bg_introduction_default)
                .crossFade()
                .into(holder.timePointIV);
        holder.developmentItemRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DevelopmentItemActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(DevelopmentItem.TAG,developmentItem);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView shortDesTV;
        ImageView timePointIV;
        RelativeLayout developmentItemRL;
        public ViewHolder(View view) {
            super(view);
            shortDesTV = (TextView) view.findViewById(R.id.shortDesTV);
            timePointIV = (ImageView) view.findViewById(R.id.timePointIV);
            developmentItemRL = (RelativeLayout)view.findViewById(R.id.developmentItemRL);
        }
    }

    public void setDevelopmentItemList(List<DevelopmentItem> list){
        if(list == null)
            return;
        mList = list;
        notifyDataSetChanged();
    }
}
