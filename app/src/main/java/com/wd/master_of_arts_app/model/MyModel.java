package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.SignOut;
import com.wd.master_of_arts_app.contreater.MyContreater;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description: 我的资料Model
 * @date :2020/12/19 11:07
 */
public class MyModel implements MyContreater.IModel {
    @Override
    public void SignOutSuccess(String token, SignOutCoallack signOutCoallack) {
        NetUtils.getInstance().getApi().getSignOut(token)
               .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SignOut>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SignOut signOut) {
                        if(signOutCoallack!=null){
                            signOutCoallack.OnSignOut(signOut);
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
