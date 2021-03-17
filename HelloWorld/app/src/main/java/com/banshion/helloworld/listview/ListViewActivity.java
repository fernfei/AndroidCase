package com.banshion.helloworld.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.banshion.helloworld.R;

public class ListViewActivity extends AppCompatActivity {
    private ListView m_Lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        m_Lv = findViewById(R.id.lv);
        m_Lv.setAdapter(new MyAdapter(this));
        m_Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "1111111111", Toast.LENGTH_SHORT).show();
            }
        });
    }
}