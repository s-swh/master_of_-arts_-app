package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.CancellationOfOrder;
import com.wd.master_of_arts_app.bean.CommentOrder;
import com.wd.master_of_arts_app.bean.CourseOrderBean;
import com.wd.master_of_arts_app.bean.OrderList;
import com.wd.master_of_arts_app.bean.Purchase;
import com.wd.master_of_arts_app.contreater.OrderContreater;
import com.wd.master_of_arts_app.model.OrderModel;
import com.wd.master_of_arts_app.utils.NetUtils;

/**
 * @author 时文豪
 * @description:  订单 Preanter
 * @date :2020/12/26 16:34
 */
public class OrderPreanter extends BasePreantert implements OrderContreater.IPreanter {

    private OrderModel orderModel;

    public OrderPreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        orderModel = new OrderModel();
    }
    //创建订单
    @Override
    public void OnPruchaseSuccess(String token, int course_id, int course_time_id,int address_id,int pay_method) {
        orderModel.OnPruchaseSuccess(token, course_id, course_time_id,address_id,pay_method, new OrderContreater.IModel.OnPruchaseCoallack() {
            @Override
            public void OnPurchase(Purchase purchase) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof OrderContreater.IView){
                    OrderContreater.IView view= (OrderContreater.IView) iBaseView;
                    view.OnPurchase(purchase);
                }
            }
        });
    }



    @Override
    public void OrderSuccess(String token,String status,int p,int per) {
        orderModel.OrderSuccess(token,status,p,per, new OrderContreater.IModel.OnOrderCoallack() {
            @Override
            public void OnOrderList(OrderList orderList) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof OrderContreater.IView){
                    OrderContreater.IView view= (OrderContreater.IView) iBaseView;
                    view.OnOrderList(orderList);
                }
            }
        });
    }
    //取消订单
    @Override
    public void OnCancelSuccess(String token, String order_id) {
        orderModel.OnCancelSuccess(token, order_id, new OrderContreater.IModel.OnCancelCoallack() {
            @Override
            public void OnCancel(CancellationOfOrder cancellationOfOrder) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof OrderContreater.IView){
                    OrderContreater.IView view= (OrderContreater.IView) iBaseView;
                    view.OnCancel(cancellationOfOrder);
                }
            }
        });
    }

    @Override
    public void OnOrderdetailsSuccess(String token, int order_id) {
        orderModel.OnOrderdetailsSuccess(token, order_id, new OrderContreater.IModel.OnOrderdetilsCoallack() {
            @Override
            public void OnOrderdetails(CourseOrderBean orderBean) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof OrderContreater.IView){
                    OrderContreater.IView view= (OrderContreater.IView) iBaseView;
                    view.OnOrderdetails(orderBean);
                }
            }
        });
    }
    //订单评论
    @Override
    public void OnCommentSuccess(String token, int order_id, int score, String content) {
        orderModel.OnCommentSuccess(token, order_id, score, content, new OrderContreater.IModel.OnCommentCoallack() {
            @Override
            public void OnComment(CommentOrder commentOrder) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof OrderContreater.IView){
                    OrderContreater.IView view= (OrderContreater.IView) iBaseView;
                    view.OnComment(commentOrder);
                }
            }
        });
    }
}
