package com.banshion.firstcode;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d("SecondActivity", "onCreate: " + data);
        button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 可以看到，我们构建了一个Intent,只不过这个Intent 仅仅是用于传递数据而已，它没
                 * 有指定任何的“意图”。紧接着把要传递的数据存放在Intent中,然后调用了setResult()方法。
                 * 这个方法非常重要，是专门用于向上一个活动返回数据的。setResult()方法接收两个参数,
                 * 第一个参数用于向上一个活动返回处理结果，一般只使用RESULT_ _OK 或RESULT_ _CANCELED 这
                 * 两个值，第二个参数则把带有数据的Intent传递回去，然后调用了finish()方法 来销毁当前活
                 * 动。
                 */
//                Intent intent1 = new Intent();
//                intent1.putExtra("data_return", "Hello FirstActivity");
//                setResult(RESULT_OK, intent1);
//                finish();

                startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent1 = new Intent();
        intent1.putExtra("data_return", "Hello FirstActivity");
        setResult(RESULT_OK, intent1);
        finish();
    }

    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }
}