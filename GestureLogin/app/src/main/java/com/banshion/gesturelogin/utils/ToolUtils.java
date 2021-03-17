package com.banshion.gesturelogin.utils;

import android.app.Service;
import android.content.Context;
import android.os.Vibrator;

/**
 * @author ：hufei.
 * @date: 2021-03-08
 */
public class ToolUtils {


  /**
   * dp转px
   */
  public static int dp2px(Context context, float dpValue) {
    float scale = context.getResources().getDisplayMetrics().density;
    return (int) (dpValue * scale + 0.5f);
  }

  /**
   * 震动
   * @param context
   */
  public static void setVibrate(Context context) {
    Vibrator vib = (Vibrator) context.getSystemService(Service.VIBRATOR_SERVICE);
    vib.vibrate(300);
  }


}
