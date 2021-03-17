package com.banshion.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.banshion.helloworld.utils.ToastUtil;

public class HandleActivity extends AppCompatActivity {
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle);


//        handler = new Handler();
//        handler.postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                Intent intent = new Intent(HandleActivity.this, ButtonActivity.class);
//                startActivity(intent);
//            }
//        }, 3000);


        handler = new Handler() {
            //处理消息
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        ToastUtil.showMsg(HandleActivity.this, "线程通信成功!");
                        break;
                }
            }
        };


        new Thread() {
            @Override
            public void run() {
                super.run();
                Message message = new Message();
                message.what = 1;
                //发送消息
                handler.sendMessage(message);
            }
        }.start();



    }
}