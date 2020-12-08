package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.Beanner_Bean;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/3 17:10
 */
public interface HomePage_Contract {
    interface IView extends IBaseView{
        void OnBeanSuccess(Beanner_Bean beanner_bean);
    }

    interface IPraenter{
        void BeanSuccess(int cat_id,String field);

    }
    interface IModel{
        void BeanSuccess(int cat_id,String field,OnBeanSuccessCoallack onBeanSuccessCoallack);
        interface OnBeanSuccessCoallack{
            void OnBeanSuccess(Beanner_Bean beanner_bean);
        }
    }
}
