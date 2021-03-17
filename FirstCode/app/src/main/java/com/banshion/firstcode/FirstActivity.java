package com.banshion.firstcode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FirstActivity.this, "You Clicked Button 1", Toast.LENGTH_SHORT).show();
//                显示intent跳转

                SecondActivity.actionStart(FirstActivity.this, "1", "2");
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                intent.putExtra("extra_data", "Hello SecondActivity");
//                startActivity(intent);
                /**
                 * requestCode大于0时 当activity退出时会在onActivityResult()返回数据
                 *
                 * 由于我们是使用startActivityForResult()方法来启动SecondActivity的，在SecondActivity
                 * 被销毁之后会回调上一个活动的onActivityResult()方法，因此我们需要在FirstActivity中重
                 * 写这个方法来得到返回的数据
                 */
//                startActivityForResult(intent, 1);
                /**
                 * 隐式Intent跳转
                 * 隐式跳转要同时匹配上要跳转的<action></action>、<category></category>
                 * 当要跳转的action的<category></category>设置成DEFAULT 时则不需要将category传入到Intent中去
                 *
                 * 每个Intent只能指定<action></action>,但是可以指定多个<cagegory></cagegory>
                 */
//                Intent intent = new Intent("com.banshion.activitytest.ACTION_START");
//                intent.addCategory("com.banshion.activitytest.MY_CATEGORY");
//                startActivity(intent);


                //intent 不仅可以启动自己程序内的活动还可以启动其他程序的活动

                //Intent.ACTION_VIEW 是Android系统内部的动作
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.banshion.com"));
//                startActivity(intent);

                //intent调用系统拨号界面
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
//                startActivity(intent);


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You Clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You Clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    /***
     * onActivityResult()方法带有三个参数，第一个参数requestCode,即我们在启动活动时
     * 传入的请求码。第二个参数resultCode, 即我们在返回数据时传入的处理结果。第三个参数
     * data，即携带着返回数据的Intent。由于在一个活动中有可能调用startActivityForResult()
     * 方法去启动很多不同的活动,每一个活动返回的数据都会回调到onActivityResult()这个方法
     * 中，因此我们首先要做的就是通过检查requestCode的值来判断数据来源。确定数据是从
     * SecondActivity返回的之后,我们再通过resultCode的值来判断处理结果是否成功。最后从data
     * 中取值并打印出来，这样就完成了向上一个活动返回数据的工作。
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String v_ReturnData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", "onActivityResult: " + v_ReturnData);
                }
                break;
            default:
        }
    }
}