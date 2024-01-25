package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class LayoutControls extends AppCompatActivity {

    EditText txtEnno,txtPassword,txtAddress;
    RadioGroup rgGender;
    RadioButton rbMale,rbFemale;
    Spinner spCities;
    CheckBox chkCondition;
    Button btnRegister;
    ToggleButton sibe;

    Switch swvisible;
    AutoCompleteTextView tvCity;
    TextView txtOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_controls);
        initializecomponent();
        ButtonClick();
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
        sibe=findViewById(R.id.tbvisible);
        swvisible=findViewById(R.id.swvisible);
        txtOutput=findViewById(R.id.txtOutput);
        tvCity=findViewById(R.id.actvCity);
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
        swvisible.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    txtEnno.setVisibility(View.GONE);
                }
                else{
                    txtEnno.setVisibility(View.VISIBLE);
                }
            }
        });
        sibe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    txtEnno.setVisibility(View.GONE);
                }
                else{
                    txtEnno.setVisibility(View.VISIBLE);
                }
            }
        });
//        Binding the values.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cities));
        spCities.setAdapter(adapter);
        spCities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),getResources().getStringArray(R.array.cities)[position],Toast.LENGTH_LONG).show();;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> autoadapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.cities));
        tvCity.setThreshold(1);
        tvCity.setAdapter(autoadapter);
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
                String cities = spCities.getSelectedItem().toString();
//                lblData.setText("Enrolllment no: ");
                txtOutput.setText("Enrollment No: "+Enrollmentno+"/nPassword: "+Password+"/nAddress: "+Address+"/nGender: "+Gender+"/nCities: "+cities);
            }
        });
    }
}