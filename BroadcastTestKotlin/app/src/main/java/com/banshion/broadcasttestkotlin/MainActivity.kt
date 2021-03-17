package com.banshion.broadcasttestkotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var timerChangeReceiver: TimeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentFilter = IntentFilter()
        //监听系统时间变化广播
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timerChangeReceiver = TimeChangeReceiver()
        registerReceiver(timerChangeReceiver, intentFilter)

        sendBroadcast.setOnClickListener{
            val intent=Intent("com.example.broadcasttest.MY_BROADCAST")
            /**
             * 在Android 8.0系统之后，静态注册的BroadcastReceiver是无法接收隐式广播的，
             * 而默认情况下我们发出的自定义广播恰恰都是隐式广播。
             * 因此这里一定要调用setPackage()方法，指定这条广播是发送给哪个应用程序的，从而让它变成一条显式广播，
             * 否则静态注册的BroadcastReceiver将无法接收到这条广播。
             */
            intent.setPackage(packageName)
//            sendBroadcast(intent)发送标准广播
            //发送有序广播第一个参数仍然是Intent；第二个参数是一个与权限相关的字符串，这里传入null就行了
            sendOrderedBroadcast(intent, null)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timerChangeReceiver)
    }

    inner class TimeChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "Time has changed", Toast.LENGTH_SHORT).show()
        }

    }
}