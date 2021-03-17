package com.banshion.helloworld.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.banshion.helloworld.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnSendMessage {

    private AFragment aFragment;
    private Button btnChange;
    private BFragment bFragment;
    private TextView m_TvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        m_TvTitle = findViewById(R.id.text);
//        btnChange = findViewById(R.id.btn_change);
//        btnChange.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null == bFragment) {
//                    bFragment = new BFragment();
//                }
//
//                getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).commitAllowingStateLoss();
//            }
//        });

        aFragment = AFragment.newInstance("传参AFragment");
        //tag用于表示，让用户返回时，不再重新加载视图
        getFragmentManager().beginTransaction().add(R.id.fl_container, aFragment,"a").commitAllowingStateLoss();
    }


    public void senData(String text) {
        m_TvTitle.setText(text);
    }

    @Override
    public void sandData(String text) {
        m_TvTitle.setText(text);
    }
}