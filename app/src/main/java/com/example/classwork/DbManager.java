package com.example.classwork;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DbManager {
    private DbHelper helper;
    private Context context;
    private SQLiteDatabase db;
    public DbManager(Context c)
    {
        this.context=c;
    }

    public DbManager open() throws SQLException
    {
        helper = new DbHelper(context);
        db=helper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        helper.close();
    }

    public long Addemployee(String Empname,String Contactno)
    {
        ContentValues cv = new ContentValues();
        cv.put(helper.Emp_name,Empname);
        cv.put(helper.Contact_no,Contactno);
        long i=db.insert(helper.Table_name,null,cv);
        return i;
    }

    public Cursor GetEmployeeList(){
        Cursor c = db.query(helper.Table_name,null,null,null,null,null,null,null);
        return c;
    }
}
