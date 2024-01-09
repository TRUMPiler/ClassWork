package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Jan09 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jan09);
        Button b=findViewById(R.id.click);
        Button cl=findViewById(R.id.checklogin);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i=new Intent(Intent.ACTION_SENDTO);
//                i.putExtra("address","9876543219");
//                i.putExtra("sms_body","Hello.....");
//                i.setData(Uri.parse("smsto:"));
//                startActivity(i);

                Intent i=new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL,new String[] {"jainam21103@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT,"Test");
                i.putExtra(Intent.EXTRA_TEXT,"Hiii Hello");
                i.setType("Message/rfc822");
                startActivity(i);
            }
        });

        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();

            }
        });



    }


}