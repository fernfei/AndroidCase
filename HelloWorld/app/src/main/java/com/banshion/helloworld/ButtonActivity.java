package com.banshion.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    private Button m_Btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        m_Btn3 = findViewById(R.id.Btn3);
        m_Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "你点击了按钮3", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showToast(View view) {
        Toast.makeText(this, "你点击了按钮4", Toast.LENGTH_SHORT).show();
    }
}