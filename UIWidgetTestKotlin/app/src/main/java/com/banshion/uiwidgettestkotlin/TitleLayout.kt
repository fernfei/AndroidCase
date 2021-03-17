package com.banshion.uiwidgettestkotlin

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.title.view.*

class TitleLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    init {
        //inflate第一个参数是要加载的布局文件id ,第二个参数是给加载好的布局再添加一个父布局，这里我们指定TitleLayout
        LayoutInflater.from(context).inflate(R.layout.title, this)
        titleBack.setOnClickListener{
            val activity = context as Activity
            activity.finish()
        }
        titleEdit.setOnClickListener{
            Toast.makeText(context, "You clicked Edit button", Toast.LENGTH_SHORT).show()
        }
    }

}
