package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.Preview;
import com.wd.master_of_arts_app.contreater.PreViewContreater;
import com.wd.master_of_arts_app.model.PreViewModel;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/4 15:33
 */
public class PreViewPreanter extends BasePreantert implements PreViewContreater.IPreanter {

    private PreViewModel preViewModel;

    public PreViewPreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        preViewModel = new PreViewModel();
    }

    @Override
    public void OnPreViewSuccess(String token, int unit_id) {
        preViewModel.OnPreViewSuccess(token, unit_id, new PreViewContreater.IModel.OnPreCoallack() {
            @Override
            public void OnPreView(Preview preview) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof PreViewContreater.IView){
                    PreViewContreater.IView view= (PreViewContreater.IView) iBaseView;
                    view.OnPreView(preview);
                }
            }
        });
    }
}
