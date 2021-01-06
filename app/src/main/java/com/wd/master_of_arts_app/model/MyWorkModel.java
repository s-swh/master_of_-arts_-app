package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.HomeWorkBean;
import com.wd.master_of_arts_app.contreater.MyWorkContreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/6 11:19
 */
public class MyWorkModel implements MyWorkContreanter.IModel {
    @Override
    public void OnWorkSuccess(int work_id, WorkCoallack coallack) {
        NetUtils.getInstance().getApi().getHomeBean(work_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeWorkBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeWorkBean workBean) {
                        if(coallack!=null){
                            coallack.OnMyWork(workBean);
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
