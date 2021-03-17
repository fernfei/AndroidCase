package com.banshion.gesturelogin.base;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


/**
 * 作者：PengJunShan.
 *
 * 时间：On 2019-04-22.
 *
 * 描述：
 */
public class BaseActivity extends AppCompatActivity {



  /**
   * 不携带数据的页面跳转
   */
  public void startActivity(Class<?> clz) {
    startActivity(clz, null);
  }

  /**
   * 携带数据的页面跳转
   */
  public void startActivity(Class<?> clz, Bundle bundle) {
    Intent intent = new Intent();
    intent.setClass(this, clz);
    if (bundle != null) {
      intent.putExtras(bundle);
    }
    startActivity(intent);
  }

  /**
   * 有回调的跳转
   */
  public void startActivityForResult(Class<?> cls, Bundle bundle,
                                     int requestCode) {
    Intent intent = new Intent();
    intent.setClass(this, cls);
    if (bundle != null) {
      intent.putExtras(bundle);
    }
    startActivityForResult(intent, requestCode);
  }

}
