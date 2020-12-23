package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.adapter.ActivityAdapter;
import com.wd.master_of_arts_app.adapter.CommentAdapter;
import com.wd.master_of_arts_app.adapter.ServiceActivity;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.AgeInterface;
import com.wd.master_of_arts_app.bean.CourseDetails;
import com.wd.master_of_arts_app.bean.CourseList;
import com.wd.master_of_arts_app.contreater.CourseContreater;
import com.wd.master_of_arts_app.preanter.CoursePreanter;

import java.util.List;

import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCResizeImageView;

public class CourseDetailsActivity extends BaseActivity implements CourseContreater.IView {


    private TextView tv,itle,present_price,original_price,  attend,ic_name ;
    private JCResizeImageView img;
    private ImageView ic;

    private RecyclerView rv_service,rv_service1,rcv;


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
        img = findViewById(R.id.jcrImage);
        itle=  findViewById(R.id.itle);
        present_price=  findViewById(R.id.present_price);
        original_price=  findViewById(R.id.original_price);
        rv_service1= findViewById(R.id.rv_service1);
        rv_service = findViewById(R.id.rv_service);
        attend=  findViewById(R.id.attend1);
        ic = findViewById(R.id.ic);
        ic_name=  findViewById(R.id.ic_name);
        rcv = findViewById(R.id.rec_rv);

    }
    @OnClick(R.id.itreturn)
    public void retu(){
        finish();
    }
    @Override
    protected void initData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        BasePreantert basePreantert = getmPreantert();
        if(basePreantert instanceof CourseContreater.IPreanter){
            ((CourseContreater.IPreanter) basePreantert).OnCourseOnSuccess(id);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rv_service.setLayoutManager(linearLayoutManager1);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rv_service1.setLayoutManager(linearLayoutManager2);
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
        CourseDetails.DataBean data = courseDetails.getData();
        String course_name = data.getCourse_name();
        tv.setText(course_name);
        String icon = data.getIcon();
        Glide.with(this).load(icon).into(img);
        itle.setText( data.getContent());
        present_price.setText(data.getPrice()+"￥");
        original_price.setText(data.getOld_price()+"￥");
        //活动适配器
        List<CourseDetails.DataBean.MarkBean> mark = data.getMark();
        ActivityAdapter activityAdapter = new ActivityAdapter(this, mark);
        rv_service1.setAdapter(activityAdapter);

        List<CourseDetails.DataBean.ServiceBean> service = data.getService();
        //服务适配器
        ServiceActivity serviceActivity = new ServiceActivity(this, service);
        rv_service.setAdapter(serviceActivity);


        attend.setText(data.getTime_detail());
        Glide.with(this).load(data.getTeacher_avatar()).into(ic);
        ic_name.setText(data.getTeacher_name());

        List<CourseDetails.DataBean.CommentListBean> comment_list = data.getComment_list();
        //适配器加载评论列表
        CommentAdapter commentAdapter = new CommentAdapter(this, comment_list);
        rcv.setAdapter(commentAdapter);
    }
}
