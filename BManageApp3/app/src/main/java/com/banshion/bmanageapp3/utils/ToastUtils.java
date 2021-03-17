package com.banshion.bmanageapp3.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
    private static Toast m_Toast;


    public static void showMsg(Context context, String msg) {
        if(null==m_Toast)
            m_Toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        else
            m_Toast.setText(msg);
        m_Toast.show();
    }
}
