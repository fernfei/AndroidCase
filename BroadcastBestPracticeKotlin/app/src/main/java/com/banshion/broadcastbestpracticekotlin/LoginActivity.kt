package com.banshion.broadcastbestpracticekotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
        val isRemember = prefs.getBoolean("rememberPass", false)
        if (isRemember) {
            val account = prefs.getString("account", "NMSL")
            val password = prefs.getString("password", "NMSL")
            accountEdit.setText(account)
            passwordEdit.setText(password)
            rememberPass.isChecked = true
        }

        login.setOnClickListener{
            val account = accountEdit.text.toString()
            val password = passwordEdit.text.toString()
            if ("admin" == account && "123" == password) {
                if (rememberPass.isChecked) {//记住密码
                    val edit = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
                    edit.putString("account", account)
                    edit.putString("password", password)
                    edit.putBoolean("rememberPass", true)
                    edit.apply()
                }
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "account or password is invalid", Toast.LENGTH_SHORT).show()
            }

        }
    }
}