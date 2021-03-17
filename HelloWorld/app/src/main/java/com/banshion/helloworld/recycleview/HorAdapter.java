package com.banshion.helloworld.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.banshion.helloworld.R;

public class HorAdapter extends RecyclerView.Adapter<HorAdapter.HorViewHolder> {

    private Context context;
    private SetOnClick setOnClick;

    public HorAdapter(Context context, SetOnClick setOnClick) {
        this.context = context;
        this.setOnClick = setOnClick;
    }

    @NonNull
    @Override
    public HorAdapter.HorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HorViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_hor_item, null));
    }


    @Override
    public void onBindViewHolder(@NonNull HorAdapter.HorViewHolder holder, int position) {
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


    class HorViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public HorViewHolder(@NonNull View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.tv_title);
        }
    }

    public interface SetOnClick {
        void onClick(int pos);
    }

}
