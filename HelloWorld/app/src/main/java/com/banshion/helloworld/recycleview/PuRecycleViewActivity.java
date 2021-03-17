package com.banshion.helloworld.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.banshion.helloworld.R;

public class PuRecycleViewActivity extends AppCompatActivity {

    public RecyclerView m_RvPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycle_view);
        m_RvPu = findViewById(R.id.rv_pu);
        //垂直两列
        m_RvPu.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        m_RvPu.setAdapter(new StaggeredGridAdapter(this, null));

    }
}