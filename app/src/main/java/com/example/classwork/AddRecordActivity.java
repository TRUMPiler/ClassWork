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
    Button btnSave;
    DbManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        db = new DbManager(this);
        db.open();
    }
    private void initialize(){
        txtEmpname=findViewById(R.id.txtEmpname);
        txtContactno=findViewById(R.id.txtContactno);
        btnSave=findViewById(R.id.btnSave);
    }
    private void Buttonclick(){
btnSave.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String Empname=txtEmpname.getText().toString();
        String Contactno=txtContactno.getText().toString();
        long i = db.Addemployee(Empname,Contactno);
        if(i>0){
            Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG);
        }
    }
});
    }
    private void Backhome(){
        Intent i = new Intent(this,DatabaseActivity.class);
        startActivity(i);
    }
}