package com.banshion.helloworld.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.banshion.helloworld.R;
import com.banshion.helloworld.utils.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        btn1 = findViewById(R.id.btn_toast1);
        btn2 = findViewById(R.id.btn_toast2);
        btn3 = findViewById(R.id.btn_toast3);
        btn4 = findViewById(R.id.btn_toast4);
        OnClick onClick = new OnClick();
        btn1.setOnClickListener(onClick);
        btn2.setOnClickListener(onClick);
        btn3.setOnClickListener(onClick);
        btn4.setOnClickListener(onClick);
    }


    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_toast1:
                    Toast.makeText(ToastActivity.this, "默认Toast", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_toast2:
                    Toast toast = Toast.makeText(ToastActivity.this, "居中Toast", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    break;
                case R.id.btn_toast3:
                    Toast toast1 = new Toast(ToastActivity.this);
                    LayoutInflater from = LayoutInflater.from(ToastActivity.this);
                    View view = from.inflate(R.layout.layout_toast, null);
                    ImageView imageView = view.findViewById(R.id.t_img);
                    TextView textView = view.findViewById(R.id.t_text);
                    imageView.setImageResource(R.drawable.success);
                    textView.setText("success!");
                    toast1.setView(view);
                    toast1.setDuration(Toast.LENGTH_SHORT);
                    toast1.show();
                    break;
                case R.id.btn_toast4:
                    ToastUtil.showMsg(ToastActivity.this, "HELLO!");
                    break;
            }
        }
    }
}