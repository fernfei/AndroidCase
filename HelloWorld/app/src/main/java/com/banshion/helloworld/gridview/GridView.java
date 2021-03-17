package com.banshion.helloworld.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.banshion.helloworld.R;

public class GridView extends AppCompatActivity {

    private android.widget.GridView m_GridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        m_GridView = findViewById(R.id.gv);
        m_GridView.setAdapter(new GridAdapter(this));
    }
}