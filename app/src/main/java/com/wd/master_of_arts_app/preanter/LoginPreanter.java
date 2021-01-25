package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.base.RetrievePassword;
import com.wd.master_of_arts_app.bean.AccountLogin;
import com.wd.master_of_arts_app.bean.CodeBean;
import com.wd.master_of_arts_app.bean.SMSLogin;
import com.wd.master_of_arts_app.contreater.LoginContreater;
import com.wd.master_of_arts_app.model.LoginModel;
import com.wd.master_of_arts_app.utils.NetUtils;

/**
 * @author 时文豪
 * @description: 登录P层
 * @date :2020/12/16 8:17
 */
public class LoginPreanter extends BasePreantert implements LoginContreater.IPreanter {

    private LoginModel loginModel;

    public LoginPreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        loginModel = new LoginModel();
    }

    @Override
    public void OnCode(String phone) {
        loginModel.OnCode(phone, new LoginContreater.IModel.OnCodeCoallack() {
            @Override
            public void OnCodeSuccess(CodeBean codeBean) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof LoginContreater.IView){
                    LoginContreater.IView view= (LoginContreater.IView) iBaseView;
                    view.OnCodeSuccess(codeBean);
                }
            }
        });
    }

    @Override
    public void OnLoginSuccess(String phone, String code,String registration_id) {
        loginModel.OnLoginSuccess(phone, code,registration_id, new LoginContreater.IModel.OnLoginCoallack() {
            @Override
            public void OnCodeLogin(SMSLogin smsLogin) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof LoginContreater.IView){
                    LoginContreater.IView view= (LoginContreater.IView) iBaseView;
                    view.OnCodeLogin(smsLogin);
                }
            }
        });
    }

    @Override
    public void OnAccout(String account, String pwd,String registration_id) {
        loginModel.OnAccout(account, pwd,registration_id, new LoginContreater.IModel.OnAccoutCoallack() {
            @Override
            public void OnAccoutLogin(AccountLogin accountLogin) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof LoginContreater.IView){
                    LoginContreater.IView view= (LoginContreater.IView) iBaseView;
                    view.OnAccoutLogin(accountLogin);
                }
            }
        });
    }
    //重置密码
    @Override
    public void OnRetrieveSuccess(String phone, String code, String pwd) {
        loginModel.OnRetrieveSuccess(phone, code, pwd, new LoginContreater.IModel.RetrieveCoallack() {
            @Override
            public void OnReturnPwd(RetrievePassword retrievePassword) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof LoginContreater.IView){
                    LoginContreater.IView view= (LoginContreater.IView) iBaseView;
                    view.OnReturnPwd(retrievePassword);
                }
            }
        });
    }
}
