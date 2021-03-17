package com.banshion.helloworld.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.banshion.helloworld.R;
import com.bumptech.glide.Glide;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.StaggeredGridViewHolder> {

    private Context context;
    private SetOnClick setOnClick;

    public StaggeredGridAdapter(Context context, SetOnClick setOnClick) {
        this.context = context;
        this.setOnClick = setOnClick;
    }

    @NonNull
    @Override
    public StaggeredGridAdapter.StaggeredGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StaggeredGridViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_pu_item, null));
    }


    @Override
    public void onBindViewHolder(@NonNull StaggeredGridAdapter.StaggeredGridViewHolder holder, int position) {
        if (position % 2 == 0) {
            Glide.with(context).load("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1819216937,2118754409&fm=26&gp=0.jpg")
                    .into(holder.imageView);
        } else {
            Glide.with(context).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607341153793&di=054db926c8f725a4154246b9167bb8eb&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F30%2F29%2F01300000201438121627296084016.jpg")
                    .into(holder.imageView);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }


    class StaggeredGridViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public StaggeredGridViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.image);
        }
    }

    public interface SetOnClick {
        void onClick(int pos);
    }

}
