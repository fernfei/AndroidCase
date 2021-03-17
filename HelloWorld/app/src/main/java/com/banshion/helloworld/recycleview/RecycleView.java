package com.banshion.helloworld.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.banshion.helloworld.R;

public class RecycleView extends AppCompatActivity {

    private Button m_BtnLinear, m_BtnHor, m_BtnGrid,m_BtnPu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        m_BtnLinear = findViewById(R.id.btn_linear);
        m_BtnHor = findViewById(R.id.btn_hor);
        m_BtnGrid = findViewById(R.id.btn_grid);
        m_BtnPu = findViewById(R.id.btn_pu);
        m_BtnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleView.this, LinearRecycleView.class);
                startActivity(intent);
            }
        });
        m_BtnHor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleView.this, HorRecycleViewActivity.class);
                startActivity(intent);
            }
        });

        m_BtnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleView.this, GridRecycleActivity.class);
                startActivity(intent);
            }
        });

        m_BtnPu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleView.this, PuRecycleViewActivity.class);
                startActivity(intent);
            }
        });

    }
}