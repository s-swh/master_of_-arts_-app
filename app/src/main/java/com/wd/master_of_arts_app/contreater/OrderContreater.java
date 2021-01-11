package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.CancellationOfOrder;
import com.wd.master_of_arts_app.bean.CommentOrder;
import com.wd.master_of_arts_app.bean.CourseOrderBean;
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
        //订单详情
        void OnOrderdetails(CourseOrderBean orderBean);
        //订单评论
        void OnComment(CommentOrder commentOrder);
    }
    interface IPreanter{
        //创建订单
        void OnPruchaseSuccess(String token,int course_id,int course_time_id,int address_id,int pay_method);
        //订单列表
        void OrderSuccess(String token,String status,int p,int per);
        //取消订单
        void OnCancelSuccess(String token,String order_id);
        //订单详情
        void OnOrderdetailsSuccess(String token,int order_id);
        //订单评论
        void OnCommentSuccess(String token,int order_id,int score,String content);
    }
    interface IModel{
        //创建订单
        void OnPruchaseSuccess(String token,int course_id,int course_time_id,int address_id,int pay_method,OnPruchaseCoallack coallack);
        interface OnPruchaseCoallack{
            void OnPurchase(Purchase purchase);
        }
        //订单列表
        void OrderSuccess(String token,String status,int p,int per,OnOrderCoallack coallack);
        interface OnOrderCoallack{
            void OnOrderList(OrderList orderList);
        }
        //取消订单
        void OnCancelSuccess(String token,String order_id,OnCancelCoallack cancelCoallack);
        interface OnCancelCoallack{
            void OnCancel(CancellationOfOrder cancellationOfOrder);
        }
        //订单详情
        void OnOrderdetailsSuccess(String token,int order_id,OnOrderdetilsCoallack coallack);
        interface OnOrderdetilsCoallack{

            void OnOrderdetails(CourseOrderBean orderBean);
        }
        //订单评论
        void OnCommentSuccess(String token,int order_id,int score,String content,OnCommentCoallack commentCoallack);
        interface OnCommentCoallack{
            void OnComment(CommentOrder commentOrder);
        }
    }
}
