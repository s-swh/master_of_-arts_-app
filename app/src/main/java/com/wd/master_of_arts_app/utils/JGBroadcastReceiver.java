package com.wd.master_of_arts_app.utils;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.MainActivity;
import com.wd.master_of_arts_app.activity.Verification_code_login;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.bean.Extra;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import cn.jpush.android.api.JPushInterface;

/**
 * 通知实时刷新首页
 */
public class JGBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "BootCompleteReceiver";

    private PopupWindow popupBigPhoto;
    Context context;
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        String extra = bundle.getString(JPushInterface.EXTRA_EXTRA);
        Gson gson = new Gson();
        Extra extra1 = gson.fromJson(extra, Extra.class);
        if(extra1!=null){
            String key = extra1.getKey();
            if (key.equals("offline")) {
                    EventBus.getDefault().postSticky(key);
                String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
                Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
            }
        }

    }
}