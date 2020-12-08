package com.wd.master_of_arts_app.activity;

import android.Manifest;
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
import com.wd.master_of_arts_app.fragment.Find_page;
import com.wd.master_of_arts_app.fragment.Home_page;
import com.wd.master_of_arts_app.fragment.My_page;
import com.wd.master_of_arts_app.fragment.Take_photos;
import com.wd.master_of_arts_app.fragment.Task_page;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    //读写权限
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    //请求状态码
    private static int REQUEST_PERMISSION_CODE = 1;





    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;

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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
            }
        }
        CommonAction.getInstance().addActivity(this);
    }

    ViewPager vp;
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.i("MainActivity", "申请的权限为：" + permissions[i] + ",申请结果：" + grantResults[i]);
            }
        }
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
        CustomTabEntityDemo demo1 = new CustomTabEntityDemo("首页", R.mipmap.icon_nav_home_selected, R.drawable.ic_launcher_background);
        CustomTabEntityDemo demo2 = new CustomTabEntityDemo("拍照点评", R.mipmap.icon_nav_photo_nomal_selected, R.mipmap.icon_nav_photo_nomal);
        CustomTabEntityDemo demo3 = new CustomTabEntityDemo("选课", R.mipmap.icon_xuke_select, R.mipmap.icon_xuanke_se);
        CustomTabEntityDemo demo4 = new CustomTabEntityDemo("发现", R.mipmap.icon_nav_find_nomal_selected, R.mipmap.icon_nav_find_nomal);
        CustomTabEntityDemo demo5 = new CustomTabEntityDemo("我的", R.mipmap.icon_nav_me_nomal_selected, R.mipmap.icon_nav_me_nomal);
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
        //viewPager 监听
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottom_navigation.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
