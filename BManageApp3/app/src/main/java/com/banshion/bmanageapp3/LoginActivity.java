package com.banshion.bmanageapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.banshion.bmanageapp3.utils.DrawableUtil;
import com.banshion.bmanageapp3.utils.ToastUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginActivity extends AppCompatActivity{
    private TextView m_TvLoginText;
    private EditText m_Phone;
    private EditText m_Pwd;
    private EditText m_Code;
    private ImageView m_LoginBtn;
    private static Drawable m_ClearImg = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        m_TvLoginText = findViewById(R.id.tv_login_text);
        m_Phone = findViewById(R.id.phone);
        m_Pwd = findViewById(R.id.pwd);
        m_Code = findViewById(R.id.code);
        m_LoginBtn = findViewById(R.id.btn_login);
        m_TvLoginText.getPaint().setFakeBoldText(true);

        m_ClearImg = getResources().getDrawable(R.drawable.clear);

        m_ClearImg.setBounds(0, 0, 20, 20);

        Drawable v_PhoneImg = getResources().getDrawable(R.drawable.phone);
        v_PhoneImg.setBounds(0, 0, 30, 30);

        m_Phone.setCompoundDrawables(v_PhoneImg, null, null, null);
        m_Phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!m_Phone.getText().toString().trim().equals("")) {
                    m_Phone.setCompoundDrawables(v_PhoneImg, null, m_ClearImg, null);
                } else {
                    m_Phone.setCompoundDrawables(v_PhoneImg, null, null, null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Drawable v_PwdImg = getResources().getDrawable(R.drawable.pwd);
        v_PwdImg.setBounds(0, 0, 30, 30);
        m_Pwd.setCompoundDrawables(v_PwdImg, null, null, null);
        m_Pwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!m_Pwd.getText().toString().trim().equals("")) {
                    m_Pwd.setCompoundDrawables(v_PwdImg, null, m_ClearImg, null);
                } else {
                    m_Pwd.setCompoundDrawables(v_PwdImg, null, null, null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Drawable v_CodeImg = getResources().getDrawable(R.drawable.code);
        v_CodeImg.setBounds(0, 0, 30, 30);
        m_Code.setCompoundDrawables(v_PhoneImg, null, null, null);
        m_Code.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!m_Code.getText().toString().trim().equals("")) {
                    m_Code.setCompoundDrawables(v_CodeImg, null, m_ClearImg, null);
                } else {
                    m_Code.setCompoundDrawables(v_CodeImg, null, null, null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        new DrawableUtil(m_Phone, new DrawableUtil.OnDrawableListener() {
            @Override
            public void onRight(View v, Drawable right) {
                m_Phone.setText("");
            }
        });

        new DrawableUtil(m_Pwd, new DrawableUtil.OnDrawableListener() {
            @Override
            public void onRight(View v, Drawable right) {
                m_Pwd.setText("");
            }
        });

        new DrawableUtil(m_Code, new DrawableUtil.OnDrawableListener() {
            @Override
            public void onRight(View v, Drawable right) {
                m_Code.setText("");
            }
        });



        /*登录*/
        m_LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, IndexActivity.class));
                ToastUtils.showMsg(LoginActivity.this, "登陆成功");
            }
        });

    }

}