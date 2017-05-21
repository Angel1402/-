package com.example.a1.myapp;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class stuplay_h1_choose extends Activity {

    // POP弹窗的dialog
    Dialog popDialog;
    //
    private ImageButton imgBtnL;
    private ImageButton imgBtnR;

    //MediaPlayer播放
    private MediaPlayer mediaPlayer1;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stuplay_t1);

        mediaPlayer1 = MediaPlayer.create(stuplay_h1_choose.this, R.raw.h12);
        mediaPlayer1.start();

        imgBtnL = (ImageButton) findViewById(R.id.imgBtnL);
        imgBtnL.setImageResource(R.drawable.m_one_l0);

        imgBtnR = (ImageButton) findViewById(R.id.imgBtnR);
        imgBtnR.setImageResource(R.drawable.m_one_r0);

        imgBtnL.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                imgBtnL.setImageResource(R.drawable.m_one_l1);

                mediaPlayer1 = MediaPlayer.create(stuplay_h1_choose.this, R.raw.h13);
                mediaPlayer1.start();

                mediaPlayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        showPopForStar();
                    }
                });
            }
        });

        imgBtnR.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                imgBtnR.setImageResource(R.drawable.m_one_r1);

                mediaPlayer1 = MediaPlayer.create(stuplay_h1_choose.this, R.raw.h14);
                mediaPlayer1.start();

                mediaPlayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        refresh();
                    }
                });
            }
        });
    }

    private void showPopForStar() {
        View view = LayoutInflater.from(this).inflate(R.layout.pop_star, null);
        final Dialog dialog = new Dialog(stuplay_h1_choose.this,
                R.style.transparentFrameWindowStyle);
        dialog.setContentView(view, new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.WRAP_CONTENT));

        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        // 设置显示动画
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams wl = window.getAttributes();

        // 以下这两句是为了保证按钮可以水平满屏
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        window.setAttributes(wl);

        // 设置显示位置
        dialog.onWindowAttributesChanged(wl);
        // 设置点击外围解散
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                dialog.dismiss();
                Intent intent = new Intent(stuplay_h1_choose.this, stuVideo_Medical.class);

                startActivity(intent);
                stuplay_h1_choose.this.finish();

            }
        }, 1000);

        ScoreRecordHelper helper = ScoreRecordHelper.getHelper();
        //记录数据
        //helper.recordScore(ScoreRecordHelper.Platform.TEACHING,1);
        //在现有分值上加1
        helper.recordScore(ScoreRecordHelper.Platform.MEDICAL);

    }

    private void refresh() {
        finish();
        Intent intent = new Intent(this, stuplay_h1_choose.class);
        startActivity(intent);
    }
}
