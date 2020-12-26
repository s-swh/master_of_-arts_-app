package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.Purchase;
import com.wd.master_of_arts_app.contreater.OrderContreater;
import com.wd.master_of_arts_app.model.OrderModel;

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

    @Override
    public void OnPruchaseSuccess(String token, int course_id, int course_time_id) {
        orderModel.OnPruchaseSuccess(token, course_id, course_time_id, new OrderContreater.IModel.OnPruchaseCoallack() {
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
}
