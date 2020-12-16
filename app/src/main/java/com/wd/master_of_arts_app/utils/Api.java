package com.wd.master_of_arts_app.utils;

import com.wd.master_of_arts_app.bean.AccountLogin;
import com.wd.master_of_arts_app.bean.CodeBean;
import com.wd.master_of_arts_app.bean.SMSLogin;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/3 10:22
 */
public interface Api {
    //todo 获取短信验证码  http://test.54artist.com/wap/Sms/send
    @POST("wap/Sms/send")
    @FormUrlEncoded
    Observable<CodeBean>getCodeBean(@Field("phone")String phone);
    //todo 短信验证码登录http://test.54artist.com/wap/UserAccount/loginByCode
    @POST("wap/UserAccount/loginByCode")
    @FormUrlEncoded
    Observable<SMSLogin>getSmsLogin(@Field("phone")String phone,@Field("code")String code);
    //todo 账号密码登录 http://test.54artist.com/wap/UserAccount/login
    @POST("wap/UserAccount/login")
    @FormUrlEncoded
    Observable<AccountLogin>getAccount(@Field("account")String account,@Field("pwd")String pwd);
}
