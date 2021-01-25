package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.EditUserInformation;
import com.wd.master_of_arts_app.bean.UserInformation;
import com.wd.master_of_arts_app.contreater.UserInformationConreater;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:  用户详情model
 * @date :2020/12/19 16:14
 */
public class UserInformartionModel implements UserInformationConreater.IModel {
    //用户详情
    @Override
    public void OnUserSuccess(String token, OnSuccessCoallack onSuccessCoallack) {
        NetUtils.getInstance().getApi().getUser(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInformation>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserInformation userInformation) {
                    if(onSuccessCoallack!=null){
                        onSuccessCoallack.OnUserInfor(userInformation);
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
//编辑用户详情
    @Override
    public void EditUserSuccess(String token, String nickname, int sex, String birthday, String province, String city, String county, EditUserCoallack editUserCoallack) {
        NetUtils.getInstance().getApi().getEditUser(token,nickname,sex,birthday,province,city,county)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EditUserInformation>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(EditUserInformation editUserInformation) {
                        if(editUserCoallack!=null){
                            editUserCoallack.OnEditUser(editUserInformation);
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
