package com.banshion.gesturelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.banshion.gesturelogin.base.BaseActivity;
import com.banshion.gesturelogin.gesture.GestureLockDisplayView;
import com.banshion.gesturelogin.gesture.GestureLockLayout;
import com.banshion.gesturelogin.utils.Constants;
import com.banshion.gesturelogin.utils.PreferenceUtils;
import com.banshion.gesturelogin.utils.ToolUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    GestureLockDisplayView mLockDisplayView;
    TextView mSettingHintText;
    GestureLockLayout mGestureLockLayout;
    TextView reSet;
    TextView hintTV;
    private Animation animation;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_login);
        initView();
    }


    private void initView() {

        mLockDisplayView = findViewById(R.id.display_view);
        mSettingHintText = findViewById(R.id.setting_hint);
        mGestureLockLayout = findViewById(R.id.gesture_view);
        reSet = findViewById(R.id.reSet);
        hintTV = findViewById(R.id.hintTV);
        reSet.setOnClickListener(this);
        mContext = this;

        //设置提示view 每行每列点的个数
        mLockDisplayView.setDotCount(3);
        //设置提示view 选中状态的颜色
        mLockDisplayView.setDotSelectedColor(Color.parseColor("#01367A"));
        //设置提示view 非选中状态的颜色
        mLockDisplayView.setDotUnSelectedColor(Color.parseColor("#999999"));
        //设置手势解锁view 每行每列点的个数
        mGestureLockLayout.setDotCount(3);
        //设置手势解锁view 最少连接数
        mGestureLockLayout.setMinCount(4);
        //设置手势解锁view 模式为重置密码模式
        mGestureLockLayout.setMode(GestureLockLayout.RESET_MODE);
        //初始化动画
        animation = AnimationUtils.loadAnimation(this, R.anim.shake);
        initEvents();
    }

    private void initEvents() {

        mGestureLockLayout.setOnLockResetListener(new GestureLockLayout.OnLockResetListener() {
            @Override
            public void onConnectCountUnmatched(int connectCount, int minCount) {
                //连接数小于最小连接数时调用
                mSettingHintText.setText("最少连接" + minCount + "个点");
                resetGesture();
            }

            @Override
            public void onFirstPasswordFinished(List<Integer> answerList) {
                //第一次绘制手势成功时调用
                Log.e("TAG","第一次密码=" + answerList);
                mSettingHintText.setText("确认解锁图案");
                //将答案设置给提示view
                mLockDisplayView.setAnswer(answerList);
                //重置
                resetGesture();
            }

            @Override
            public void onSetPasswordFinished(boolean isMatched, List<Integer> answerList) {
                //第二次密码绘制成功时调用
                Log.e("TAG","第二次密码=" + answerList.toString());
                if (isMatched) {
                    //两次答案一致，保存
                    PreferenceUtils.commitString(Constants.GESTURELOCK_KEY, answerList.toString());
                    setResult(RESULT_OK);
                    finish();
                } else {
                    hintTV.setVisibility(View.VISIBLE);
                    ToolUtils.setVibrate(mContext);
                    hintTV.startAnimation(animation);
                    mGestureLockLayout.startAnimation(animation);
                    resetGesture();
                }
            }
        });
    }

    /**
     * 重置手势布局（只是布局）
     */
    private void resetGesture() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mGestureLockLayout.resetGesture();
            }
        }, 300);
    }

    /**
     * 重置手势布局（布局加逻辑）
     */
    @Override
    public void onClick(View v) {
        mGestureLockLayout.setOnLockResetListener(null);
        mSettingHintText.setText("绘制解锁图案");
        mLockDisplayView.setAnswer(new ArrayList<Integer>());
        mGestureLockLayout.resetGesture();
        mGestureLockLayout.setMode(GestureLockLayout.RESET_MODE);
        hintTV.setVisibility(View.INVISIBLE);
        initEvents();
    }
}