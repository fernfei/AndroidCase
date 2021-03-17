package com.banshion.helloworld.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.banshion.helloworld.R;

public class DataStorageActivity extends AppCompatActivity {
    private Button m_SharedPreferences;
    private Button m_File;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        m_SharedPreferences = findViewById(R.id.shared_preferences);
        m_File = findViewById(R.id.file);
        m_SharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataStorageActivity.this, SharedPreferencesActivity.class));
            }
        });
        m_File.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataStorageActivity.this, FileActivity.class));
            }
        });
    }
}