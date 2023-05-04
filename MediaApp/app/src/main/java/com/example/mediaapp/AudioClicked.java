package com.example.mediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.bumptech.glide.Glide;

public class AudioClicked extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_clicked);

        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this).load(R.raw.isagi).into(imageView);

        mediaPlayer = MediaPlayer.create(this, R.raw.audioclicked);
        seekBar=findViewById(R.id.seekBar);

        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        seekBar.setMax(maxVolume);

        int currVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        seekBar.setProgress(currVolume);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }


        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }

    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        super.onBackPressed();
    }

    public void pauseon(View view) {
        mediaPlayer.pause();
    }

    public void playon(View view) {
        mediaPlayer.start();
    }
}