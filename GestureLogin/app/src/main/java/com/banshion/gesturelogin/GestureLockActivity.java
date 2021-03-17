package com.banshion.gesturelogin;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;


import com.banshion.gesturelogin.base.BaseActivity;
import com.banshion.gesturelogin.gesture.GestureLockLayout;
import com.banshion.gesturelogin.utils.Constants;
import com.banshion.gesturelogin.utils.PreferenceUtils;
import com.banshion.gesturelogin.utils.ToastUtil;
import com.banshion.gesturelogin.utils.ToolUtils;

import javax.crypto.Cipher;


/**
 * @author：PengJunShan.

 * 时间：On 2019-04-26.

 * 描述：解锁
 */
public class GestureLockActivity extends BaseActivity {
  GestureLockLayout mGestureLockLayout;
  TextView hintTV;
  TextView name;
  private Context mContext;
  private Animation animation;

  /**
   * 最大解锁次数
   */
  private int mNumber = 5;
  /**
   * change:修改手势  login:登录
   */
  private String type;

  /**
   * true:设置   false:未设置
   */
  private Boolean isFingerprint, isGesture;

  private Cipher cipher;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_gesture_lock);
    initView();
  }

  protected void initView() {
    mGestureLockLayout = findViewById(R.id.gestureLock);
    hintTV = findViewById(R.id.hintTV);
    name = findViewById(R.id.name);
    mContext = this;

    type = getIntent().getStringExtra("type");
    isGesture = PreferenceUtils.getBoolean(Constants.ISGESTURELOCK_KEY, false);
    if (isGesture) {
      setGestureListener();
    }
  }


  private void setGestureListener() {
    String gestureLockPwd = PreferenceUtils.getString(Constants.GESTURELOCK_KEY, "");
    if (!TextUtils.isEmpty(gestureLockPwd)) {
      mGestureLockLayout.setAnswer(gestureLockPwd);
    } else {
      ToastUtil.showMsg(this, "您没有设置过手势密码", Toast.LENGTH_SHORT);
    }
    mGestureLockLayout.setDotCount(3);
    mGestureLockLayout.setMode(GestureLockLayout.VERIFY_MODE);
    //设置手势解锁最大尝试次数 默认 5
    mGestureLockLayout.setTryTimes(5);
    animation = AnimationUtils.loadAnimation(this, R.anim.shake);
    mGestureLockLayout.setOnLockVerifyListener(new GestureLockLayout.OnLockVerifyListener() {
      @Override
      public void onGestureSelected(int id) {
        //每选中一个点时调用
      }

      @Override
      public void onGestureFinished(boolean isMatched) {
        //绘制手势解锁完成时调用
        if (isMatched) {
          if ("change".equals(type)) {
            startActivity(MainActivity.class);
          } else if ("login".equals(type)) {
            startActivity(MainActivity.class);
          }
          finish();
        } else {
          hintTV.setVisibility(View.VISIBLE);
          mNumber = --mNumber;
          hintTV.setText("你还有" + mNumber + "次机会");
          hintTV.startAnimation(animation);
          mGestureLockLayout.startAnimation(animation);
          ToolUtils.setVibrate(mContext);
        }
        resetGesture();
      }

      @Override
      public void onGestureTryTimesBoundary() {
        //超出最大尝试次数时调用
        mGestureLockLayout.setTouchable(false);
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

}
