package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class DatabaseActivity extends AppCompatActivity {

    Button btnAdd;
    ListView lstEmp;
    DbManager db;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        initialize();
        Buttonclick();
        dbHelper= new DbHelper(this);
        db=new DbManager(this);
        db.open();
        GetList();
    }
    private void initialize(){
        btnAdd=findViewById(R.id.btnAdd);
        lstEmp=findViewById(R.id.lstEmp);
    }
    private void Buttonclick(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AddRecordActivity.class);
                startActivity(i);
            }
        });
    }
    private void GetList(){
        Cursor c = db.GetEmployeeList();
        String[] from={dbHelper.Emp_ID,dbHelper.Emp_name,dbHelper.Contact_no};
        int[] to={R.id.lblID,R.id.lblEmpname,R.id.lblContactno};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.custom_list,c,from,to);
        lstEmp.setEmptyView(findViewById(R.id.empty));
        adapter.notifyDataSetChanged();
        lstEmp.setAdapter(adapter);
        lstEmp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView lblID=view.findViewById(R.id.lblID);
                TextView lblEmpname=view.findViewById(R.id.lblEmpname);
                TextView lblContact=view.findViewById(R.id.lblContactno);
                Intent i = new Intent(getApplicationContext(), AddRecordActivity.class);
                i.putExtra("ID", lblID.getText().toString());
                i.putExtra("Empname",lblEmpname.getText().toString());
                i.putExtra("Contactno",lblContact.getText().toString());
                startActivity(i);
            }
        });
    }
}