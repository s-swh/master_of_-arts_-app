package com.wd.master_of_arts_app.activity;

import android.content.Intent;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.myactivity.My_Course;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

import java.util.Calendar;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/4 14:17
 */
public class Calendar_Activity extends BaseActivity {
    private CalendarView cd;
    private TextView tvw;

    @Override
    protected int getLayoutId() {
        return R.layout.calendar;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }

    @Override
    protected void initView() {
        cd = findViewById(R.id.cdv);
        tvw = findViewById(R.id.curriculum);
        tvw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Calendar now = Calendar.getInstance();
        int i = now.get(Calendar.YEAR);
        int i1 = now.get(Calendar.MONTH);
        int i2 = now.get(Calendar.DAY_OF_MONTH);
        int j=i1+1;
        tvw.setText("点击查看"+i+"年"+j+"月"+i2+"号课程");
    }

    @Override
    protected void initData() {
        cd.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                int j=i1+1;
                Toast.makeText(getApplicationContext(), i+"   "+j+"    "+i2, Toast.LENGTH_SHORT).show();
                tvw.setText("点击查看"+i+"年"+j+"月"+i2+"号课程");
            }
        });
    }
}
