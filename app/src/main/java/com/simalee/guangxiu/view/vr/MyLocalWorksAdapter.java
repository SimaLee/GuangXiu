package com.simalee.guangxiu.view.vr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.data.entity.EmbroideryWorkItem;
import com.simalee.guangxiu.data.entity.LocalEmbroideryWork;
import com.simalee.guangxiu.utils.UrlUtils;
import com.simalee.guangxiu.view.cartoon.EmbroideryContentActivity;

import java.security.Key;
import java.util.List;

/**
 * Created by zb.yang on 2018/5/15.
 */

public class MyLocalWorksAdapter extends RecyclerView.Adapter<MyLocalWorksAdapter.GalleryViewHolder> {
    private static final String TAG = "MyLocalWorksAdapter";
    private final String KEY = "MyLocalWorksAdapter";

    private Context mContext;
    private List<LocalEmbroideryWork> embroideryWorkItems;

    public MyLocalWorksAdapter(Context context, List<LocalEmbroideryWork> embroideryWorkItems) {
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
    public void onBindViewHolder(final GalleryViewHolder holder, final int position) {
        final LocalEmbroideryWork embroideryWorkItem = embroideryWorkItems.get(position);
        if(embroideryWorkItem!=null){
            holder.bindData(embroideryWorkItem);
        }

        holder.embroideryItemRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, LocalEmbroideryContentActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(LocalEmbroideryWork.TAG,embroideryWorkItem);
                intent.putExtras(bundle);

                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext,
                                new Pair<View, String>(holder.embroideryIV,"iv_embroidery"));

                ActivityCompat.startActivity(mContext,intent,options.toBundle());
                //mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return embroideryWorkItems.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder{

        public RelativeLayout embroideryItemRL;
        public ImageView embroideryIV;
        public TextView workNameTV;

        public GalleryViewHolder(View itemView) {
            super(itemView);
            embroideryItemRL = (RelativeLayout)itemView.findViewById(R.id.embroideryItemRL);
            embroideryIV = (ImageView)itemView.findViewById(R.id.embroideryIV);
            workNameTV = (TextView)itemView.findViewById(R.id.embroideryNameTV);
        }

        public void bindData(LocalEmbroideryWork embroideryWorkItem){
            if(embroideryWorkItem ==null){
                return;
            }
            Bitmap bitmap = BitmapFactory.decodeFile(embroideryWorkItem.getWorkPath());
            if(bitmap!=null){
                embroideryIV.setImageBitmap(bitmap);
            }else{
                embroideryIV.setImageResource(R.mipmap.avatar_default);
            }

            workNameTV.setText(embroideryWorkItem.getWorkName());
        }
    }

    public void setEmbroideryWorkItems(List<LocalEmbroideryWork> list){
        if(list == null){
            return;
        }
        embroideryWorkItems = list;
        notifyDataSetChanged();
    }
}
