package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fragmentexample2 extends AppCompatActivity {

    Button btnRegister,btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentexample2);
        initializecomponent();
        Buttonclick();
    }
    private void initializecomponent()
    {
        btnRegister=findViewById(R.id.btnRegistration);
        btnList=findViewById(R.id.btnList);
    }
    private void Buttonclick(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Loadfragment(new RegisterFragment());
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Loadfragment(new ListsFragment());
            }
        });
    }
    private void Loadfragment(Fragment f){
//      Fragmentmanager  Class for interacting with fragment inside an activity
        FragmentManager fm=getSupportFragmentManager();
//        FragmentTransaction - class for performing operations such as replace()
        FragmentTransaction t=fm.beginTransaction();
        t.replace(R.id.fragment_container,f);
        t.addToBackStack(null);
        t.commit();
    }
}