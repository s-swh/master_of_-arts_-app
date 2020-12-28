package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.CancellationOfOrder;
import com.wd.master_of_arts_app.bean.OrderList;
import com.wd.master_of_arts_app.bean.Purchase;

/**
 * @author 时文豪
 * @description: 订单契约
 * @date :2020/12/26 16:31
 */
public interface OrderContreater {
    interface IView extends IBaseView{
        //创建订单
        void OnPurchase(Purchase purchase);
        //订单列表
        void OnOrderList(OrderList orderList);
        //取消订单
        void OnCancel(CancellationOfOrder cancellationOfOrder);
    }
    interface IPreanter{
        //创建订单
        void OnPruchaseSuccess(String token,int course_id,int course_time_id,int address_id);
        //订单列表
        void OrderSuccess(String token,int p,int per);
        //取消订单
        void OnCancelSuccess(String token,String order_id);
    }
    interface IModel{
        //创建订单
        void OnPruchaseSuccess(String token,int course_id,int course_time_id,int address_id,OnPruchaseCoallack coallack);
        interface OnPruchaseCoallack{
            void OnPurchase(Purchase purchase);
        }
        //订单列表
        void OrderSuccess(String token,int p,int per,OnOrderCoallack coallack);
        interface OnOrderCoallack{
            void OnOrderList(OrderList orderList);
        }
        //取消订单
        void OnCancelSuccess(String token,String order_id,OnCancelCoallack cancelCoallack);
        interface OnCancelCoallack{
            void OnCancel(CancellationOfOrder cancellationOfOrder);
        }
    }
}
