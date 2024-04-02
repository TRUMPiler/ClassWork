package com.example.classwork;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FrameAnimation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_frame_animation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        Download images and put inside the drawable directory
//        Right click on drawable directory and add drawable resource file


//        imgAnim=findViewById(R.id.imgAnim)
//        imgAnim.setBackgroundResource(R.drawable.frameaniimation);
//        AnimationDrawable anim= (AnimationDrawable) imgAnim.getBackground();
//        anim.start();
    }
}