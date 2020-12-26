package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.ListOfWorks;
import com.wd.master_of_arts_app.contreater.worksContreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:  作品model
 * @date :2020/12/25 13:47
 */
public class WorksModel implements worksContreanter.IModel {
    @Override
    public void OnWorksSuccess(String token, String is_comment, int p, int per, OnWorksCoallack onWorksCoallack) {
        NetUtils.getInstance().getApi().getListOf(token, is_comment, p, per)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListOfWorks>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ListOfWorks listOfWorks) {
                        if(onWorksCoallack!=null){
                            onWorksCoallack.OnWorks(listOfWorks);
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
