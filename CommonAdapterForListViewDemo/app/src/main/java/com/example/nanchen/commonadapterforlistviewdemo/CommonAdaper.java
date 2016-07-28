package com.example.nanchen.commonadapterforlistviewdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 打造ListView的万能适配器
 * Created by 南尘 on 16-7-28.
 */
public abstract class CommonAdaper<T> extends BaseAdapter {
    private Context context;
    private List<T> list;


    public CommonAdaper(Context context, List<T> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = ViewHolder.get(view,viewGroup,R.layout.list_item,i);
        convert(holder,getItem(i));
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder,T item);

}
