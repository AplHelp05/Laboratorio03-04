package com.example.laboratorio03_04.Actividades.Activities;

import android.media.MediaPlayer;
import android.nfc.Tag;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.laboratorio03_04.R;

public class VideoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.title_VideoView));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        final VideoView video = (VideoView) findViewById(R.id.videoView1);

        final MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(video);

        video.setMediaController(mediaController);
        video.setVideoPath("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4");
        video.requestFocus();


        final int duration = video.getDuration();

        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener()  {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i("Duracion", ""+duration);
            }
        });
        video.start();
    }
}
