package com.banshion.helloworld.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private static Toast toast;

    public static void showMsg(Context context, String msg) {
        if (null == toast) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
}
