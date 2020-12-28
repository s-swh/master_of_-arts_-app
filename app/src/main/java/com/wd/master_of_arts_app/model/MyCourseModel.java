package com.wd.master_of_arts_app.model;

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
}
