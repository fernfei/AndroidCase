package com.banshion.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.banshion.helloworld.utils.ToastUtil;

import widget.MyButton;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{

    private Button m_Btn;
    private MyButton myButton;
    private Button m_Btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
//        m_Btn = findViewById(R.id.click_me);
        myButton = findViewById(R.id.my_button);
        m_Btn2 = findViewById(R.id.handle);
        //第一种设置点击事件
//        m_Btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showMsg(EventActivity.this,"1你点你马呢？");
//            }
//        });
        //第二种设置点击事件
       // m_Btn.setOnClickListener(this);
        m_Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, HandleActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onClick(View v) {
        ToastUtil.showMsg(EventActivity.this,"2你点你马呢？");
    }

    public void OnClick(View view) {
        ToastUtil.showMsg(EventActivity.this,"3你点你马呢？");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("EventActivity", "EventActivity--onTouchEvent事件触发");
                break;
        }
        return super.onTouchEvent(event);
    }
}