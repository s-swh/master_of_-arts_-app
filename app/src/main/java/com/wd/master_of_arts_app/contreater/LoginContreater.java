package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.base.RetrievePassword;
import com.wd.master_of_arts_app.bean.AccountLogin;
import com.wd.master_of_arts_app.bean.CodeBean;
import com.wd.master_of_arts_app.bean.SMSLogin;

/**
 * @author 时文豪
 * @description: 登录MVP
 * @date :2020/12/16 8:15
 */
public interface LoginContreater {
    interface IView extends IBaseView{
        // 获取短信验证码
        void OnCodeSuccess(CodeBean codeBean);
        // 短信验证码登录
        void OnCodeLogin(SMSLogin smsLogin);
        // 账号密码登录
        void OnAccoutLogin(AccountLogin accountLogin);
        //重置密码
        void OnReturnPwd(RetrievePassword retrievePassword);
    }
    interface IPreanter{
        // 获取短信验证码拼参
        void OnCode(String phone);
        // 短信验证码登录
        void OnLoginSuccess(String phone,String code);
        // 账号密码登录
        void OnAccout(String account,String pwd);
        //重置密码
        void OnRetrieveSuccess(String phone,String code,String pwd);
    }
    interface IModel{
        // 短信获取
        void OnCode(String phone,OnCodeCoallack onCodeCoallack);
        interface OnCodeCoallack{
            void OnCodeSuccess(CodeBean codeBean);
        }
        // 短信验证码登录
        void OnLoginSuccess(String phone,String code,OnLoginCoallack onLoginCoallack);
        interface OnLoginCoallack{
            void OnCodeLogin(SMSLogin smsLogin);
        }
        //  账号密码登录
        void OnAccout(String account,String pwd,OnAccoutCoallack onAccoutCoallack);
        interface OnAccoutCoallack{
            void OnAccoutLogin(AccountLogin accountLogin);
        }
        //重置密码
        void OnRetrieveSuccess(String phone,String code,String pwd,RetrieveCoallack retrieveCoallack);
        interface RetrieveCoallack{
            void OnReturnPwd(RetrievePassword retrievePassword);
        }
    }
}
