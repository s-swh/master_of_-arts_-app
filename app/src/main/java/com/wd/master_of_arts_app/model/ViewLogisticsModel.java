package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.Logistics;
import com.wd.master_of_arts_app.contreater.ViewLogisticsConreater;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/31 9:20
 */
public class ViewLogisticsModel implements ViewLogisticsConreater.IModel {
    @Override
    public void OnViewLoginsticsSuccess(String token, String logistics, String express_number, ViewLoginsticsCoallack coallack) {
        NetUtils.getInstance().getApi().getLogist(token, logistics, express_number)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Logistics>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Logistics logistics) {
                                if(coallack!=null){
                                  coallack.OnViewLogistics(logistics);
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
