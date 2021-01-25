package com.wd.master_of_arts_app.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;

import android.util.Log;
import android.view.KeyEvent;

import android.view.View;

import android.widget.Button;

import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.gson.Gson;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.app.CommonAction;

import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.CustomTabEntityDemo;
import com.wd.master_of_arts_app.bean.Extra;
import com.wd.master_of_arts_app.bean.Update;
import com.wd.master_of_arts_app.customview.NoScrollViewPager;
import com.wd.master_of_arts_app.fragment.Find_page;
import com.wd.master_of_arts_app.fragment.Home_page;
import com.wd.master_of_arts_app.fragment.My_page;
import com.wd.master_of_arts_app.fragment.Take_photos;
import com.wd.master_of_arts_app.fragment.Task_page;
import com.wd.master_of_arts_app.utils.JGBroadcastReceiver;
import com.wd.master_of_arts_app.utils.NetUtils;
import com.wd.master_of_arts_app.utils.TwiceBackOut;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.service.JPushMessageReceiver;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import util.UpdateAppUtils;


public class MainActivity extends BaseActivity {

    private Disposable downDisposable;
    private ProgressBar progressBar;
    private TextView textView4;
    private Button upgrade;
    private long downloadLength = 0;
    private long contentLength = 0;
    private String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    //请求状态码
    private static int REQUEST_PERMISSION_CODE = 1;

    //申请录音权限
    private static final int GET_RECODE_AUDIO = 1;

    private static String[] PERMISSION_AUDIO = {
            Manifest.permission.RECORD_AUDIO
    };

