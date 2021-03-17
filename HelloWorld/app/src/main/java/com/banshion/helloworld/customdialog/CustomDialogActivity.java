package com.banshion.helloworld.customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.banshion.helloworld.R;

import widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button m_CustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);


        m_CustomDialog = findViewById(R.id.custom_dialog_btn);
        m_CustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("提示").setMessage("确认删除此项？").setCancel("取消", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {

                    }
                }).setConfirm("确认", new CustomDialog.IOnConfirmListener() {
                    @Override
                    public void onConfirm(CustomDialog dialog) {

                    }
                }).show();
            }
        });
    }
}