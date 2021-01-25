package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.Logistics;
import com.wd.master_of_arts_app.payment.ViewLogistics;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/31 9:17
 */
public interface ViewLogisticsConreater {
        interface IView extends IBaseView{
            void OnViewLogistics(Logistics logistics);
        }
        interface IPreanter{
            void OnViewLoginsticsSuccess(String token,String logistics,String express_number);
        }
        interface IModel{
            void OnViewLoginsticsSuccess(String token,String logistics,String express_number,ViewLoginsticsCoallack coallack);
            interface ViewLoginsticsCoallack{
                void OnViewLogistics(Logistics logistics);
            }
        }
}
