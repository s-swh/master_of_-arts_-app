package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.AgeInterface;
import com.wd.master_of_arts_app.bean.CourseDetails;
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
    public void OnCourseSuccess(String cat_id, String is_top,String course_name, String age, int p, int per, CourseCollack courseCollack) {
        NetUtils.getInstance().getApi().getCourseList(cat_id, is_top,course_name, age, p, per)
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
//课程详情
    @Override
    public void OnCourseOnSuccess(int course_time_id, CourseCoallack courseCoallack) {
        NetUtils.getInstance().getApi().getCourseDatails(course_time_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CourseDetails>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CourseDetails courseDetails) {
                        if(courseCoallack!=null){
                            courseCoallack.OnCourse(courseDetails);
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
