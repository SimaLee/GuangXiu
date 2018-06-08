package com.simalee.guangxiu.view.teaching;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.data.entity.TeachingContentItem;
import com.simalee.guangxiu.utils.UrlUtils;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zb.yang on 2018/5/10.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {
    private Context mContext;
    private List<TeachingContentItem> mTeachContentList;

    public VideoAdapter(Context context , List<TeachingContentItem> teachContentList) {
        super();
        mContext = context;
        mTeachContentList = teachContentList;
    }

    @Override
    public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_video, parent, false);
        VideoHolder holder = new VideoHolder(itemView);
        TxVideoPlayerController controller = new TxVideoPlayerController(mContext);
        holder.setController(controller);
        return holder;
    }

    @Override
    public void onBindViewHolder(VideoHolder holder, int position) {
        TeachingContentItem video = mTeachContentList.get(position);
        holder.bindData(video);
    }

    @Override
    public int getItemCount() {
        return mTeachContentList.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder{
        public TxVideoPlayerController mController;
        public NiceVideoPlayer mVideoPlayer;

        public VideoHolder(View itemView) {
            super(itemView);
            mVideoPlayer = (NiceVideoPlayer) itemView.findViewById(R.id.nice_video_player);
            mVideoPlayer.setPlayerType(NiceVideoPlayer.TYPE_NATIVE);//使用本地的MediaPlayer
            // 将列表中的每个视频设置为默认16:9的比例
            ViewGroup.LayoutParams params = mVideoPlayer.getLayoutParams();
            params.width = itemView.getResources().getDisplayMetrics().widthPixels; // 宽度为屏幕宽度
            params.height = (int) (params.width * 9f / 16f);    // 高度为宽度的9/16
            mVideoPlayer.setLayoutParams(params);
        }

        public void setController(TxVideoPlayerController controller) {
            mController = controller;
            mVideoPlayer.setController(mController);
        }

        public void bindData(TeachingContentItem video) {
            mController.setTitle(video.getVideoName());
            mController.setLenght(video.getVideoTime());
            Glide.with(itemView.getContext())
                    .load(UrlUtils.getImageUrl(video.getCoverUrl()))
                    .placeholder(R.mipmap.bg_introduction_default)
                    .crossFade()
                    .into(mController.imageView());
            mVideoPlayer.setUp(UrlUtils.getImageUrl(video.getVideoUrl()), null);
        }
    }

    public void setmTeachContentList(ArrayList<TeachingContentItem> list){
        if(list==null || list.size()==0){
            return;
        }
        mTeachContentList = list;
        notifyDataSetChanged();
    }
}
