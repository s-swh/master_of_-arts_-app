package com.wd.master_of_arts_app.base;

import android.app.Application;
import android.content.Context;

/**
 * @author 时文豪
 * @description:  全局变量类
 * @date :2020/12/3 11:49
 */
public class App  extends Application {

    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public Context getContext() {
        return context;
    }
}
