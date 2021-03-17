package com.banshion.activitylifecycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    //Activity第一次被创建
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tempData = savedInstanceState?.getString("data_key")
        Log.d(TAG, "onCreate:$tempData")
        startNormalActivity.setOnClickListener{
            val intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
        }
        startDialogActivity.setOnClickListener{
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
    }
    //Activity由不可见变为可见的时候调用
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }
    //Activity准备好和用户进行交互的时候调用，此时Activity一定位于返回栈的栈顶，并且处于运行时状态
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }
    //这个方法系统装备去启动或者恢复另一个Activity的时候调用
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }
    //这个方法会在Activity完全不可见的时候被调用，它和onPause()方法的主要区别在于，如果启动的新Activity是一个对话框式的Activity，那么onPause方法会得到执行，而onStop()并不会执行
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }
    //Activity被销毁之前调用，之后Activity的状态将变为销毁状态
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
    //Activity由停止状态变为运行状态之前调用，也就是Activity被重新启动了
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }
    //保证Activity被回收之前一定会被调用
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        val tempData = "Something you just typed"
        outState.putString("data_key", tempData)
    }
}