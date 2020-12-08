package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.Beanner_Bean;
import com.wd.master_of_arts_app.contreater.HomePage_Contract;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/3 17:12
 */
public class HomePage_Model implements HomePage_Contract.IModel {


    @Override
    public void BeanSuccess(int cat_id, String field, OnBeanSuccessCoallack onBeanSuccessCoallack) {
        NetUtils.getInstance().getApi().getBeanner(cat_id, field)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Beanner_Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Beanner_Bean beanner_bean) {
                            if(onBeanSuccessCoallack!=null){
                                onBeanSuccessCoallack.OnBeanSuccess(beanner_bean);
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
