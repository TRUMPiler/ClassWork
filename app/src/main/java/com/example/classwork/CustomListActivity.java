package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CustomListActivity extends AppCompatActivity {

    ListView lstCars;
    String[] title = {"Car1","car2","car3","car4"};
    String[] description={"dasdasd","dasdasdas","dfwewfefw","fefeafsd"};
    int[] img={R.drawable.wall,R.drawable.wall,R.drawable.baseline_power_settings_new_24,R.drawable.wall};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        initializecomponent();
    }
    private void initializecomponent(){
        lstCars=findViewById(R.id.lstCars);
        Myadapter myadapter= new Myadapter(CustomListActivity.this,title,description,img);
        lstCars.setAdapter(myadapter);
        lstCars.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),title[i]+","+description[i],Toast.LENGTH_SHORT).show();
            }
        });
    }
}