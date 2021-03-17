package com.banshion.helloworld.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.banshion.helloworld.R;

public class HorRecycleViewActivity extends AppCompatActivity {

    private RecyclerView m_RvHor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_recycle_view);
        m_RvHor = findViewById(R.id.rv_hor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        m_RvHor.setLayoutManager(linearLayoutManager);
        m_RvHor.setAdapter(new HorAdapter(this, null));

    }
}