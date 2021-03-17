package com.banshion.firstcode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.banshion.firstcode.lifecycle.DialogActivity;
import com.banshion.firstcode.lifecycle.NormalActivity;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";

    private Button startNormalActivity;
    private Button startDialogActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (null != savedInstanceState) {
            String tempData = savedInstanceState.getString("data_key");
            Log.d(TAG, "onCreate: " + tempData);
        }

        startNormalActivity = findViewById(R.id.start_normal_activity);
        startDialogActivity = findViewById(R.id.start_dialog_actvity);
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });
        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 这个方法在活动由不可见变为可见的时候调用。
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    /**
     * 这个方法在活动准备好和用户进行交互的时候调用。此时的活动一定位于
     * 返回栈的栈顶，并且处于运行状态。
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    /**
     * 这个方法在系统准备去启动或者恢复另一个活动的时候调用。我们通常会在
     * 这个方法中将一些消耗CPU的资源释放掉，以及保存一些关键数据，但这个方法的执行
     * 速度一定要快，不然会影响到新的栈顶活动的使用。
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    /**
     * 这个方法在活动完全不可见的时候调用。它和onPause( )方法的主要区别在
     * 于，如果启动的新活动是-一个对话框式的活动，那么onPause()方法 会得到执行，而
     * onStop()方法并不会执行。
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    /**
     * onDestroy()。这个方法在活动被销毁之前调用，之后活动的状态将变为销毁状态。
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    /**
     * 这个方法在活动由停止状态变为运行状态之前调用，也就是活动被重新启动了
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    /**
     * 活动MainActivity中是可能存在临时数据和状态的。打个比方，MainActivity 中有一个文本输人框，
     * 现在你输人了一段文字，然后启动
     * NormalActivity,这时MainActivity由于系统内存不足被回收掉，过了一会你又点击了Back 键回
     * 到MainActivity，你会发现刚刚输人的文字全部都没了，因为MainActivity被重新创建了。
     * 如果我们的应用出现了这种情况，是会严重影响用户体验的，所以必须要想想办法解决这个
     * 问题。查阅文档可以看出，Activity 中还提供了一个onSaveInstanceState()回调方法，这个方
     * 法可以保证在活动被回收之前一定会被调用,因此我们可以通过这个方法来解决活动被回收时临
     * 时数据得不到保存的问题。
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "Something you just typed";
        outState.putString("data_key", tempData);
        /**
         * 数据是已经保存下来了，那么我们应该在哪里进行恢复呢?细心的你也许早就发现，我们一一
         * 直使用的onCreate()方法其实也有一个Bundle类型的参数。这个参数在一般情况下都是null,
         * 但是如果在活动被系统回收之前有通过onSaveIns tanceState( )方法来保存数据的话，这个参
         * 数就会带有之前所保存的全部数据，我们只需要再通过相应的取值方法将数据取出即可。
         */
    }
}