package com.banshion.uibestpractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List msgList = new ArrayList<Msg>();
    private MsgAdapter adapter;
    private RecyclerView recyclerView;
    private EditText inputText;
    private Button send;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleView);
        send = findViewById(R.id.send);
        inputText = findViewById(R.id.inputText);
        initMsg();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        recyclerView.setAdapter(adapter);
        send.setOnClickListener(this);
    }

    private void initMsg() {
        Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("This is Tom. Nice talking to you.", Msg.TYPE_RECEIVED);
        msgList.add(msg3);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send:

                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1);//当有新消息时刷新RecycleView中的现实
                    recyclerView.scrollToPosition(msgList.size() - 1);//将RecycleView定位到最后一行
                    inputText.setText("");

                }
                break;
        }
    }
}
