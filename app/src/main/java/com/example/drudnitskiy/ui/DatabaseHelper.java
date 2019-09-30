package com.example.drudnitskiy.ui;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "test";
    public static final String TABLE_USERS = "Users";

    public static final String KEY_ID= "_id";
    public static final String KEY_NAME = "Login";
    public static final String KEY_PASSWORD = "Password";


    public DatabaseHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(String.format("create table%s(%s integer primary key,%s text,%s text)", TABLE_USERS, KEY_ID, KEY_NAME, KEY_PASSWORD));

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(String.format("drop table if exists%s", TABLE_USERS));

        onCreate(db);
    }

}
