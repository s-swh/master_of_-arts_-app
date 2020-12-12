package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.LogIn;
import com.wd.master_of_arts_app.contreater.LoginContract;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/12 15:31
 */
public class LogModel implements LoginContract.IModel {


    @Override
    public void OnLogin(String account, String pwd, LoginCoallack loginCoallack) {
        NetUtils.getInstance().getApi().getlogin(account, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LogIn>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LogIn logIn) {
                        if (loginCoallack != null) {
                            loginCoallack.OnSuccess(logIn);
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
