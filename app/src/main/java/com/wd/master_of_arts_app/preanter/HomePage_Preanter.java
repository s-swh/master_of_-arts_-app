package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.Beanner_Bean;
import com.wd.master_of_arts_app.contreater.HomePage_Contract;
import com.wd.master_of_arts_app.model.HomePage_Model;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/3 17:19
 */
public class HomePage_Preanter extends BasePreantert implements HomePage_Contract.IPraenter {

    private HomePage_Model model;

    public HomePage_Preanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        model = new HomePage_Model();
    }

    @Override
    public void BeanSuccess(int cat_id, String field) {
        model.BeanSuccess(cat_id, field, new HomePage_Contract.IModel.OnBeanSuccessCoallack() {
            @Override
            public void OnBeanSuccess(Beanner_Bean beanner_bean) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof HomePage_Contract.IView){
                    HomePage_Contract.IView view= (HomePage_Contract.IView) iBaseView;
                    view.OnBeanSuccess(beanner_bean);
                }
            }
        });
    }
}
