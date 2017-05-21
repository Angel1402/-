package com.example.a1.myapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;


public class stuplay_h1 extends Activity {

    final Intent intent = new Intent();

    private ImageView animationdoor;
    private AnimationDrawable animationDrawable;

    //MediaPlayer播放
    private MediaPlayer mediaPlayer1;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stuvideoplay);

        animationdoor = (ImageView) findViewById(R.id.animationdoor);
        animationdoor.setImageResource(R.drawable.h1);
        animationDrawable = (AnimationDrawable) animationdoor.getDrawable();
        animationDrawable.start();

        mediaPlayer1 = MediaPlayer.create(this, R.raw.h11);
        mediaPlayer1.start();

        mediaPlayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                intent.setClass(stuplay_h1.this,stuplay_h1_choose.class);
                stuplay_h1.this.startActivity(intent);
            }
        });

    }

}
