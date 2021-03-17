package com.banshion.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String CREATE_BOOK = "create table Book (" +
            " id integer primary key autoincrement," +
            " author text," +
            " price real," +
            " pages integer," +
            " name text)";

    private static final String CREATE_CATEGORY = "create table Category (" +
            " id integer primary key autoincrement," +
            " category_name text," +
            " category_code integer)";


    private Context context;


    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Toast.makeText(context, "Create Succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
