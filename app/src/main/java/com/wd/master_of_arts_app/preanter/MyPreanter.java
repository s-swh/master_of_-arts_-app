package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.SignOut;
import com.wd.master_of_arts_app.contreater.MyContreater;
import com.wd.master_of_arts_app.model.MyModel;

/**
 * @author 时文豪
 * @description: 我的资料Preanter
 * @date :2020/12/19 11:08
 */
public class MyPreanter extends BasePreantert implements MyContreater.IPreanter {

    private MyModel myModel;

    public MyPreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        myModel = new MyModel();
    }

    @Override
    public void SignOutSuccess(String token) {
        myModel.SignOutSuccess(token, new MyContreater.IModel.SignOutCoallack() {
            @Override
            public void OnSignOut(SignOut signOut) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof MyContreater.IView){
                    MyContreater.IView view= (MyContreater.IView) iBaseView;
                    view.OnSignOut(signOut);
                }
            }
        });
    }
}
