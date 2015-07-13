package com.syiyi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.syiyi.adapter.R;
import com.syiyi.adapter.ViewHolder;

import java.util.List;

/**
 * Created by songlintao on 15/7/10.
 */
public abstract class CommonAdapter<T> extends BaseAdapter{
    protected Context mContext;
    protected List<T> mData;
    protected LayoutInflater mInflate;

    public CommonAdapter(List<T> data, Context mContext) {
        this.mData = data;
        this.mContext = mContext;
        this.mInflate=LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public  View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder=ViewHolder.get(mContext,convertView,parent, R.layout.my_cell,position);
        convert(holder,position);
        return holder.getContvertView();
    }
    public abstract  void convert(ViewHolder holder, int position);

}
