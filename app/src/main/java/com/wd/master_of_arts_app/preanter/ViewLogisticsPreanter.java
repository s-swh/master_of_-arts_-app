package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.Logistics;
import com.wd.master_of_arts_app.contreater.ViewLogisticsConreater;
import com.wd.master_of_arts_app.model.ViewLogisticsModel;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/31 9:22
 */
public class ViewLogisticsPreanter extends BasePreantert implements ViewLogisticsConreater.IPreanter {

    private ViewLogisticsModel viewLogisticsModel;

    public ViewLogisticsPreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        viewLogisticsModel = new ViewLogisticsModel();
    }

    @Override
    public void OnViewLoginsticsSuccess(String token, String logistics, String express_number) {
        viewLogisticsModel.OnViewLoginsticsSuccess(token, logistics, express_number, new ViewLogisticsConreater.IModel.ViewLoginsticsCoallack() {
            @Override
            public void OnViewLogistics(Logistics logistics) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof ViewLogisticsConreater.IView){
                    ViewLogisticsConreater.IView view= (ViewLogisticsConreater.IView) iBaseView;
                    view.OnViewLogistics(logistics);
                }
            }
        });
    }
}
