package com.banshion.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    private EditText m_UserName, m_Password;

    private Button m_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_activity);

        m_UserName = findViewById(R.id.UserName);
        m_Password = findViewById(R.id.Password);
        m_UserName.setEnabled(true);
        m_Password.setEnabled(true);

        m_UserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        m_Login = findViewById(R.id.Login);
        m_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
            }
        });

    }
}