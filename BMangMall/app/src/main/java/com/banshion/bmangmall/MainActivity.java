package com.banshion.bmangmall;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.banshion.bmangmall.utils.ToastUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                EditText userName = findViewById(R.id.username_et);
                EditText password = findViewById(R.id.password_et);
                if ("admin".equals(userName.getText().toString()) && "admin".equals(password.getText().toString())) {
                    ToastUtil.showMsg(MainActivity.this, "登录成功", Toast.LENGTH_SHORT);
                } else {
                    ToastUtil.showMsg(MainActivity.this, "登录失败", Toast.LENGTH_SHORT);
                }
                break;
            default:
                break;
        }
    }
}