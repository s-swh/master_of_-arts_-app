package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.HomeWorkBean;
import com.wd.master_of_arts_app.contreater.MyWorkContreanter;
import com.wd.master_of_arts_app.model.MyWorkModel;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/6 11:20
 */
public class MyWorkPreanter extends BasePreantert implements MyWorkContreanter.IPreanter {

    private MyWorkModel myWorkModel;

    public MyWorkPreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        myWorkModel = new MyWorkModel();
    }

    @Override
    public void OnWorkSuccess(int work_id) {
    myWorkModel.OnWorkSuccess(work_id, new MyWorkContreanter.IModel.WorkCoallack() {
        @Override
        public void OnMyWork(HomeWorkBean workBean) {
            IBaseView iBaseView = getView();
            if(iBaseView instanceof MyWorkContreanter.IView){
                MyWorkContreanter.IView view= (MyWorkContreanter.IView) iBaseView;
                view.OnMyWork(workBean);
            }
        }
    });
    }

}
