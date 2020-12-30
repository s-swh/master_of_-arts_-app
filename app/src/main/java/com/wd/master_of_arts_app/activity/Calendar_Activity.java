package com.wd.master_of_arts_app.activity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.MyClassDate;
import com.wd.master_of_arts_app.bean.MyCourseDetailsBean;
import com.wd.master_of_arts_app.bean.MyCurse;
import com.wd.master_of_arts_app.contreater.MyCourseContreater;
import com.wd.master_of_arts_app.customview.CalendarView;
import com.wd.master_of_arts_app.customview.WeekView;
import com.wd.master_of_arts_app.preanter.MyCoursePreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/4 14:17
 */
public class Calendar_Activity extends AppCompatActivity {




    private String date;
    private CalendarView mCalendarView;
    private WeekView weekkView;
    private List<String> mDatas;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        mCalendarView =  findViewById(R.id.calendarView);
        weekkView = findViewById(R.id.weekkView);
        SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
        String token1 = token.getString("token", "");
        NetUtils.getInstance().getApi().getMyClass(token1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyClassDate>() {



                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyClassDate myClassDate) {
                        List<MyClassDate.DataBean> data = myClassDate.getData();
                        weekkView.setTextSize(15);
                        weekkView.setTextColor(Color.BLACK);
                        mDatas = new ArrayList<>();
                        for (int i = 0; i < data.size(); i++) {
                            String date = data.get(i).getDate();
                            mDatas.add(date);
                            mCalendarView.setSelectedDates(mDatas);
                        }

                        mCalendarView.setOptionalDate(mDatas);
                        mCalendarView.setClickable(true);


                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

// 设置不可以被点击



    }
}
