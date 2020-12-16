package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.AccountLogin;
import com.wd.master_of_arts_app.bean.CodeBean;
import com.wd.master_of_arts_app.bean.SMSLogin;
import com.wd.master_of_arts_app.contreater.LoginContreater;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/16 8:16
 */
public class LoginModel implements LoginContreater.IModel {
    // todo  短信验证码获取
    @Override
    public void OnCode(String phone, OnCodeCoallack onCodeCoallack) {
        NetUtils.getInstance().getApi().getCodeBean(phone)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CodeBean codeBean) {
                    if(onCodeCoallack!=null){
                        onCodeCoallack.OnCodeSuccess(codeBean);
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
    //todo 短信验证码登录
    @Override
    public void OnLoginSuccess(String phone, String code, OnLoginCoallack onLoginCoallack) {
    NetUtils.getInstance().getApi().getSmsLogin(phone, code)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<SMSLogin>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(SMSLogin smsLogin) {
                    if(onLoginCoallack!=null){
                        onLoginCoallack.OnCodeLogin(smsLogin);
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
    //todo 账号密码登录
    @Override
    public void OnAccout(String account, String pwd, OnAccoutCoallack onAccoutCoallack) {
        NetUtils.getInstance().getApi().getAccount(account, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AccountLogin>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AccountLogin accountLogin) {
                        if(onAccoutCoallack!=null){
                            onAccoutCoallack.OnAccoutLogin(accountLogin);
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
