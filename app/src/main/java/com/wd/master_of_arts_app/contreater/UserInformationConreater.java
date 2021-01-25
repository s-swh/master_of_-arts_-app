package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.EditUserInformation;
import com.wd.master_of_arts_app.bean.UserInformation;

/**
 * @author 时文豪
 * @description:  用户详情契约类
 * @date :2020/12/19 16:13
 */
public interface UserInformationConreater {
    interface IView extends IBaseView{
        //用户详情
        void OnUserInfor(UserInformation userInformation);
        //编辑用户详情
        void OnEditUser(EditUserInformation editUserInformation);
    }
    interface IPreanter{
        //用户详情
        void OnUserSuccess(String token);
        //编辑用户详情
        void EditUserSuccess(String token,String nickname,int sex,String birthday,String province,String city,String county);
    }
    interface IModel{
        //用户详情
        void OnUserSuccess(String token,OnSuccessCoallack onSuccessCoallack);
        interface OnSuccessCoallack{
            void OnUserInfor(UserInformation userInformation);
        }
        //编辑用户详情
        void EditUserSuccess(String token,String nickname,int sex,String birthday,String province,String city,String county,EditUserCoallack editUserCoallack);
        interface EditUserCoallack{
            void OnEditUser(EditUserInformation editUserInformation);
        }
    }
}
