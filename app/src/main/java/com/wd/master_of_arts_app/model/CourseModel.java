package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.AgeInterface;
import com.wd.master_of_arts_app.bean.CourseList;
import com.wd.master_of_arts_app.contreater.CourseContreater;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description: 课程model层
 * @date :2020/12/18 15:31
 */
public class CourseModel implements CourseContreater.IModel {

        // 课程接口
    @Override
    public void OnCourseSuccess(String cat_id, String is_top, String age, int p, int per, CourseCollack courseCollack) {
        NetUtils.getInstance().getApi().getCourseList(cat_id, is_top, age, p, per)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CourseList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CourseList courseList) {
                        if(courseCollack!=null){
                            courseCollack.OnCourse(courseList);
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
    // 年龄段
    @Override
    public void OnAgeSuccess(AgeCoallack ageCoallack) {
        NetUtils.getInstance().getApi().getAge()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AgeInterface>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AgeInterface ageInterface) {
                        if(ageCoallack!=null){
                            ageCoallack.onAgeInterface(ageInterface);
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
