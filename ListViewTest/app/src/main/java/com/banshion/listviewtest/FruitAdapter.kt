package com.banshion.listviewtest

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FruitAdapter(activity : Activity, private val resourceId: Int, data: List<Fruit>) :
    ArrayAdapter<Fruit>(activity, resourceId, data) {

    inner class ViewHolder(val fruitImage: ImageView, val fruitName: TextView)

    //每个子项滚动到屏幕内时被调用
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //parent 是ListView 也就是要放入的父布局文件
        //convertView用于将加载好的布局进行缓存
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
            val fruitName: TextView = view.findViewById(R.id.fruitName)
            viewHolder = ViewHolder(fruitImage, fruitName)
            view.tag = viewHolder

        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val fruit = getItem(position)
        if (fruit != null) {
            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.fruitName.text = fruit.name
        }
        return view

    }
}