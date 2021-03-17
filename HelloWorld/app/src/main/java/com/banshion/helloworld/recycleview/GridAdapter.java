package com.banshion.helloworld.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.banshion.helloworld.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    private Context context;
    private SetOnClick setOnClick;

    public GridAdapter(Context context, SetOnClick setOnClick) {
        this.context = context;
        this.setOnClick = setOnClick;
    }

    @NonNull
    @Override
    public GridAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GridViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_grid_item, null));
    }


    @Override
    public void onBindViewHolder(@NonNull GridAdapter.GridViewHolder holder, int position) {
        holder.textView.setText("Hello World");
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


    class GridViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.tv_title);
        }
    }

    public interface SetOnClick {
        void onClick(int pos);
    }

}
