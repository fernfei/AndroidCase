package com.banshion.shoesmall

class Shoes(val name: String, val imageId: Int, private val shoesPrice: Double) {
    fun getShoesPrice() = "￥$shoesPrice"
}
