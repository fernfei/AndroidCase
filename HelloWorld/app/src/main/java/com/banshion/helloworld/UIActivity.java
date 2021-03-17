package com.banshion.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.banshion.helloworld.Toast.ToastActivity;
import com.banshion.helloworld.alertdialog.AlertDialogActivity;
import com.banshion.helloworld.customdialog.CustomDialogActivity;
import com.banshion.helloworld.fragment.ContainerActivity;
import com.banshion.helloworld.gridview.GridView;
import com.banshion.helloworld.listview.ListViewActivity;
import com.banshion.helloworld.progress.ProgressActivity;
import com.banshion.helloworld.recycleview.RecycleView;
import com.banshion.helloworld.webview.WebViewActivity;

public class UIActivity extends AppCompatActivity {

    private Button mBtnTextView,m_Btn2,m_Btn3, m_Btn4,m_Btn5,m_Btn6,m_Btn7,m_Btn8,webView,toast,alertDialog,progress,customDialog,fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mBtnTextView = findViewById(R.id.Btn);
        m_Btn2 = findViewById(R.id.Btn2);
        m_Btn3 = findViewById(R.id.Btn3);
        m_Btn4 = findViewById(R.id.Btn4);
        m_Btn5 = findViewById(R.id.Btn5);
        m_Btn6 = findViewById(R.id.Btn6);
        m_Btn7 = findViewById(R.id.Btn7);
        m_Btn8 = findViewById(R.id.Btn8);
        webView = findViewById(R.id.webView);
        toast = findViewById(R.id.toast);
        alertDialog = findViewById(R.id.alert_dialog);
        progress = findViewById(R.id.progress);
        customDialog = findViewById(R.id.custom_dialog);
        fragment = findViewById(R.id.fragment);
        setOnClick();
    }

    public void setOnClick() {
        OnClick onClick = new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        m_Btn2.setOnClickListener(onClick);
        m_Btn3.setOnClickListener(onClick);
        m_Btn4.setOnClickListener(onClick);
        m_Btn5.setOnClickListener(onClick);
        m_Btn6.setOnClickListener(onClick);
        m_Btn7.setOnClickListener(onClick);
        m_Btn8.setOnClickListener(onClick);
        webView.setOnClickListener(onClick);
        toast.setOnClickListener(onClick);
        alertDialog.setOnClickListener(onClick);
        progress.setOnClickListener(onClick);
        customDialog.setOnClickListener(onClick);
        fragment.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        Intent intent;
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.Btn:
                    intent=new Intent(UIActivity.this, TextViewActivity.class);
                    break;
                case R.id.Btn2:
                    intent = new Intent(UIActivity.this, ButtonActivity.class);
                    break;
                case R.id.Btn3:
                    intent = new Intent(UIActivity.this, EditActivity.class);
                    break;
                case R.id.Btn4:
                    intent = new Intent(UIActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.Btn5:
                    intent = new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                case R.id.Btn6:
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.Btn7:
                    intent = new Intent(UIActivity.this, GridView.class);
                    break;
                case R.id.Btn8:
                    intent = new Intent(UIActivity.this, RecycleView.class);
                    break;
                case R.id.webView:
                    intent = new Intent(UIActivity.this, WebViewActivity.class);
                    break;
                case R.id.toast:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.alert_dialog:
                    intent = new Intent(UIActivity.this, AlertDialogActivity.class);
                    break;
                case R.id.progress:
                    intent = new Intent(UIActivity.this, ProgressActivity.class);
                    break;
                case R.id.custom_dialog:
                    intent = new Intent(UIActivity.this, CustomDialogActivity.class);
                    break;
                case R.id.fragment:
                    intent = new Intent(UIActivity.this, ContainerActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}


