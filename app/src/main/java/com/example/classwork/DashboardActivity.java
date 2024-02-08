package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    TextView lblusername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        lblusername=findViewById(R.id.lblusername);
        SharedPreferences sh =getSharedPreferences("myprefs",MODE_PRIVATE);
        String username= sh.getString("username",null);
        if (username!=null){
            lblusername.setText("Username: "+username);
        }
    }

}