package com.example.a1.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by 1 on 2016/9/21.
 */
public class Mainmap extends Activity {

    private Button btnV;
    private Button btnS;
    private Button btnH;
    private Button btnF;
    private Button btnA;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmap);

        final Intent intent = new Intent();

        //初始化控件
        btnV = (Button) this.findViewById(R.id.sport);
        btnH = (Button) this.findViewById(R.id.hos);
        btnF = (Button) this.findViewById(R.id.food);
        btnS = (Button) this.findViewById(R.id.stu);
        btnA = (Button) this.findViewById(R.id.achieve);//在Activity中控件imageView1的初始值就是图片a

        //成就楼代码
        btnA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                intent.setClass(Mainmap.this, achieve.class);
                Mainmap.this.startActivity(intent);
            }
        });

        //体育场代码
        btnV.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                intent.setClass(Mainmap.this, stuVideo_Sport.class);
                Mainmap.this.startActivity(intent);
            }
        });

        //教学楼代码
        btnS.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               intent.setClass(Mainmap.this, stuVideo_Teaching.class);
                Mainmap.this.startActivity(intent);
            }
        });

        //医务室代码
        btnH.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                intent.setClass(Mainmap.this, stuVideo_Medical.class);
                Mainmap.this.startActivity(intent);
            }
        });

        //餐饮楼代码
        btnF.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                intent.setClass(Mainmap.this, stuVideo_Restaurant.class);
                Mainmap.this.startActivity(intent);
            }
        });

    }

}
