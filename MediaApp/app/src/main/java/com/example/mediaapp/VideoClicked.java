package com.example.mediaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoClicked extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_clicked);
        videoView = findViewById(R.id.videoView);


        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videoclicked);
        videoView.setVideoURI(videoUri);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                int videoWidth = mediaPlayer.getVideoWidth();
                int videoHeight = mediaPlayer.getVideoHeight();
                float videoProportion = (float) videoWidth / (float) videoHeight;

                int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
                int screenHeight = getWindowManager().getDefaultDisplay().getHeight();
                float screenProportion = (float) screenWidth / (float) screenHeight;

                ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) videoView.getLayoutParams();
                videoView.setLayoutParams(lp);

                if (videoProportion > screenProportion) {
                    lp.width = screenWidth;
                    lp.height = (int) ((float) screenWidth / videoProportion);
                } else {
                    lp.width = (int) (videoProportion * (float) screenHeight);
                    lp.height = screenHeight;
                }


            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public void pauseon(View view) {
        videoView.pause();
    }

    public void playon(View view) {
        videoView.start();
    }
}