package com.banshion.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {
    private TextView m_Tv3, m_Tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        m_Tv3 = findViewById(R.id.tv_3);
        m_Tv3.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中划线
        m_Tv3.getPaint().setAntiAlias(true);//去除锯齿

        m_Tv4 = findViewById(R.id.tv_4);
        m_Tv4.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

    }
}