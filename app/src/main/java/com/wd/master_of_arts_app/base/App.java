package com.wd.master_of_arts_app.base;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cn.jpush.android.api.JPushInterface;

/**
 * @author 时文豪
 * @description: 全局变量类
 * @date :2020/12/3 11:49
 */
public class App extends Application {


    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }

    public static Context getContext() {
        return context;
    }
}
