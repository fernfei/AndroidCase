package com.banshion.shoesmall

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ShoesAdapter(private val context: Context, private val shoesList: List<Shoes>) :
    RecyclerView.Adapter<ShoesAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val shoesImage: ImageView = view.findViewById(R.id.shoesImage)
        val shoesName: TextView = view.findViewById(R.id.shoesName)
        val shoesPrice: TextView = view.findViewById(R.id.shoesPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.shoes_item, parent, false)
        val holder = ViewHolder(view)
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            val fruit = shoesList[position]
            val intent = Intent(context, ShoesActivity::class.java).apply {
                putExtra(ShoesActivity.SHOES_NAME, fruit.name)
                putExtra(ShoesActivity.SHOES_IMAGE_ID, fruit.imageId)
            }
            context.startActivity(intent)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoes = shoesList[position]
        holder.shoesName.text = shoes.name
        holder.shoesPrice.text = shoes.getShoesPrice()
        Glide.with(context).load(shoes.imageId).into(holder.shoesImage)
    }

    override fun getItemCount() = shoesList.size

}