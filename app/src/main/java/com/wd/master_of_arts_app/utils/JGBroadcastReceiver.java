package com.wd.master_of_arts_app.utils;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.wd.master_of_arts_app.activity.MainActivity;
import com.wd.master_of_arts_app.activity.Verification_code_login;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.bean.Extra;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import cn.jpush.android.api.JPushInterface;

public class JGBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "xxx";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        String title = bundle.getString(JPushInterface.EXTRA_TITLE);
        String message = bundle.getString(JPushInterface.EXTRA_MESSAGE);
        String title2 = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
        String content = bundle.getString(JPushInterface.EXTRA_ALERT);
        String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
        String fileHtml = bundle.getString(JPushInterface.EXTRA_RICHPUSH_HTML_PATH);

        Log.e("onReceive", "--------------------------------------------------");
        Log.e("onReceive", "title : " + title);
        Log.e("onReceive", "title2 : " + title2);
        Log.e("onReceive", "message: " + message);
        Log.e("onReceive", "content: 测试有值 " + content);
        Log.e("onReceive", "extras: " + extras);
        Log.e("onReceive", "fileHtml: " + fileHtml);

        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
            String regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
            Log.d(TAG, "[MyReceiver] 接收 Registration Id : " + regId);
        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            Log.d(TAG, "收到了自定义消息。消息内容是：" + bundle.getString(JPushInterface.EXTRA_MESSAGE));
            // 自定义消息不会展示在通知栏，完全要开发者写代码去处理
        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            Log.d(TAG, "收到了通知");
            // 在这里可以做些统计，或者做些其他工作
        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            Log.d(TAG, "用户点击打开了通知");
            // 在这里可以自己写代码去定义用户点击后的行为
            Intent i = new Intent(context, JGBroadcastReceiver.class);  //自定义打开的界面
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        } else {
            Log.d(TAG, "Unhandled intent - " + intent.getAction());
        }


        String extra = bundle.getString(JPushInterface.EXTRA_EXTRA);
        if (extra != null) {
            Log.d("xxstring", extra + "");
            if(intent.getAction().equals("com.wd.master_of_arts_app")){
                Intent noteList = new Intent(context, MainActivity.class);
                noteList.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(noteList);
            }
            Gson gson = new Gson();
            Extra extra1 = gson.fromJson(extra, Extra.class);
            String key = extra1.getKey();
            SharedPreferences sp = App.getContext().getSharedPreferences("extra", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("key",key);
            edit.commit();

        }
    }
}