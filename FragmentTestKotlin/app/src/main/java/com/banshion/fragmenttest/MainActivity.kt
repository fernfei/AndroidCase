package com.banshion.fragmenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//    private fun replaceFragment(fragment: Fragment) {
//        //(1) 创建待添加Fragment的实例。
//        //(2) 获取FragmentManager，在Activity中可以直接调用getSupportFragmentManager()方法获取。
//        val fragmentManager = supportFragmentManager
//        //(3) 开启一个事务，通过调用beginTransaction()方法开启。
//        val transaction = fragmentManager.beginTransaction()
//        //(4) 向容器内添加或替换Fragment，一般使用replace()方法实现，需要传入容器的id和待添加的Fragment实例。
//        transaction.replace(R.id.rightLayout, fragment)
//        //Back键可以回到上一个Fragment
//        transaction.addToBackStack(null)
//        //(5) 提交事务，调用commit()方法来完成。
//        transaction.commit()
//    }
}