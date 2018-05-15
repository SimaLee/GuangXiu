package com.simalee.guangxiu.view.cartoon;

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
import com.simalee.guangxiu.data.entity.EmbroideryWorkItem;
import com.simalee.guangxiu.view.technique.EmbroideryActivity;

import java.util.ArrayList;

/**
 * Created by zb.yang on 2018/5/15.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    private static final String TAG = "GalleryAdapter";
    public static final String EMBROIDERY_WORK_ITEM_KEY = "EmbroideryWorkItem";
    private Context mContext;
    private ArrayList<EmbroideryWorkItem> embroideryWorkItems;
    public GalleryAdapter(Context context,ArrayList<EmbroideryWorkItem> embroideryWorkItems) {
        super();
        mContext = context;
        this.embroideryWorkItems = embroideryWorkItems;
    }

    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_embroidery_works,parent,false);
        GalleryViewHolder galleryViewHolder = new GalleryViewHolder(view);
        return galleryViewHolder;
    }

    @Override
    public void onBindViewHolder(GalleryViewHolder holder, final int position) {
        final EmbroideryWorkItem embroideryWorkItem = embroideryWorkItems.get(position);
        if(embroideryWorkItem!=null){
            holder.bindData(embroideryWorkItem);
        }
        holder.embroideryItemRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, EmbroideryContentActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(EMBROIDERY_WORK_ITEM_KEY,embroideryWorkItem);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return embroideryWorkItems.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout embroideryItemRL;
        private ImageView embroideryIV;
        private TextView workNameTV;
        public GalleryViewHolder(View itemView) {
            super(itemView);
            embroideryItemRL = (RelativeLayout)itemView.findViewById(R.id.embroideryItemRL);
            embroideryIV = (ImageView)itemView.findViewById(R.id.embroideryIV);
            workNameTV = (TextView)itemView.findViewById(R.id.embroideryNameTV);
        }

        public void bindData(EmbroideryWorkItem embroideryWorkItem){
            if(embroideryWorkItem ==null){
                return;
            }
            Glide.with(itemView.getContext())
                    .load(embroideryWorkItem.getImageUrl())
                    .placeholder(R.mipmap.bg_introduction_default)
                    .crossFade()
                    .into(embroideryIV);
            workNameTV.setText(embroideryWorkItem.getWorkName());
        }
    }

    public void setEmbroideryWorkItems(ArrayList<EmbroideryWorkItem> list){
        if(list == null){
            return;
        }

        embroideryWorkItems = list;
        notifyDataSetChanged();
    }
}
