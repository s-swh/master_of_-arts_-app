package com.wd.master_of_arts_app.base;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.multidex.MultiDex;


import com.tencent.bugly.crashreport.CrashReport;

import org.greenrobot.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import cn.jpush.android.api.JPushInterface;



/**
 * @author 时文豪
 * @description: 全局类
 * @date :2020/12/3 11:49
 */
public class App extends Application {


    private static Context context;
    private boolean isDebug;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static Context getContext() {
        return context;
    }
}
