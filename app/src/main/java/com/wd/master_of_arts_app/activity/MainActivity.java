package com.wd.master_of_arts_app.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.app.CommonAction;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.CustomTabEntityDemo;
import com.wd.master_of_arts_app.customview.NoScrollViewPager;
import com.wd.master_of_arts_app.fragment.Find_page;
import com.wd.master_of_arts_app.fragment.Home_page;
import com.wd.master_of_arts_app.fragment.My_page;
import com.wd.master_of_arts_app.fragment.Take_photos;
import com.wd.master_of_arts_app.fragment.Task_page;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    //读写权限
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    //请求状态码
    private static int REQUEST_PERMISSION_CODE = 1;

    //申请录音权限
    private static final int GET_RECODE_AUDIO = 1;

    private static String[] PERMISSION_AUDIO = {
            Manifest.permission.RECORD_AUDIO
    };



    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;

    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            CommonAction.getInstance().OutSign();
            System.exit(0);

        }
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
            ActivityCompat.requestPermissions(mainActivity,PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }

    }


    NoScrollViewPager vp;
    CommonTabLayout bottom_navigation;
    private List<Fragment> fragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> customTabEntities = new ArrayList<>();

    @Override
    protected int getLayoutId() {

        return R.layout.activity_main;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }

    @Override
    protected void initView() {
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
    }


}
