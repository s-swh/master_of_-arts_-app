package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.LogIn;
import com.wd.master_of_arts_app.contreater.LoginContract;
import com.wd.master_of_arts_app.model.LogModel;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/12 15:34
 */
public class LoginPreanter extends BasePreantert implements LoginContract.IPreanter {


    private LogModel logModel;

    public LoginPreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        logModel = new LogModel();
    }

    @Override
    public void OnLogin(String account, String pwd) {
        logModel.OnLogin(account, pwd, new LoginContract.IModel.LoginCoallack() {
            @Override
            public void OnSuccess(LogIn logIn) {
                IBaseView iBaseView = getView();
                if (iBaseView instanceof LoginContract.IView) {
                    LoginContract.IView view = (LoginContract.IView) iBaseView;
                    view.OnSuccess(logIn);
                }
            }
        });
    }
}
