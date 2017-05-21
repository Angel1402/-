package com.example.a1.myapp;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class MyViewPagerAdapter extends PagerAdapter {
    // 界面列表
    private List<View> views;
    private Activity activity;

    public MyViewPagerAdapter(List<View> views, Activity activity) {
        this.views = views;
        this.activity = activity;
    }

    // ??毁arg1位置的界??
    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView(views.get(arg1));
    }

    @Override
    public void finishUpdate(View arg0) {
    }

    // 获得当前界面??
    @Override
    public int getCount() {
        if (views != null) {
            return views.size();
        }
        return 0;
    }

    // 初始化arg1位置的界??
    @Override
    public Object instantiateItem(final View arg0, final int arg1) {
        ((ViewPager) arg0).addView(views.get(arg1), 0);

        ImageView imgBack = (ImageView) arg0.findViewById(R.id.imgBack);

        if (arg1 == 0) {
            imgBack.setImageResource(R.drawable.video_t1);
        }

        if (arg1 == 1) {
            imgBack.setImageResource(R.drawable.video_t2);
        }

        if (arg1 == 2) {
            imgBack.setImageResource(R.drawable.video_t3);
        }

        if (arg1 == 3) {
            imgBack.setImageResource(R.drawable.video_t4);
        }

        if (arg1 == 4) {
            imgBack.setImageResource(R.drawable.video_t5);
        }



        Button toLeft = (Button) arg0.findViewById(R.id.toLeft);
        toLeft.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                if (arg1 != 0) {
                    ((ViewPager) arg0).setCurrentItem(arg1 - 1);
                }
            }
        });

        Button toRight = (Button) arg0.findViewById(R.id.toRight);
        toRight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                if (arg1 != views.size() - 1) {
                    ((ViewPager) arg0).setCurrentItem(arg1 + 1);
                }
            }
        });

        Button btnP = (Button) arg0.findViewById(R.id.btnplay);
        btnP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(activity, stuVideoPaly_Teaching.class);

                //activity.startActivity(intent);

                if (arg1 == 0) {
                    Intent intent = new Intent(activity, stuplay_t1.class);
                    activity.startActivity(intent);
                }

                if (arg1 == 1) {
                    Intent intent = new Intent(activity, stuplay_t2.class);
                    activity.startActivity(intent);
                }

                if (arg1 == 2) {
                    Intent intent = new Intent(activity, stuplay_t3.class);
                    activity.startActivity(intent);
                }

                if (arg1 == 3) {
                    Intent intent = new Intent(activity, stuplay_t4.class);
                    activity.startActivity(intent);
                }

                if (arg1 == 4) {
                    Intent intent = new Intent(activity, stuplay_t5.class);
                    activity.startActivity(intent);
                }

            }
        });

        Button btnH = (Button) arg0.findViewById(R.id.toHome);
        btnH.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, Mainmap.class);

                activity.startActivity(intent);

            }
        });
        return views.get(arg1);
    }

    // 判断是否由对象生成界??
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return (arg0 == arg1);
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(View arg0) {
    }


}
