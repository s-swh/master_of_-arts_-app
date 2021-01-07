package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.MoreComm;
import com.wd.master_of_arts_app.contreater.MoreContreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/7 8:58
 */
public class MoreModel implements MoreContreanter.IModel {
    @Override
    public void OnMoreSuccess(int course_id, int p, int per, MoreCoallack coallack) {
        NetUtils.getInstance().getApi().getMore(course_id, p, per)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MoreComm>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MoreComm moreComm) {
                        if(coallack!=null){
                            coallack.OnMore(moreComm);
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
