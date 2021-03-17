package com.banshion.shoesmall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_shoes.*

class ShoesActivity : AppCompatActivity() {

    companion object {
        const val SHOES_NAME = "shoes_name"
        const val SHOES_IMAGE_ID = "shoes_image_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoes)
        val fruitName = intent.getStringExtra(SHOES_NAME) ?: ""
        val fruitImageId = intent.getIntExtra(SHOES_IMAGE_ID, 0)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        collapsingToolbar.title = fruitName
        Glide.with(this).load(fruitImageId).into(fruitImageView)
        fruitContentText.text = generateFruitContent(fruitName)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun generateFruitContent(fruitName: String) = fruitName.repeat(500)

}