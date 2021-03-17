package com.banshion.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.banshion.helloworld.datastorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button m_UIBtn, m_EventBtn,m_DataStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        m_UIBtn = findViewById(R.id.ui);
        m_EventBtn = findViewById(R.id.event);
        m_DataStorage = findViewById(R.id.data_storage);
        m_UIBtn.setOnClickListener(this);
        m_EventBtn.setOnClickListener(this);
        m_DataStorage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.ui:
                intent = new Intent(MainActivity.this, UIActivity.class);
                break;
            case R.id.event:
                intent = new Intent(MainActivity.this, EventActivity.class);
                break;
            case R.id.data_storage:
                intent = new Intent(MainActivity.this, DataStorageActivity.class);
                break;
        }
        startActivity(intent);
    }


}