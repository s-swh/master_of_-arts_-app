package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.Privacy_policyBean;
import com.wd.master_of_arts_app.bean.User_agreement;

/**
 * @author 时文豪
 * @description: 我的模块
 * @date :2020/12/5 15:27
 */
public interface My_Contract {
    interface IView extends IBaseView{
        //TODO  用户协议
        void OnUser_agreement(User_agreement user_agreement);
        //TODO 隐私政策
        void Privacy_policy(Privacy_policyBean privacyPolicyBean);
    }
    interface IPranter{
        //TODO  用户协议
        void OnUser_success(int article_id);
        //TODO 隐私政策
        void OnPolicySuccess(int article_id);
    }
    interface IModel{
        //TODO  用户协议
        void OnUser_success(int article_id,OnUserCoallack onUserCoallack);
        interface OnUserCoallack{
            void OnUser_agreement(User_agreement user_agreement);
        }
        //TODO 隐私政策
        void OnPolicySuccess(int article_id,OnPolicyCoallack onPolicyCoallack);
        interface OnPolicyCoallack{
            void Privacy_policy(Privacy_policyBean privacyPolicyBean);
        }
    }
}
