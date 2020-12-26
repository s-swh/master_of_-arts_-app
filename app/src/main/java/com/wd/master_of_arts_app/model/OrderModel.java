package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.Purchase;
import com.wd.master_of_arts_app.contreater.OrderContreater;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description: 订单model
 * @date :2020/12/26 16:32
 */
public class OrderModel implements OrderContreater.IModel {
    @Override
    public void OnPruchaseSuccess(String token, int course_id, int course_time_id, OnPruchaseCoallack coallack) {
        NetUtils.getInstance().getApi().getPurchase(token, course_id, course_time_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Purchase>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Purchase purchase) {
                        if(coallack!=null){
                            coallack.OnPurchase(purchase);
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
