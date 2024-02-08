package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPreference extends AppCompatActivity {

    EditText txtusername,txtpassword;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        initialize();
        Buttonclicks();



        SharedPreferences sh = getSharedPreferences("myprefs",MODE_PRIVATE);
        if(sh!=null){
            int Loggedin=sh.getInt("Isloggedin",0);
            if(Loggedin==1){
                Intent i = new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity(i);
                finish();
            }
        }
    }
    private void initialize(){
        txtusername=findViewById(R.id.txtUsername);
        txtpassword=findViewById(R.id.txtPassword);
        btnlogin=findViewById(R.id.btnLogin);
    }
    public void Buttonclicks(){

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=txtusername.getText().toString();
                String password=txtpassword.getText().toString();
                Toast.makeText(getApplicationContext(),username,Toast.LENGTH_LONG).show();
                if(username.equals("admin") && password.equals("12345"))
                {
                    SharedPreferences sh = (SharedPreferences) getSharedPreferences("myprefs",MODE_PRIVATE);
                    SharedPreferences.Editor e=sh.edit();
                    e.putString("username",username);
                    e.putString("password",password);
                    e.putInt("Isloggedin",1);
                    e.apply();
                    Intent i = new Intent(getApplicationContext(),DashboardActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}