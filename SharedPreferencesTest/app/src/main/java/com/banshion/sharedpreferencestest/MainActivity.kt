package com.banshion.sharedpreferencestest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        saveButton.setOnClickListener{
            val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
            editor.putString("name", "Tom")
            editor.putInt("age", 28)
            editor.putBoolean("married", false)
            editor.apply()
        }

        restoreButton.setOnClickListener{
            val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
            val name = prefs.getString("name", "Tom")
            val age = prefs.getInt("age", 28)
            val married = prefs.getBoolean("married", false)
            Toast.makeText(this, "name:$name,age:$age,married:$married", Toast.LENGTH_SHORT).show()
        }
    }
}