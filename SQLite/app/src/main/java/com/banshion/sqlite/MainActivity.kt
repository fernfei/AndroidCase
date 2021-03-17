package com.banshion.sqlite

import android.content.ContentValues
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.contentValuesOf
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSharedPreferences("data", Context.MODE_PRIVATE).open {
            putString("name", "Tom")
            putInt("age", 28)
            putBoolean("married", false)
        }


        val myDatabaseHelper = MyDatabaseHelper(this, "BookStore.db", 1)
        createDatabase.setOnClickListener{
            myDatabaseHelper.writableDatabase
        }
        addData.setOnClickListener{
            val wDb = myDatabaseHelper.writableDatabase
            /**
             * 它接收3个参数：
             * 第一个参数是表名，我们希望向哪张表里添加数据，这里就传入该表的名字；
             * 第二个参数用于在未指定添加数据的情况下给某些可为空的列自动赋值NULL，一般我们用不到这个功能，直接传入null即可；
             * 第三个参数是一个ContentValues对象，它提供了一系列的put()方法重载，用于向ContentValues中添加数据，只需要将表中的每个列名以及相应的待添加数据传入即可。
             *
             */
            val value1 = ContentValues().apply {
                put("name", "The Da Vinci Code")
                put("author", "Dan Brown")
                put("pages", "454")
                put("price", "16.96")
            }

            val value3 =
                cvOf(
                    "name" to "The Da Vinci Code",
                    "author" to "Dan Brown",
                    "pages" to "454",
                    "price" to "16.96"
                )

            wDb.insert("Book", null, value1)
            wDb.execSQL("insert into Book (name,author,pages,price) VALUES('HU FEI','NMSL','545','99.99')")
            val value2 = ContentValues().apply {
                put("name", "The Lost Symbol")
                put("author", "Dan Brown")
                put("pages", "510")
                put("price", "19.95")
            }
            wDb.insert("Book", null, value2)
        }
        updateData.setOnClickListener{
            val wDb = myDatabaseHelper.writableDatabase
            val value1 = ContentValues().apply {
                put("name", "孙笑川")
            }
            wDb.update("Book", value1, " name=?", arrayOf("HU FEI"))
            wDb.execSQL("update Book set name='药水哥' where name='The Lost Symbol'")
        }
    }
}