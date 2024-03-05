package com.example.classwork;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final String Database_name="EMS.db";
    private static final int Version=1;
    public static final String Table_name="tblEmployee";
    public static final String Emp_ID="_id";//For declaring a field/column primary key, set prefix as _(underscore)
    public static final String Emp_name="Empname";
    public static final String Contact_no="ContactNo";
    public static final String Create_table="CREATE TABLE "+Table_name+" ("+Emp_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+Emp_name+" TEXT NOT NULL,"+Contact_no+" TEXT);";
    public DbHelper(@Nullable Context context) {
        super(context, Database_name, null, Version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_table);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_name);
        onCreate(db);
    }
}
