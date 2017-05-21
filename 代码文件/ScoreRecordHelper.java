package com.example.a1.myapp;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 1 on 2016/12/26.
 */
public class ScoreRecordHelper {
    private static final String FILE_NAME = "score";

    private static ScoreRecordHelper helper;
    private SharedPreferences mSp;

    public enum Platform{   // 医务楼， 体育楼，餐饮楼， 教学楼
        MEDICAL, SPORT, RESTAURANT, TEACHING
    }

    private ScoreRecordHelper(){
        mSp = StudyApplication.getApplication().getSharedPreferences(FILE_NAME, Context.MODE_APPEND);
    }

    public static ScoreRecordHelper getHelper(){
        if (helper == null){
            synchronized (ScoreRecordHelper.class){
                if (helper == null){
                    helper = new ScoreRecordHelper();
                }
            }
        }
        return helper;
    }

    //***************************************** Util ******************************

    /**
     * 记录某一栋楼的成就值！
     * score : 要记录的数值
     */
    public void recordScore(Platform platform, int score){
        SharedPreferences.Editor editor = mSp.edit();
        editor.putInt(platform.name(), score);
        editor.commit();
    }


    /**
     * 某一栋楼的成就值 + 1;
     */
    public void recordScore(Platform platform){
        int score = getScore(platform) + 1;
        recordScore(platform, score);
    }

    /**
     * 取得某一栋楼的成就值！
     */
    public int getScore(Platform platform){
        return mSp.getInt(platform.name(), 0);
    }

    /**
     *  清除某一栋楼的成就值！
     */
    public void clearScore(Platform platform){
        recordScore(platform, 0);
    }
}
