package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.Purchase;

/**
 * @author 时文豪
 * @description: 订单契约
 * @date :2020/12/26 16:31
 */
public interface OrderContreater {
    interface IView extends IBaseView{
        void OnPurchase(Purchase purchase);
    }
    interface IPreanter{
        void OnPruchaseSuccess(String token,int course_id,int course_time_id);
    }
    interface IModel{
        void OnPruchaseSuccess(String token,int course_id,int course_time_id,OnPruchaseCoallack coallack);
        interface OnPruchaseCoallack{
            void OnPurchase(Purchase purchase);
        }
    }
}