    @SuppressLint("HandlerLeak")
    private final Handler Handler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                JPushInterface.setAlias(getApplicationContext(), 1, alias);
            }
        }
    };
    private JPushMessageReceiver jPushMessageReceiver = new JPushMessageReceiver() {
        @Override
        public void onAliasOperatorResult(Context context, JPushMessage jPushMessage) {
            super.onAliasOperatorResult(context, jPushMessage);

            if (jPushMessage.getErrorCode() == 6002) {//超时处理
                Message obtain = Message.obtain();
                obtain.what = 100;
                Handler.sendMessageDelayed(obtain, 1000 * 60);//60秒后重新验证
            } else {
                Log.e("onAliasOperatorResult: ", jPushMessage.getErrorCode() + "");
            }
        }
    };
    private String userId;
    private String alias;
    private JGBroadcastReceiver receiver;
    private int version;


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void On(String uid) {
        userId = uid;
    }

    private void setAlias() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }


    }

    private String anzhuo_link;

    private long mExitTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                //后台运行 不结束程序 只是退出到后台
                Intent intent = new Intent();
                intent.setAction("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
                startActivity(intent);
                //System.exit(0);   //常规java、c#的标准退出法，返回值为0代表正常退出 结束程序
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 1);
            }
        }

        verifyStoragePermissions(this);
    }

    private void verifyStoragePermissions(MainActivity mainActivity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(mainActivity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
// We don't have permission so prompt the user
            ActivityCompat.requestPermissions(mainActivity, PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }

    }


    public NoScrollViewPager vp;
    CommonTabLayout bottom_navigation;
    private List<Fragment> fragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> customTabEntities = new ArrayList<>();


    @Override
    protected int getLayoutId() {
        getVersion();
        return R.layout.activity_main;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }

    public String getVersion() {

        try {

            PackageManager manager = getPackageManager();

            PackageInfo info = manager.getPackageInfo(getPackageName(), 0);

            version = info.versionCode;

            return "版本：" + version;

        } catch (Exception e) {

            e.printStackTrace();

            return "找不到版本号";

        }

    }

    @Override
    protected void initView() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        NetUtils.getInstance().getApi().getUpdate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Update>() {


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Update update) {
                        Update.DataBean data = update.getData();
                        int anzhuo_num = data.getAnzhuo_num();
                        anzhuo_link = data.getAnzhuo_link();

                        Log.i("xxx", anzhuo_link + "安卓");
                        Log.i("xxx", version + "安卓");
                        if (anzhuo_num > version) {
                            UpdateAppUtils.from(MainActivity.this)
                                    .checkBy(UpdateAppUtils.CHECK_BY_VERSION_NAME) //更新检测方式，默认为VersionCode
                                    .serverVersionCode(2)
                                    .serverVersionName("2.0")
                                    .apkPath(anzhuo_link)
                                    .downloadBy(UpdateAppUtils.DOWNLOAD_BY_APP) //下载方式：app下载、手机浏览器下载。默认app下载
                                    .isForce(true) //是否强制更新，默认false 强制更新情况下用户不同意更新则不能使用app
                                    .update();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        vp = findViewById(R.id.one_vp);
        bottom_navigation = findViewById(R.id.bottom_navigation);
        Home_page home_page = new Home_page();
        Take_photos take_photos = new Take_photos();
        Task_page task_page = new Task_page();
        Find_page find_page = new Find_page();
        My_page my_page = new My_page();
        fragments.add(home_page);
        fragments.add(take_photos);
        fragments.add(task_page);
        fragments.add(find_page);
        fragments.add(my_page);
        CustomTabEntityDemo demo1 = new CustomTabEntityDemo("首页", R.mipmap.icon_home_page_selected, R.mipmap.icon_home_page);
        CustomTabEntityDemo demo2 = new CustomTabEntityDemo("拍照点评", R.mipmap.icon_photograph_selected, R.mipmap.icon_photograph);
        CustomTabEntityDemo demo3 = new CustomTabEntityDemo("选课", R.mipmap.icon_xuke_select, R.mipmap.icon_xuanke_se);
        CustomTabEntityDemo demo4 = new CustomTabEntityDemo("发现", R.mipmap.icon_find_select, R.mipmap.icon_find);
        CustomTabEntityDemo demo5 = new CustomTabEntityDemo("我的", R.mipmap.icon_my_selected, R.mipmap.icon_my);
        customTabEntities.add(demo1);
        customTabEntities.add(demo2);
        customTabEntities.add(demo3);
        customTabEntities.add(demo4);
        customTabEntities.add(demo5);

        bottom_navigation.setTabData(customTabEntities);
        MyViewPager myViewPager = new MyViewPager(getSupportFragmentManager());
        vp.setAdapter(myViewPager);
        vp.setOffscreenPageLimit(4);
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void postEvent(String key) {

        if(key!=null){

            if(key.equals("offline")){
                new AlertDialog.Builder(MainActivity.this).setTitle("下线通知").setMessage("您的账号在另一台设备登录。如非本人操作，则密码可能已泄漏，建议立即修改密码").setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(),Verification_code_login.class);
                        startActivity(intent);

                    }
                }).show();
                SharedPreferences code = getSharedPreferences("code", MODE_PRIVATE);
                SharedPreferences.Editor edit = code.edit();
                    edit.putInt("code",0);

                edit.commit();
            }
        }


    }

    @Override
    protected void initData() {

        requestPermission();
        int permission = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, PERMISSION_AUDIO,
                    GET_RECODE_AUDIO);
        }
        //底部导航栏监听
        bottom_navigation.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp.setCurrentItem(position);
                SharedPreferences code = getSharedPreferences("code", MODE_PRIVATE);
                int code1 = code.getInt("code", 0);
                if (position == 4) {
                    if (code1 == 0) {
                        Intent intent = new Intent(getApplicationContext(), Login_interface.class);
                        startActivity(intent);
                    }

                }

            }

            @Override
            public void onTabReselect(int position) {
            }
        });


    }


    public static final int CAMERA_REQ_CODE = 111;

    private void requestPermission() {
        // 判断当前Activity是否已经获得了该权限
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            // 如果App的权限申请曾经被用户拒绝过，就需要在这里跟用户做出解释
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {

                Toast.makeText(this, "请进入设置-应用管理-打开相机权限", Toast.LENGTH_SHORT).show();
            } else {
                // 进行权限请求
                ActivityCompat
                        .requestPermissions(
                                this,
                                new String[]{Manifest.permission.CAMERA},
                                CAMERA_REQ_CODE);
            }
        }
    }


    //创建内部类进行我们的数据转换
    class MyViewPager extends FragmentPagerAdapter {
        public MyViewPager(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public void destroyItem(@NonNull View container, int position, @NonNull Object object) {
            super.destroyItem(container, position, object);
            vp.setOffscreenPageLimit(position);
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(this);
    }
}
