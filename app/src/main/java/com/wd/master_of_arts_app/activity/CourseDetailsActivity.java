package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.AgeInterface;
import com.wd.master_of_arts_app.bean.CourseDetails;
import com.wd.master_of_arts_app.bean.CourseList;
import com.wd.master_of_arts_app.contreater.CourseContreater;
import com.wd.master_of_arts_app.preanter.CoursePreanter;

public class CourseDetailsActivity extends BaseActivity implements CourseContreater.IView {


    private TextView tv;
    private ImageView iv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_course_details;
    }

    @Override
    protected BasePreantert initModel() {
        return new CoursePreanter(this);
    }

    @Override
    protected void initView() {
        tv = findViewById(R.id.tv_name);
        iv = findViewById(R.id.iv_iv);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        BasePreantert basePreantert = getmPreantert();
        if(basePreantert instanceof CourseContreater.IPreanter){
            ((CourseContreater.IPreanter) basePreantert).OnCourseOnSuccess(id);
        }
    }
    //课程列表
    @Override
    public void OnCourse(CourseList courseList) {

    }
    //年龄
    @Override
    public void onAgeInterface(AgeInterface ageInterface) {

    }
    //课程详情
    @Override
    public void OnCourse(CourseDetails courseDetails) {
        String msg = courseDetails.getMsg();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        CourseDetails.DataBean data = courseDetails.getData();
        String course_name = data.getCourse_name();
        tv.setText(course_name);
        String icon = data.getIcon();
        Glide.with(this).load(icon).into(iv);
    }
}
