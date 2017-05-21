package com.example.a1.myapp;

import android.app.Application;

/**
 * Created by 1 on 2016/12/26.
 */
public class StudyApplication extends Application {

    private static StudyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    public static StudyApplication getApplication(){
        return instance;
    }

}
