package com.banshion.helloworld.datastorage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.banshion.helloworld.R;

public class SharedPreferencesActivity extends AppCompatActivity {

    private Button m_Save, m_Show;
    private EditText m_InputText;
    private TextView m_TextShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        m_Save = findViewById(R.id.save);
        m_Show = findViewById(R.id.show);
        m_InputText = findViewById(R.id.edit_text);
        m_TextShow = findViewById(R.id.show_text);
        SharedPreferences data = getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor edit = data.edit();

        m_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v_InputText = m_InputText.getText().toString();
                edit.putString("key", v_InputText);
                edit.apply();
            }
        });

        m_Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_TextShow.setText(data.getString("key", ""));
            }
        });

    }
}