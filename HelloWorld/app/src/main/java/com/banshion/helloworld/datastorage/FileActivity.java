package com.banshion.helloworld.datastorage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.banshion.helloworld.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {

    private Button m_Save, m_Show;
    private EditText m_InputText;
    private TextView m_TextShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        m_Save = findViewById(R.id.save);
        m_Show = findViewById(R.id.show);
        m_InputText = findViewById(R.id.edit_text);
        m_TextShow = findViewById(R.id.show_text);

        m_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v_InputText = m_InputText.getText().toString();
                save(v_InputText);
            }
        });

        m_Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_TextShow.setText(read());
            }
        });

    }

    public void save(String txt) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput("txt.txt", MODE_PRIVATE);
            fileOutputStream.write(txt.getBytes());
        } catch (IOException e) {

        }finally {
            try {
                if (null != fileOutputStream) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    public String read() {
        try {
            FileInputStream fileInputStream = openFileInput("txt.txt");
            byte[] buff = new byte[1024];
            int len = 0;
            StringBuilder sb = new StringBuilder();
            while ((len = fileInputStream.read(buff)) > 0) {
                sb.append(new String(buff, 0, len));
                Log.d("FILE", sb.toString());
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}