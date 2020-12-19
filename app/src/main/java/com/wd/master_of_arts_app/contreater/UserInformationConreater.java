package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.UserInformation;

/**
 * @author 时文豪
 * @description:  用户详情契约类
 * @date :2020/12/19 16:13
 */
public interface UserInformationConreater {
    interface IView extends IBaseView{
        void OnUserInfor(UserInformation userInformation);
    }
    interface IPreanter{
        void OnUserSuccess(String token);
    }
    interface IModel{
        void OnUserSuccess(String token,OnSuccessCoallack onSuccessCoallack);
        interface OnSuccessCoallack{
            void OnUserInfor(UserInformation userInformation);
        }
    }
}
