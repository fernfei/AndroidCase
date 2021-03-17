package com.banshion.firstcode.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.banshion.firstcode.R;

public class NormalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_layout);
    }

}