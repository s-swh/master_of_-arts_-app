package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.base.CourseChecking;
import com.wd.master_of_arts_app.bean.MyClassDate;
import com.wd.master_of_arts_app.contreater.DateTableContreater;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/3 9:38
 */
public class DateModel implements DateTableContreater.IModel {
    @Override
    public void DateSuccess(String token, DateTableCoallack coallack) {
        NetUtils.getInstance().getApi().getMyClass(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyClassDate>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyClassDate myClassDate) {
                        if(coallack!=null){
                            coallack.DateTable(myClassDate);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void OnCourseCheckingSuccess(String token, String date, CourseCheckingCoallack courseCheckingCoallack) {
        NetUtils.getInstance().getApi().getCourseChecking(token,date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CourseChecking>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CourseChecking courseChecking) {
                    if(courseCheckingCoallack!=null){
                        courseCheckingCoallack.CourseChecking(courseChecking);
                    }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
