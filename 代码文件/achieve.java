package com.example.a1.myapp;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by 1 on 2016/12/6.
 */
public class achieve extends Activity {

    //声明对象
    private RelativeLayout hospital;
    private RelativeLayout sports;
    private RelativeLayout rest;
    private RelativeLayout teaching;
    private ImageView home;
    private TextView txt4,txt3,txt2,txt1;
    private int score4,score1,score2,score3;
    private int text4,text1,text2,text3;
    private String s4,s3,s2,s1;
    private ImageView star1, star2, star3, star4, star5;
    private ImageView test;
    private ProgressBar progress1, progress2, progress3, progress4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.achievecenter);
        findViewById();


        ScoreRecordHelper helper = ScoreRecordHelper.getHelper();
        //取出数据
        score1 = helper.getScore(ScoreRecordHelper.Platform.MEDICAL);
        progress1.setProgress(score1);
        score2 = helper.getScore(ScoreRecordHelper.Platform.SPORT);
        progress2.setProgress(score2);
        score3 = helper.getScore(ScoreRecordHelper.Platform.RESTAURANT);
        progress3.setProgress(score3);
        score4 = helper.getScore(ScoreRecordHelper.Platform.TEACHING);
        progress4.setProgress(score4);

        if(score1 <= 5){
            text1 = score1*100/5;
            s1 = String.valueOf(text1)+"%";
            txt1.setText(s1);
        }
        else
            txt1.setText("100%");

        if(score2 <= 5){
            text2 = score2*100/5;
            s2 = String.valueOf(text2)+"%";
            txt2.setText(s2);
        }
        else
            txt2.setText("100%");

        if(score3 <= 5){
            text3 = score3*100/5;
            s3 = String.valueOf(text3)+"%";
            txt3.setText(s3);
        }
        else
            txt3.setText("100%");

        if(score4 <= 5){
            text4 = score4*100/5;
            s4 = String.valueOf(text4)+"%";
            txt4.setText(s4);
        }
        else
            txt4.setText("100%");

        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(achieve.this, Mainmap.class);
                startActivity(intent);
            }
        });

        initListenner();
    }


    private void findViewById() {
        hospital = (RelativeLayout) findViewById(R.id.hospital);
        sports = (RelativeLayout) findViewById(R.id.sport);
        rest = (RelativeLayout) findViewById(R.id.restaurant);
        teaching = (RelativeLayout) findViewById(R.id.teaching);
        progress1 = (ProgressBar) findViewById(R.id.progressBar1);
        progress2 = (ProgressBar) findViewById(R.id.progressBar2);
        progress3 = (ProgressBar) findViewById(R.id.progressBar3);
        progress4 = (ProgressBar) findViewById(R.id.progressBar4);
        home = (ImageView) findViewById(R.id.home);
        txt4 = (TextView) findViewById(R.id.txt4);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt1 = (TextView) findViewById(R.id.txt1);

        star1 = (ImageView) findViewById(R.id.star1);
        star2 = (ImageView) findViewById(R.id.star2);
        star3 = (ImageView) findViewById(R.id.star3);
        star4 = (ImageView) findViewById(R.id.star4);
        star5 = (ImageView) findViewById(R.id.star5);
        test = (ImageView) findViewById(R.id.test);
    }

    private void initListenner() {

        final Intent intent = new Intent();

        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(achieve.this, share.class);
                achieve.this.startActivity(intent);
                //showPopForShare();
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(achieve.this, share_s.class);
                achieve.this.startActivity(intent);
                //showPopForShare2();
               // imgShare.setImageDrawable(getResources().getDrawable(R.drawable.img2));
            }
        });
        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(achieve.this, share_r.class);
                achieve.this.startActivity(intent);
                //showPopForShare3();
                //imgShare.setImageResource(R.drawable.img3);
               // imgShare.setImageDrawable(getResources().getDrawable(R.drawable.img3));
            }
        });
        teaching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(achieve.this, share_t.class);
                achieve.this.startActivity(intent);
               // showPopForShare4();
                //imgShare.setImageResource(R.drawable.img3);
              //  imgShare.setImageDrawable(getResources().getDrawable(R.drawable.img4));

            }
        });
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(achieve.this, Mainmap.class);

                startActivity(intent);
            }
        });
    }

   /* protected void showPopForShare() {
        View view = LayoutInflater.from(this).inflate(R.layout.pop_share, null);
       // imgshare = (ImageView) findViewById(R.id.imgshare);
        final Dialog dialog = new Dialog(achieve.this, R.style.transparentFrameWindowStyle);
        dialog.setContentView(view, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);

        // 设置显示动画
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams w1 = window.getAttributes();

        w1.width = ViewGroup.LayoutParams.MATCH_PARENT;
        w1.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        window.setAttributes(w1);

        // 设置显示位置
        dialog.onWindowAttributesChanged(w1);
        // 设置点击外围解散
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    protected void showPopForShare2() {
        View view = LayoutInflater.from(this).inflate(R.layout.pop_share_s, null);
        //sharedemo =(Button)findViewById(R.id.share_btn);
        //imgshare = (ImageView) findViewById(R.id.imgshare);
        final Dialog dialog = new Dialog(achieve.this, R.style.transparentFrameWindowStyle);
        dialog.setContentView(view, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);

        // 设置显示动画
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams w1 = window.getAttributes();

        w1.width = ViewGroup.LayoutParams.MATCH_PARENT;
        w1.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        window.setAttributes(w1);

        // 设置显示位置
        dialog.onWindowAttributesChanged(w1);
        // 设置点击外围解散
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    protected void showPopForShare3() {
        View view = LayoutInflater.from(this).inflate(R.layout.pop_share_r, null);
        //sharedemo =(Button)findViewById(R.id.share_btn);
       // imgshare = (ImageView) findViewById(R.id.imgshare);
        final Dialog dialog = new Dialog(achieve.this, R.style.transparentFrameWindowStyle);
        dialog.setContentView(view, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);

        // 设置显示动画
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams w1 = window.getAttributes();

        w1.width = ViewGroup.LayoutParams.MATCH_PARENT;
        w1.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        window.setAttributes(w1);

        // 设置显示位置
        dialog.onWindowAttributesChanged(w1);
        // 设置点击外围解散
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    protected void showPopForShare4() {
        View view = LayoutInflater.from(this).inflate(R.layout.pop_share_t, null);
        //sharedemo =(Button)findViewById(R.id.share_btn);
        //imgshare = (ImageView) findViewById(R.id.imgshare);
        final Dialog dialog = new Dialog(achieve.this, R.style.transparentFrameWindowStyle);
        dialog.setContentView(view, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);

        // 设置显示动画
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams w1 = window.getAttributes();

        w1.width = ViewGroup.LayoutParams.MATCH_PARENT;
        w1.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        window.setAttributes(w1);

        // 设置显示位置
        dialog.onWindowAttributesChanged(w1);
        // 设置点击外围解散
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }*/

}
