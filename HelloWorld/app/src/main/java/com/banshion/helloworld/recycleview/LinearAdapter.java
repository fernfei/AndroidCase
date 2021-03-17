package com.banshion.helloworld.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.banshion.helloworld.R;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    private Context context;
    private SetOnClick setOnClick;

    public LinearAdapter(Context context,SetOnClick setOnClick) {
        this.context = context;
        this.setOnClick = setOnClick;
    }

    @NonNull
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_linear_item, null));
    }


    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.LinearViewHolder holder, int position) {
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


    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.tv_title);
        }
    }

    public interface SetOnClick {
        void onClick(int pos);
    }

}
