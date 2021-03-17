package com.banshion.uiwidgettestkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.title.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
//        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
//            R.id.button -> {
////                val editTextStr = editText.text.toString()
////                Toast.makeText(this, editTextStr, Toast.LENGTH_SHORT).show()
////                imageView.setImageResource(R.drawable.img_2)
////                if (progressBar.visibility == View.VISIBLE) {
////                    progressBar.visibility = View.GONE
////                } else {
////                    progressBar.visibility = View.VISIBLE
////                }
//
//                AlertDialog.Builder(this).apply {
//                    setTitle("This is Dialog")
//                    setMessage("Something is Dialog")
//                    setCancelable(false)
//                    setPositiveButton("OK"){ dialog, which ->
//                        progressBar.progress = progressBar.progress + 10
//                    }
//                    setNegativeButton("Cancel"){ dialog, which ->
//
//                    }
//                    show()
//                }
//
//            }
        }
    }
}