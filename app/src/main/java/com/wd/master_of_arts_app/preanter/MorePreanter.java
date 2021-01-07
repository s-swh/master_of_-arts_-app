package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.MoreComm;
import com.wd.master_of_arts_app.contreater.MoreContreanter;
import com.wd.master_of_arts_app.model.MoreModel;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/7 8:59
 */
public class MorePreanter extends BasePreantert implements MoreContreanter.IPreanter {

    private MoreModel moreModel;

    public MorePreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        moreModel = new MoreModel();
    }

    @Override
    public void OnMoreSuccess(int course_id, int p, int per) {
        moreModel.OnMoreSuccess(course_id, p, per, new MoreContreanter.IModel.MoreCoallack() {
            @Override
            public void OnMore(MoreComm moreComm) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof MoreContreanter.IView){
                    MoreContreanter.IView view= (MoreContreanter.IView) iBaseView;
                    view.OnMore(moreComm);
                }
            }
        });
    }
}
