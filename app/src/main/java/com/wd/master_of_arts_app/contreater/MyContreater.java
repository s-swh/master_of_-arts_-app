package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.SignOut;

/**
 * @author 时文豪
 * @description:  我的资料契约类
 * @date :2020/12/19 11:05
 */
public interface MyContreater {
    interface IView extends IBaseView{
        void OnSignOut(SignOut signOut);
    }
    interface IPreanter{
        void SignOutSuccess(String token);
    }
    interface IModel{
        void SignOutSuccess(String token,SignOutCoallack signOutCoallack);
        interface SignOutCoallack{
            void OnSignOut(SignOut signOut);
        }
    }
}
