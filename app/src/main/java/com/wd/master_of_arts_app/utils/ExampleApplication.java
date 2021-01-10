package com.wd.master_of_arts_app.utils;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

public class ExampleApplication extends Application {
@Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}