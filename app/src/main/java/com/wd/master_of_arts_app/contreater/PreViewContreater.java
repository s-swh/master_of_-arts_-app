package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.Preview;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/4 15:30
 */
public interface PreViewContreater {
    interface IView extends IBaseView{
        void OnPreView(Preview preview);
    }
    interface IPreanter{
        void OnPreViewSuccess(String token,int unit_id);
    }
    interface IModel{
        void OnPreViewSuccess(String token,int unit_id,OnPreCoallack coallack);
        interface OnPreCoallack{
            void OnPreView(Preview preview);
        }
    }
}
