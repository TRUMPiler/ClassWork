package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class DatabaseActivity extends AppCompatActivity {

    Button btnAdd;
    ListView lstEmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
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
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,)
    }
}