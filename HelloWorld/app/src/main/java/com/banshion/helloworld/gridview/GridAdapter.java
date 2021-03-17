package com.banshion.helloworld.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.banshion.helloworld.R;
import com.bumptech.glide.Glide;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public GridAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {
        public ImageView img;
        public TextView imgName;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (null == convertView) {
            convertView = layoutInflater.inflate(R.layout.activity_grid_item, null);
            viewHolder.img = convertView.findViewById(R.id.image);
            viewHolder.imgName = convertView.findViewById(R.id.imgName);
            convertView.setTag(viewHolder);
        }else
            viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.imgName.setText("小花花" + position);
        Glide.with(context).load("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3823571938,1484690513&fm=26&gp=0.jpg").into(viewHolder.img);
        return convertView;
    }
}
