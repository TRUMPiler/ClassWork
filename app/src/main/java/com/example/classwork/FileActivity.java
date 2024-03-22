package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileActivity extends AppCompatActivity {


    EditText txtfilename;
    Button btnread,btnwrite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        initialize();
        buttonclick();
    }
    private void initialize()
    {
        txtfilename=findViewById(R.id.txtfilename);
        btnread=findViewById(R.id.btnread);
        btnwrite=findViewById(R.id.btnwrite);
    }

    private void buttonclick(){
        btnwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos= openFileOutput("TASKS",MODE_APPEND);
                    fos.write(txtfilename.getText().toString().getBytes());
                    fos.close();
                    Toast.makeText(FileActivity.this,"File is created",Toast.LENGTH_LONG).show();
                }catch(FileNotFoundException e){
                    throw new RuntimeException(e);
                }catch (IOException e){
                    throw new RuntimeException(e);
                }

            }
        });
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String line,Filecontent=" ";
                try {
                    FileInputStream fis=openFileInput("File1");
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                    while((line=br.readLine())!=null){
                        Filecontent+=line;
                    }
                    txtfilename.setText(Filecontent);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}