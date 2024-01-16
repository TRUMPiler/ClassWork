package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Fragmentwithlists extends AppCompatActivity {

    ListView lstCourse;
    String[] Course={"Master in Android"," Master in Flutter","MAster in kotlin"};
    String[] Des={"Android","Flutter","Kotlin"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentwithlists);
        Initializecomponent();
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>()
    }
    private void Initializecomponent()
    {
//        lstCourse=findViewById(R.id.lstCourse);
    }
}