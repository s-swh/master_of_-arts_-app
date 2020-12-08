package com.wd.master_of_arts_app.activity.myactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.fragment.myorderfragment.Cancelled;
import com.wd.master_of_arts_app.fragment.myorderfragment.Completed;
import com.wd.master_of_arts_app.fragment.myorderfragment.Completed_Comment;
import com.wd.master_of_arts_app.fragment.myorderfragment.To_be_paid;
import com.wd.master_of_arts_app.fragment.myorderfragment.Whole;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的订单
 */
public class My_order extends BaseActivity {

    TabLayout tab;

    ViewPager vip;
    private List<String> tbs=new ArrayList<>();
    private List<Fragment> fragmentList=new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_order;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }

    @Override
    protected void initView() {
        tab=    findViewById(R.id.tab);
        vip= findViewById(R.id.vip);
    }
    @OnClick(R.id.oncDestruction)
    public void onDestrution(){
        finish();
    }
    @Override
    protected void initData() {
        Whole whole = new Whole();
        To_be_paid to_be_paid = new To_be_paid();
        Completed completed = new Completed();
        Completed_Comment completed_comment = new Completed_Comment();
        Cancelled cancelled = new Cancelled();
        fragmentList.add(whole);
        fragmentList.add(to_be_paid);
        fragmentList.add(completed);
        fragmentList.add(completed_comment);
        fragmentList.add(cancelled);
        tbs.add("全部");
        tbs.add("待付款");
        tbs.add("已完成");
        tbs.add("已评论");
        tbs.add("已取消");
        tab.addTab(tab.newTab().setTag(tbs.get(0)));
        tab.addTab(tab.newTab().setTag(tbs.get(1)));
        tab.addTab(tab.newTab().setTag(tbs.get(2)));
        tab.addTab(tab.newTab().setTag(tbs.get(3)));
        tab.addTab(tab.newTab().setTag(tbs.get(4)));
        tab.setupWithViewPager(vip);
        MyViewPager myViewPager = new MyViewPager(getSupportFragmentManager());
        vip.setAdapter(myViewPager);
        vip.setOffscreenPageLimit(4);
    }
    class MyViewPager extends FragmentPagerAdapter {
        public MyViewPager(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tbs.get(position);
        }
    }
}
