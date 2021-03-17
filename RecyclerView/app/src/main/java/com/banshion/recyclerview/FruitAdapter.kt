package com.banshion.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fruit_item.view.*

class FruitAdapter(private val fruitList: List<Fruit>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val fruitImage: ImageView = view.fruitImage
        val fruitName: TextView = view.fruitName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        val viewHolder = ViewHolder(view)
        //itemView是最外层的布局
        viewHolder.itemView.setOnClickListener{
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "you clicked view ${fruit.name}", Toast.LENGTH_SHORT)
                .show()
        }
        viewHolder.fruitImage.setOnClickListener{
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "you clicked image ${fruit.name}", Toast.LENGTH_SHORT)
                .show()
        }
        return viewHolder
    }

    override fun getItemCount() = fruitList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitName.text = fruit.name
    }
}