package com.example.classwork;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

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
//        Karna hai toh kar sakte hai, otherwise it's Okay.
//        ArrayList<String> list= new ArrayList<String>();
//        if(c.moveToNext()){
//            int ID=c.getInt(c.getColumnIndexOrThrow(helper.Emp_ID));
//            list.add(ID+",");
//        }
        return c;
    }
    public int Update(int ID,String Empname,String Contactno)
    {
        ContentValues cv = new ContentValues();
        cv.put(helper.Emp_name,Empname);
        cv.put(helper.Contact_no,Contactno);
        int i=db.update(helper.Table_name,cv,helper.Emp_ID+"=?",new String[]{String.valueOf(ID)});
        return i;
    }
    public void Delete(int ID){
        db.delete(helper.Table_name,helper.Emp_ID+"=?",new String[]{String.valueOf(ID)});
    }
}
