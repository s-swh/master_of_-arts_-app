package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.MyClassDate;
import com.wd.master_of_arts_app.bean.MyCourseDetailsBean;
import com.wd.master_of_arts_app.bean.MyCurse;
import com.wd.master_of_arts_app.contreater.MyCourseContreater;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/28 11:17
 */
public class MyCourseModel implements MyCourseContreater.IModel {
    //我的课程列表
    @Override
    public void OnMyCourseSuccess(String token, int p, int per, MyCourseCoallack courseCoallack) {
        NetUtils.getInstance().getApi().getCurse(token, p, per)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyCurse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyCurse myCurse) {
                    if(courseCoallack!=null){
                        courseCoallack.OnCourse(myCurse);
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
    public void OnCourseDatailsSuccess(String token, int order_id, int course_time_id, MyCourseDatilsCoallack myCourseDatilsCoallack) {
        NetUtils.getInstance().getApi().getCourseBean(token, order_id, course_time_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyCourseDetailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyCourseDetailsBean myCourseDetailsBean) {
                        if(myCourseDatilsCoallack!=null){
                            myCourseDatilsCoallack.OnCourseDatails(myCourseDetailsBean);
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
    //我的课程日期
    @Override
    public void onMyClassDateSuccess(String token, MyClassDateCoallack myClassDateCoallack) {
        NetUtils.getInstance().getApi().getMyClass(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyClassDate>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyClassDate myClassDate) {
                        if(myClassDateCoallack!=null){
                            myClassDateCoallack.OnMyClassDate(myClassDate);
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
