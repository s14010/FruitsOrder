package com.example.s14010.order;


import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    static final String TABLENAME = "TestTable"; // テーブル名

    public DBHelper(Context context) {
        super(context, "test.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String s = "CREATE TABLE IF NOT EXISTS " + TABLENAME
                + "(id integer primary key autoincrement,"
                + "name text not null,"
                + "address text not null,"
                + "month integer default 0,"
                + "day integer default 0,"
                + "gender text not null,"
                + "apple text default 0,"
                + "orange text default 0,"
                + "peach text default 0)";
        db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String s = "DROP TABLE IF EXISTS " + TABLENAME;
        db.execSQL(s);
    }


}