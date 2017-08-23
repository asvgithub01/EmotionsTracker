package com.google.android.gms.samples.vision.face.facetracker;

import android.app.Application;
import android.os.Handler;

import emotionsTracker.asvfactory.com.model.AppXtatics;
import emotionsTracker.asvfactory.com.model.XtatisticManager;

/**
 * Created by nubor on 21/10/2016.
 */
public class App extends Application {
    static String mText="";
    static Handler mHandler;
    static int mCurrentEvent=0;

    static XtatisticManager mXtaticManager;

    @Override
    public void onCreate() {
        super.onCreate();
        //todo esto tiene q ir en el primer activity el q te pide nombre y te hace una foto
        App.mXtaticManager = AppXtatics.init(this,"Alberto_" + System.currentTimeMillis() + ".json");
    }
}
