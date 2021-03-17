package com.banshion.helloworld.progress;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.banshion.helloworld.R;
import com.banshion.helloworld.utils.ToastUtil;

public class ProgressActivity extends AppCompatActivity {

    private Button btnStart,progressDialog1, progressDialog2;
    private ProgressBar progressBar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        btnStart = findViewById(R.id.btn_start);
        progressBar3 = findViewById(R.id.p3);
        progressDialog1 = findViewById(R.id.btn_progress1);
        progressDialog2 = findViewById(R.id.btn_progress2);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送消息
                handler.sendEmptyMessage(0);
            }
        });
        progressDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载...");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.showMsg(ProgressActivity.this,"cancel...");
                    }
                });
//                progressDialog.setCancelable(false);
                progressDialog.show();
            }
        });

        progressDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                //进度条样式
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在下载...");
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        
                    }
                });
                progressDialog.show();

            }
        });
    }

    Handler handler = new Handler() {
        //处理消息
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (progressBar3.getProgress() < 100) {
                //延迟处理
                handler.postDelayed(runnable, 500);
            } else {
                ToastUtil.showMsg(ProgressActivity.this, "加载完成");
            }
        }
    };


    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            progressBar3.setProgress(progressBar3.getProgress() + 5);
            //发送消息
            handler.sendEmptyMessage(0);
        }
    };
}