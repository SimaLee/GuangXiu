package com.simalee.guangxiu.view.cartoon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.data.entity.ThemeFilterItem;
import com.simalee.guangxiu.data.entity.UseWorkFilterItem;

import java.util.ArrayList;

/**
 * Created by zb.yang on 2018/5/14.
 */

public class UseFilterAdapter extends RecyclerView.Adapter<UseFilterAdapter.FilterViewHolder>{

    private Context mContext;
    private ArrayList<UseWorkFilterItem> filterItems;



    public UseFilterAdapter(Context context, ArrayList<UseWorkFilterItem> filterItems) {
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
        UseWorkFilterItem item = filterItems.get(position);
        holder.bindData(item);
        holder.filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UseWorkFilterItem item = filterItems.get(position);
                if(item.isClicked()){
                    item.setClicked(false);
                    holder.filterBtn.setBackground(mContext.getDrawable(R.drawable.bg_filter_btn));
                }else{
                    item.setClicked(true);
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

        public void bindData(UseWorkFilterItem item){
            filterBtn.setText(item.getFilterName());
            if(item.isClicked()){
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
            UseWorkFilterItem item = filterItems.get(i);
            item.setClicked(false);
        }
        notifyDataSetChanged();
    }

    public ArrayList<UseWorkFilterItem> getFilterItems() {
        return filterItems;
    }
}