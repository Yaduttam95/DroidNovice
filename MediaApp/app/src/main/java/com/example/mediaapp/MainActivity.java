package com.example.mediaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageview);
        Glide.with(this).load(R.raw.backg).into(imageView);
    }

    public void imageclicked(View view) {
        Intent intent = new Intent(MainActivity.this, ImageClicked.class);
        startActivity(intent);
    }

    public void audioclicked(View view) {
        Intent intent = new Intent(MainActivity.this, AudioClicked.class);
        startActivity(intent);
    }

    public void videoclicked(View view) {
        Intent intent = new Intent(MainActivity.this, VideoClicked.class);
        startActivity(intent);
    }

    public void imgaudclicked(View view) {
        Intent intent = new Intent(MainActivity.this, ImageAudClicked.class);
        startActivity(intent);
    }
}