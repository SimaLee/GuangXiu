package com.simalee.guangxiu.view.history;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        holder.shortDesTV.setText(mList.get(position).getShortDescription());
        holder.timePointTV.setText(mList.get(position).getTimePoint());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView shortDesTV;
        TextView timePointTV;

        public ViewHolder(View view) {
            super(view);
            shortDesTV = (TextView) view.findViewById(R.id.shortDesTV);
            timePointTV = (TextView) view.findViewById(R.id.timePointTV);
        }
    }

}
