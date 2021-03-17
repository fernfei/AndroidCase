 package com.banshion.activitytest

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.first_layout.*

 class FirstActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //向当前activity加载一个布局
        setContentView(R.layout.first_layout)
        Log.d("FirstActivity", this.toString())
        //app/build.gradle的
        // plugins {
        //    id 'kotlin-android-extensions'
        //}配置 button1不需要findViewById
        button1.setOnClickListener{
//            val intent = Intent(this, SecondActivity::class.java)//显示Intent

//            val intent = Intent("com.banshion.activitytest.ACTION_START")
//            android.intent.category.DEFAULT 默认可省略
//            intent.addCategory("com.banshion.activitytest.MY_CATEGORY")
//            startActivity(intent)
//            Intent.ACTION_VIEW安卓内置动作
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://m.taobao.com")
//            startActivity(intent)
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:10086")
//            startActivity(intent)

//            val data = "Hello SecondActivity"
//            val intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra("extra_data", data)
//            startActivityForResult(intent, 200)

            SecondActivity.actionStart(this, "data1", "data2")

        }
    }

     override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.main, menu)
         return true
     }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         when (item.itemId) {
             R.id.add_item -> Toast.makeText(this, "You click Add", Toast.LENGTH_SHORT).show()
             R.id.remove_item -> Toast.makeText(this, "You click Remove", Toast.LENGTH_SHORT).show()
         }
         return true
     }

     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         super.onActivityResult(requestCode, resultCode, data)
         when (requestCode) {
             200 -> if (resultCode == Activity.RESULT_OK) {
                 val returnedData = data?.getStringExtra("data_return")
                 Log.d("FirstActivity", "returned data is $returnedData")
             }
         }
     }
 }