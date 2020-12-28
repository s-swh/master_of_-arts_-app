package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.MyCurse;
import com.wd.master_of_arts_app.contreater.MyCourseContreater;
import com.wd.master_of_arts_app.model.MyCourseModel;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/28 11:19
 */
public class MyCoursePreanter extends BasePreantert implements MyCourseContreater.IPreanter {

    private MyCourseModel myCourseModel;

    public MyCoursePreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        myCourseModel = new MyCourseModel();
    }

    @Override
    public void OnMyCourseSuccess(String token, int p, int per) {
        myCourseModel.OnMyCourseSuccess(token, p, per, new MyCourseContreater.IModel.MyCourseCoallack() {
            @Override
            public void OnCourse(MyCurse myCurse) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof MyCourseContreater.IView){
                    MyCourseContreater.IView view= (MyCourseContreater.IView) iBaseView;
                    view.OnCourse(myCurse);
                }
            }
        });
    }
}
