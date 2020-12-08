package com.wd.master_of_arts_app.activity.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.Calendar_Activity;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

import butterknife.OnClick;

/**
 * 我的课程
 */
public class My_Course extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_my__course;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }

    @Override
    protected void initView() {

    }
    @OnClick(R.id.oncDestruction)
    public void onDestrution(){
        finish();
    }
    @OnClick(R.id.date)
    public void onDate(){
        //跳转到日期选择
        Intent intent = new Intent(getApplicationContext(), Calendar_Activity.class);
        startActivity(intent);
    }
    @Override
    protected void initData() {

    }
}
