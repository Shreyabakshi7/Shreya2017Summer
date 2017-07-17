package com.example.anurag_pc.shreya2017summer;

import android.app.Application;

import com.example.anurag_pc.shreya2017summer.util.UtilLog;

/**
 * Created by Anurag-PC on 6/19/2017.
 */

public class ShreyaApplication extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setIsLog(true);
    }
}
