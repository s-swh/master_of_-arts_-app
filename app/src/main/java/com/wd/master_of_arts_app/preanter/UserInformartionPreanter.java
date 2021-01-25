package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.EditUserInformation;
import com.wd.master_of_arts_app.bean.UserInformation;
import com.wd.master_of_arts_app.contreater.UserInformationConreater;
import com.wd.master_of_arts_app.model.UserInformartionModel;

/**
 * @author 时文豪
 * @description:  用户详情Preanter
 * @date :2020/12/19 16:15
 */
public class UserInformartionPreanter extends BasePreantert implements UserInformationConreater.IPreanter {

    private UserInformartionModel userInformartionModel;

    public UserInformartionPreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        userInformartionModel = new UserInformartionModel();
    }
//详情信息
    @Override
    public void OnUserSuccess(String token) {
        userInformartionModel.OnUserSuccess(token, new UserInformationConreater.IModel.OnSuccessCoallack() {
            @Override
            public void OnUserInfor(UserInformation userInformation) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof UserInformationConreater.IView){
                    UserInformationConreater.IView view= (UserInformationConreater.IView) iBaseView;
                    view.OnUserInfor(userInformation);
                }
            }
        });
    }
        //编辑详情信息
    @Override
    public void EditUserSuccess(String token, String nickname, int sex, String birthday, String province, String city, String county) {
        userInformartionModel.EditUserSuccess(token, nickname, sex, birthday, province, city, county, new UserInformationConreater.IModel.EditUserCoallack() {
            @Override
            public void OnEditUser(EditUserInformation editUserInformation) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof UserInformationConreater.IView){
                    UserInformationConreater.IView view= (UserInformationConreater.IView) iBaseView;
                    view.OnEditUser(editUserInformation);
                }
            }
        });
    }
}
