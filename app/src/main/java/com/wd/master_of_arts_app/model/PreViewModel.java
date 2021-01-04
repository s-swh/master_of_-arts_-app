package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.Preview;
import com.wd.master_of_arts_app.contreater.PreViewContreater;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/4 15:32
 */
public class PreViewModel implements PreViewContreater.IModel {
    @Override
    public void OnPreViewSuccess(String token, int unit_id, OnPreCoallack coallack) {
        NetUtils.getInstance().getApi().getPreview(token,unit_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Preview>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Preview preview) {
                            if(coallack!=null){
                                coallack.OnPreView(preview);
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
