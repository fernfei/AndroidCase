package com.banshion.gesturelogin.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private static Toast m_Toast;

    public static void showMsg(Context context,String msg,int duration) {
        if (null == m_Toast) {
            m_Toast = Toast.makeText(context, msg, duration);
        } else {
            m_Toast.setText(msg);
        }
        m_Toast.show();
    }
}
