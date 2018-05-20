package com.simalee.guangxiu.view.artist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.app.UrlConstants;
import com.simalee.guangxiu.data.entity.Artist;
import com.simalee.guangxiu.utils.UrlUtils;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/10.
 */

public class ArtistListAdapter extends RecyclerView.Adapter<ArtistListAdapter.ViewHolder> {

    private static final String TAG = "ArtistListAdapter";

    private WeakReference<Context> mContext;
    private List<Artist> mArtistList;

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    private OnItemClickListener mItemClickListener;


    public void replaceData(List<Artist> itemList){
        if (mArtistList != null){
            mArtistList.clear();
            mArtistList.addAll(itemList);
            notifyDataSetChanged();
        }
    }

    public void appendData(List<Artist> itemList){
        int oldSize = mArtistList.size();
        mArtistList.addAll(itemList);
        int newSize = mArtistList.size();
        notifyItemRangeChanged(oldSize,newSize);
    }

    public ArtistListAdapter(Context context,List<Artist> artists){
        mContext = new WeakReference<Context>(context);
        mArtistList = artists;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext.get()).inflate(R.layout.item_artist,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Artist item = mArtistList.get(position);
        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return mArtistList == null? 0:mArtistList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mArtistImage;
        private TextView mArtistName;

        public ViewHolder(View itemView) {
            super(itemView);
            mArtistImage = itemView.findViewById(R.id.iv_artist);
            mArtistName = itemView.findViewById(R.id.tv_artist_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemClickListener != null){
                        int position = getAdapterPosition();
                        mItemClickListener.onItemClick(position,mArtistList.get(position));
                    }
                }
            });
        }

        public void bindData(Artist item){

            mArtistName.setText(item.getName());
            Glide.with(mContext.get())
                    .load(UrlUtils.getImageUrl(item.getAvatar()))
                    .fitCenter()
                    .error(R.mipmap.avatar_default)
                    .into(mArtistImage);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position,Artist item);
    }
}
