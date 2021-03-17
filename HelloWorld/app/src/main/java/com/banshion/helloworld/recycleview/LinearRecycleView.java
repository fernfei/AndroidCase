package com.banshion.helloworld.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.banshion.helloworld.R;

public class LinearRecycleView extends AppCompatActivity {

    private RecyclerView m_RvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycle_view);
        m_RvMain = findViewById(R.id.rv_main);
        m_RvMain.setLayoutManager(new LinearLayoutManager(LinearRecycleView.this));
        m_RvMain.setAdapter(new LinearAdapter(LinearRecycleView.this, new LinearAdapter.SetOnClick() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(LinearRecycleView.this, "" + pos, Toast.LENGTH_SHORT).show();
            }
        }));
        m_RvMain.addItemDecoration(new MyDecoration());

    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }

}