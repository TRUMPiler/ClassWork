package com.example.classwork;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MenuBar extends AppCompatActivity {
    ListView cities;
    String[] c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bar);
        initializeCompact();
    }

    private void initializeCompact() {
        Resources res = getResources();
        c = res.getStringArray(R.array.cities);
        ArrayAdapter<String> aa=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,c);
        cities=(ListView) findViewById(R.id.cities);
        cities.setAdapter(aa);
        registerForContextMenu(cities);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id=item.getItemId();
        if(id==R.id.contactus)
        {
            Toast.makeText(this, "Selected Contactus", Toast.LENGTH_LONG).show();
        }
        else if(id==R.id.aboutus)
        {
            Toast.makeText(this, "Selected aboutus", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.contactus)
        {
            Toast.makeText(this, "Selected Contactus", Toast.LENGTH_LONG).show();
        }
        else if(id==R.id.aboutus)
        {
            Toast.makeText(this, "Selected aboutus", Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);

    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        if(menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        inflater.inflate(R.menu.main_menu,menu);

        return true;
    }

}