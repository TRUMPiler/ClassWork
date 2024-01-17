package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class LayoutControls extends AppCompatActivity {

    EditText txtEnno,txtPassword,txtAddress;
    RadioGroup rgGender;
    RadioButton rbMale,rbFemale;
    Spinner spCities;
    CheckBox chkCondition;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_controls);
        initializecomponent();

    }
    private void initializecomponent(){
        txtEnno=findViewById(R.id.txtEnno);
        txtPassword=findViewById(R.id.txtPassword);
        txtAddress=findViewById(R.id.txtAddress);
        rgGender=findViewById(R.id.rgGender);
        rbMale=findViewById(R.id.rbMale);
        rbFemale=findViewById(R.id.rbFemale);
        spCities=findViewById(R.id.spCities);
        chkCondition=findViewById(R.id.chkCondition);
        btnRegister=findViewById(R.id.btnRegister);
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rbMale)
                {
                    Toast.makeText(getApplicationContext(),rbMale.getText().toString(),Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),rbFemale.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void ButtonClick(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Enrollmentno=txtEnno.getText().toString();
                String Password=txtPassword.getText().toString();
                String Address=txtAddress.getText().toString();
                String Gender="";
                if(rbMale.isChecked()){
                    Gender = rbMale.getText().toString();
                }
                else{
                    Gender = rbFemale.getText().toString();
                }
            }
        });
    }
}