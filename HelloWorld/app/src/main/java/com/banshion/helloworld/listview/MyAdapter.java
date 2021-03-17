package com.banshion.helloworld.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.banshion.helloworld.R;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context) {
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
        return position;
    }

    static class ViewHolder {
        public ImageView newsImage;
        public TextView newsTitle;
        public TextView newsDateTime;
        public TextView newsContent;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.newsImage = convertView.findViewById(R.id.newImg);
            viewHolder.newsTitle = convertView.findViewById(R.id.newsTitle);
            viewHolder.newsDateTime = convertView.findViewById(R.id.dateTime);
            viewHolder.newsContent = convertView.findViewById(R.id.newsContent);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.newsTitle.setText("这是标题");
        viewHolder.newsDateTime.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        viewHolder.newsContent.setText("新闻内容");
        Glide.with(context).load("http://www.banshion.com:80/Res/Files/News/2020-11-10/37/14f80178-80d7-4b32-8f1b-1c17b63923e0.jpg").into(viewHolder.newsImage);
        return convertView;
    }

}
