package com.banshion.helloworld.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.banshion.helloworld.R;

public class GridRecycleActivity extends AppCompatActivity {

    public RecyclerView m_RvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycle);
        m_RvGrid = findViewById(R.id.rv_grid);
        //spanCount 一行展示3个
        m_RvGrid.setLayoutManager(new GridLayoutManager(this, 3));
        m_RvGrid.setAdapter(new GridAdapter(this, null));
    }
}