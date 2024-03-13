package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecordActivity extends AppCompatActivity {

    EditText txtEmpname,txtContactno;
    Button btnSave, btnDelete;
    DbManager db;
    int ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        initialize();
        Buttonclick();
        db = new DbManager(this);
        db.open();
        Intent i =getIntent();
        if(i.getStringExtra("ID")!=null){
           ID=Integer.parseInt(i.getStringExtra("ID"));
           String Empname=i.getStringExtra("Empname");
           String Contactno=i.getStringExtra("Contactno");
           txtEmpname.setText(Empname);
           txtContactno.setText(Contactno);
           btnDelete.setVisibility(View.VISIBLE);
        }
    }
    private void initialize(){
        txtEmpname=findViewById(R.id.txtEmpname);
        txtContactno=findViewById(R.id.txtContactno);
        btnSave=findViewById(R.id.btnSave);
        btnDelete=findViewById(R.id.btnDelete);
    }
    private void Buttonclick(){
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.Delete(ID);
                Backhome();
            }
        });
btnSave.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String Empname=txtEmpname.getText().toString();
        String Contactno=txtContactno.getText().toString();
        if(ID==0) {
            long i = db.Addemployee(Empname, Contactno);
            if (i > 0) {
                Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_LONG);
                Backhome();
            }
        }else{
                int i=db.Update(ID,Empname,Contactno);
                if(i>0){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG);
                    Backhome();
                }
        }
    }
});
    }
    private void Backhome(){
        Intent i = new Intent(this,DatabaseActivity.class);
        startActivity(i);
    }
}