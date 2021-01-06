package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.HomeWorkBean;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/6 11:17
 */
public interface MyWorkContreanter {
    interface IView extends IBaseView{
        void OnMyWork(HomeWorkBean workBean);
    }
    interface IPreanter{
        void OnWorkSuccess(int work_id);
    }
    interface IModel{
        void OnWorkSuccess(int work_id,WorkCoallack coallack);
        interface WorkCoallack{
            void OnMyWork(HomeWorkBean workBean);
        }
    }
}
