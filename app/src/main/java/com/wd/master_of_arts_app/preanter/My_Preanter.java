package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.Privacy_policyBean;
import com.wd.master_of_arts_app.bean.User_agreement;
import com.wd.master_of_arts_app.contreater.My_Contract;
import com.wd.master_of_arts_app.model.My_Model;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/5 15:30
 */
public class My_Preanter extends BasePreantert implements My_Contract.IPranter {

    private My_Model my_model;

    public My_Preanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        my_model = new My_Model();
    }

    @Override
    public void OnUser_success(int article_id) {
        my_model.OnUser_success(article_id, new My_Contract.IModel.OnUserCoallack() {
            @Override
            public void OnUser_agreement(User_agreement user_agreement) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof My_Contract.IView){
                    My_Contract.IView iView= (My_Contract.IView) iBaseView;
                    iView.OnUser_agreement(user_agreement);
                }
            }
        });
    }

    @Override
    public void OnPolicySuccess(int article_id) {
        my_model.OnPolicySuccess(article_id, new My_Contract.IModel.OnPolicyCoallack() {
            @Override
            public void Privacy_policy(Privacy_policyBean privacyPolicyBean) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof My_Contract.IView){
                    My_Contract.IView view= (My_Contract.IView) iBaseView;
                    view.Privacy_policy(privacyPolicyBean);
                }
            }
        });
    }
}
