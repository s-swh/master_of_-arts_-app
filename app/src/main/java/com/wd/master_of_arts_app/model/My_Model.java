package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.activity.myactivity.My_Course;
import com.wd.master_of_arts_app.bean.Privacy_policyBean;
import com.wd.master_of_arts_app.bean.User_agreement;
import com.wd.master_of_arts_app.contreater.My_Contract;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/5 15:29
 */
public class My_Model implements My_Contract.IModel {

    /**
     *
     * @param article_id
     * @param onUserCoallack
     * 用户协议
     */
    @Override
    public void OnUser_success(int article_id, OnUserCoallack onUserCoallack) {
        NetUtils.getInstance().getApi().getUser_agreement(article_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User_agreement>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User_agreement user_agreement) {
                        if(onUserCoallack!=null){
                            onUserCoallack.OnUser_agreement(user_agreement);
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

    /**
     *
     * @param article_id
     * @param onPolicyCoallack
     * 隐私政策
     */
    @Override
    public void OnPolicySuccess(int article_id, OnPolicyCoallack onPolicyCoallack) {
        NetUtils.getInstance().getApi().getPolicyBean(article_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Privacy_policyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Privacy_policyBean privacyPolicyBean) {
                        if(onPolicyCoallack!=null){
                            onPolicyCoallack.Privacy_policy(privacyPolicyBean);
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
