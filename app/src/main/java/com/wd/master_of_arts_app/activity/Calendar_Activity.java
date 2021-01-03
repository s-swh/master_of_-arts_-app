package com.wd.master_of_arts_app.activity;

import android.content.Intent;
import android.content.SharedPreferences;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.myactivity.MyCourseDetails;
import com.wd.master_of_arts_app.adapter.CourseCheckingAdapter;
import com.wd.master_of_arts_app.adapter.MyCourseAdapter;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.CourseChecking;
import com.wd.master_of_arts_app.bean.MyClassDate;

import com.wd.master_of_arts_app.contreater.DateTableContreater;


import com.wd.master_of_arts_app.preanter.DateLablePreanter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;


/**
 * @author 时文豪
 * @description:
 * @date :2020/12/4 14:17
 */
public class Calendar_Activity extends BaseActivity implements DateTableContreater.IView {

    private CalendarView calendarView;
    private TextView tv;
    private RecyclerView calend_rv;
    private ImageView fanhui;
    private LinearLayout ve;
    private TextView tvv;


    @Override
    protected int getLayoutId() {
        return R.layout.calendar;
    }

    @Override
    protected BasePreantert initModel() {
        return new DateLablePreanter(this);
    }

    @Override
    protected void initView() {
        calendarView=  findViewById(R.id.chart);
        tv = findViewById(R.id.tv_date);
        tvv = findViewById(R.id.tv_alarm);
        calend_rv = findViewById(R.id.calend_rv);
        fanhui = findViewById(R.id.fanhui);
        ve = findViewById(R.id.liv_view);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        tv.setText(simpleDateFormat.format(date)+"");
    }

    @Override
    protected void initData() {
        SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
        String token1 = token.getString("token", "");
        BasePreantert basePreantert = getmPreantert();
        if (basePreantert instanceof DateTableContreater.IPreanter) {
            ((DateTableContreater.IPreanter) basePreantert).DateSuccess(token1);
        }
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void DateTable(MyClassDate myClassDate) {
        List<MyClassDate.DataBean> data = myClassDate.getData();
        HashMap<String, Calendar> map = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {

            MyClassDate.DataBean dataBean = data.get(i);
            String date = dataBean.getDate();
            Log.i("date", date);
            String substring = date.substring(0, 4);
            String substring1 = date.substring(5, 7);
            String substring2 = date.substring(8, 10);
                int yrar = Integer.parseInt(substring);
                int month=Integer.parseInt(substring1);
                int day=Integer.parseInt(substring2);
                Calendar calendar1 = getSchemeCalendar(yrar, month, day, "课");
                map.put(calendar1.toString(),calendar1);
        }
        calendarView.setSchemeDate(map);
       calendarView.setOnMonthChangeListener(new CalendarView.OnMonthChangeListener() {
           @Override
           public void onMonthChange(int year, int month) {
               tv.setText(year+"年"+month+"月");
           }
       });
       calendarView.setOnCalendarSelectListener(new CalendarView.OnCalendarSelectListener() {
           @Override
           public void onCalendarOutOfRange(Calendar calendar) {

           }

           @Override
           public void onCalendarSelect(Calendar calendar, boolean isClick) {
               int year = calendar.getYear();
               int month = calendar.getMonth();
               int day = calendar.getDay();
                String date=year+"-"+month+"-"+day;

               BasePreantert basePreantert = getmPreantert();
               if(basePreantert instanceof DateTableContreater.IPreanter){
                   SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
                   String token1 = token.getString("token", "");
                   ((DateTableContreater.IPreanter) basePreantert).OnCourseCheckingSuccess(token1,date);
               }
               tvv.setText(date);
               LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
               calend_rv.setLayoutManager(linearLayoutManager);
           }
       });


    }

    @Override
    public void CourseChecking(CourseChecking courseChecking) {
        List<CourseChecking.DataBean> data = courseChecking.getData();
        if(data!=null){
            CourseCheckingAdapter courseCheckingAdapter = new CourseCheckingAdapter(getApplicationContext(), data);
            courseCheckingAdapter.setOnClick(new MyCourseAdapter.OnClick() {
                @Override
                public void OnCliack(int id, int order_id) {
                    Intent intent = new Intent(getApplicationContext(), MyCourseDetails.class);

                    intent.putExtra("icqd",id);
                    intent.putExtra("order_id",order_id);
                    startActivity(intent);
                }
            });
            ve.setVisibility(View.VISIBLE);
            calend_rv.setAdapter(courseCheckingAdapter);
        }else{
            ve.setVisibility(View.GONE);
        }

    }

    private Calendar getSchemeCalendar(int year, int month, int day, String text) {

        Calendar calendar = new Calendar();

        calendar.setYear(year);

        calendar.setMonth(month);

        calendar.setDay(day);

        calendar.setScheme(text);

        calendar.setSchemeColor(RED);

        return calendar;

    }


}
