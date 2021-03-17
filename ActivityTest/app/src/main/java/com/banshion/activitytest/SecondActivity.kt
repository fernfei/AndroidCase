package com.banshion.activitytest

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val extraData = intent.getStringExtra("extra_data")
        Log.d("SecondActivity", "extra data is $extraData")
        button2.setOnClickListener{
            val intent = Intent()
            intent.putExtra("data_return", "Hello FirstActivity")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
    //back键返回FirstActivity
    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return", "Hello FirstActivity")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
    //相当于java的静态方法定义
    companion object{
        fun actionStart(context: Context, data1: String, data2: String) {
            val intent = Intent(context, SecondActivity::class.java)
            context.startActivity(intent)
        }
    }
}