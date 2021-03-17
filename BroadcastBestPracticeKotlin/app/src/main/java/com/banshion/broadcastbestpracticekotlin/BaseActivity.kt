package com.banshion.broadcastbestpracticekotlin

import android.content.*
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

/**
 * 所有Activity基类
 */
open class BaseActivity : AppCompatActivity() {

    lateinit var receiver: ForceOfflineReceiver

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        ActivityCollector.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    override fun onResume() {
        super.onResume()
        //只有Activity处于栈顶时才接收广播
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.banshion.broadcastbestpracticekotlin.FORCE_OFFLINE")
        receiver = ForceOfflineReceiver()
        registerReceiver(receiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    inner class ForceOfflineReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (context != null) {
                AlertDialog.Builder(context).apply {
                    setTitle("Warning!")
                    setMessage("You are forced to be offline. Please try to login again.")
                    setCancelable(false)
                    setPositiveButton("OK"){_, _ ->
                        ActivityCollector.finishAll()
                        val i = Intent(context, LoginActivity::class.java)
                        context.startActivity(i)
                    }
                    show()
                }
            }
        }

    }
}