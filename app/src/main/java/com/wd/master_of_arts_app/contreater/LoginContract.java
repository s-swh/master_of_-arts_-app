package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.LogIn;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/12 15:30
 */
public interface LoginContract {
    interface IView extends IBaseView {
        void OnSuccess(LogIn logIn);
    }

    interface IPreanter {
        void OnLogin(String account, String pwd);
    }

    interface IModel {
        void OnLogin(String account, String pwd, LoginCoallack loginCoallack);

        interface LoginCoallack {
            void OnSuccess(LogIn logIn);
        }
    }
}
