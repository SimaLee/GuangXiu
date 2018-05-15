package com.simalee.guangxiu.view.cartoon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.data.entity.ThemeFilterItem;

import java.util.ArrayList;

/**
 * Created by zb.yang on 2018/5/14.
 */

public class ThemeFilterAdapter extends RecyclerView.Adapter<ThemeFilterAdapter.FilterViewHolder>{

    private Context mContext;
    private ArrayList<ThemeFilterItem> filterItems;

    public ThemeFilterAdapter(Context context, ArrayList<ThemeFilterItem> filterItems) {
        super();
        mContext = context;
        this.filterItems = filterItems;
    }

    @Override
    public FilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_works_filter,parent,false);
        FilterViewHolder filterViewHolder = new FilterViewHolder(view);
        return filterViewHolder;
    }

    @Override
    public void onBindViewHolder(final FilterViewHolder holder, final int position) {
        if(filterItems == null){
            return;
        }
        ThemeFilterItem item = filterItems.get(position);
        holder.bindData(item);
        holder.filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemeFilterItem item = filterItems.get(position);
                if(item.isClick()){
                    item.setClick(false);
                    holder.filterBtn.setBackground(mContext.getDrawable(R.drawable.bg_filter_btn));
                }else{
                    item.setClick(true);
                    holder.filterBtn.setBackground(mContext.getDrawable(R.drawable.bg_filter_btn_press));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return filterItems.size();
    }

    public class FilterViewHolder extends RecyclerView.ViewHolder{
        private Button filterBtn;
        public FilterViewHolder(View itemView) {
            super(itemView);
            filterBtn = (Button)itemView.findViewById(R.id.filterBtn);
        }

        public void bindData(ThemeFilterItem item){
            filterBtn.setText(item.getTypeName());
            if(item.isClick()){
                filterBtn.setBackground(mContext.getDrawable(R.drawable.bg_filter_btn_press));
            }else{
                filterBtn.setBackground(mContext.getDrawable(R.drawable.bg_filter_btn));
            }
        }
    }

    public void resetItemList(){
        if(filterItems== null){
            return;
        }
        for(int i = 0;i<filterItems.size();i++){
            ThemeFilterItem item = filterItems.get(i);
            item.setClick(false);
        }
        notifyDataSetChanged();
    }

    public ArrayList<ThemeFilterItem> getFilterItems() {
        return filterItems;
    }
}