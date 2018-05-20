package com.simalee.guangxiu.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.app.UrlConstants;
import com.simalee.guangxiu.data.entity.TextImageItem;
import com.simalee.guangxiu.utils.UrlUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lee Sima on 2018/5/20.
 */

public class MultiItemAdapter extends RecyclerView.Adapter<MultiItemAdapter.MultiViewHolder> {


    private static final String TAG = "MultiItemAdapter";

    //类型
    private static final int TYPE_IMAGE = 0;
    private static final int TYPE_TEXT = 1;

    private Context mContext;
    private LayoutInflater mInflater;
    private List<TextImageItem> mTextImageItemList;

    private List<String> mImageUrlList;
    private Map<Integer,Integer> mImageIndexMap;

    public MultiItemAdapter(Context context,List<TextImageItem> textImageItems){
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mTextImageItemList = textImageItems;
        updateIndexMap();
    }

    /**
     * 当执行大量数据集变换的操作后，完成图片url列表的更新
     * 不要频繁调用 减少计算量
     */
    private void updateIndexMap() {
        //清空图片列表
        if(mImageUrlList == null){
            mImageUrlList = new ArrayList<>();
        }else{
            mImageUrlList.clear();
        }
        //清空映射列表
        if (mImageIndexMap == null){
            mImageIndexMap = new HashMap<>();
        }else{
            mImageIndexMap.clear();
        }

        int size = mTextImageItemList.size();
        int imageCounter = 0;
        TextImageItem tempItem;

        for (int i = 0; i < size; i++) {
            tempItem = mTextImageItemList.get(i);
            if (tempItem.isImageItem()){
                mImageUrlList.add(UrlUtils.getImageUrl(tempItem.getImageurl()));
                mImageIndexMap.put(i,imageCounter);
                imageCounter++;
            }
        }

    }

    /**
     * 根据position 判断对应位置的item是否需要添加到map中
     * 适合少量数据集更新的情况
     * @param position
     */
    private void updateIndexMapFor(int position){

        TextImageItem tempItem = mTextImageItemList.get(position);
        if (tempItem.isImageItem()){
            int curImageCounter = mImageUrlList.size();
            mImageUrlList.add(UrlUtils.getImageUrl(tempItem.getImageurl()));
            mImageIndexMap.put(position,curImageCounter);

        }
    }

    @Override
    public MultiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_IMAGE){
            View rootView = mInflater.inflate(R.layout.item_multi_image,parent,false);
            return new ImageHolder(rootView);

        }else if (viewType == TYPE_TEXT){
            View rootView = mInflater.inflate(R.layout.item_multi_text,parent,false);
            return new TextHolder(rootView);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        TextImageItem item = mTextImageItemList.get(position);
        if (item != null){
            if (item.isImageItem()){
                return TYPE_IMAGE;
            }

            if (item.isTextItem()){
                return TYPE_TEXT;
            }
        }
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(MultiViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: position : " + position);
        TextImageItem item = mTextImageItemList.get(position);
        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return mTextImageItemList == null? 0:mTextImageItemList.size();
    }


    /**
     * 添加所有的item
     * @param textImageItems
     */
    public void addItems(List<TextImageItem> textImageItems){
        int oldSize = mTextImageItemList.size();
        mTextImageItemList.addAll(textImageItems);
        int newSize=  mTextImageItemList.size();
        updateIndexMap();
        notifyItemRangeChanged(oldSize,newSize);
    }

    /**
     * 添加一个item
     * @param textImageItem
     */
    public void addItem(TextImageItem textImageItem){

        mTextImageItemList.add(textImageItem);

        updateIndexMapFor(mTextImageItemList.size());
        notifyItemInserted(mTextImageItemList.size());
    }

    public abstract class MultiViewHolder extends RecyclerView.ViewHolder{

        public MultiViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void bindData(TextImageItem itemInfo);

    }

    public class TextHolder extends MultiViewHolder{

        private static final String SEPERATOR = "GX/";
        private static final String FIRST_PREFIX = "\t\t";
        private static final String TEXT_PREFIX = "\n\t\t";

        private TextView mTextView;

        public TextHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_text);
        }

        @Override
        public void bindData(TextImageItem itemInfo) {
            if (itemInfo == null){
                return;
            }
            //todo 文字切割
            if (itemInfo.isTextItem()){
                mTextView.setText(parseContent(itemInfo.getText()));
                Log.d(TAG, "bindData: Text:" + itemInfo.getText());
            }
        }

        /**
         *
         * @param content
         * @return
         */
        private String parseContent(String content){
            if (content == null){
                return " ";
            }
            String result = content.replace(SEPERATOR,TEXT_PREFIX);
            return FIRST_PREFIX + result;
        }
    }

    public class ImageHolder extends MultiViewHolder{

        private ImageView mImageView;

        public ImageHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_image);
            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (mOnImageClickListener != null){
                        int imageIndex =  mImageIndexMap.get(position);
                        mOnImageClickListener.onImageClick(mImageUrlList,imageIndex);
                    }
                }
            });
            //todo 点击事件绑定
        }

        @Override
        public void bindData(TextImageItem itemInfo) {
            if (itemInfo == null){
                return;
            }
            if (itemInfo.isImageItem()){
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mImageView.getLayoutParams();

                layoutParams.width = itemInfo.getWidth();
                layoutParams.height = itemInfo.getHeight();
                mImageView.setLayoutParams(layoutParams);

                //图片加载
                Glide.with(mContext)
                        .load(UrlUtils.getImageUrl(itemInfo.getImageurl()))
                        .error(R.mipmap.embroidery_default)
                        .into(mImageView);
                Log.d(TAG, "bindData: Image: " + itemInfo.getImageurl());
            }
        }
    }

    public void setOnImageClickListener(OnImageClickListener onImageClickListener) {
        mOnImageClickListener = onImageClickListener;
    }

    private OnImageClickListener mOnImageClickListener;

    public interface OnImageClickListener{
        void onImageClick(List<String> imageUrlList,int position);
    }
}
