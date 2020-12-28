package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.DetailsOfWorksBean;
import com.wd.master_of_arts_app.bean.ListOfWorks;
import com.wd.master_of_arts_app.contreater.worksContreanter;
import com.wd.master_of_arts_app.model.WorksModel;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/25 13:49
 */
public class WorksPreanter extends BasePreantert implements worksContreanter.IPreanter {

    private WorksModel worksModel;

    public WorksPreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        worksModel = new WorksModel();
    }

    @Override
    public void OnWorksSuccess(String token, String is_comment, int p, int per) {
        worksModel.OnWorksSuccess(token, is_comment, p, per, new worksContreanter.IModel.OnWorksCoallack() {
            @Override
            public void OnWorks(ListOfWorks listOfWorks) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof worksContreanter.IVew){
                    worksContreanter.IVew iVew= (worksContreanter.IVew) iBaseView;
                    iVew.OnWorks(listOfWorks);
                }
            }
        });
    }

    @Override
    public void OnDetailsSuccess(int work_id) {
        worksModel.OnDetailsSuccess(work_id, new worksContreanter.IModel.OnWoksCoallack() {
            @Override
            public void OnDetailsWorks(DetailsOfWorksBean worksBean) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof worksContreanter.IVew){
                    worksContreanter.IVew vew= (worksContreanter.IVew) iBaseView;
                    vew.OnDetailsWorks(worksBean);
                }
            }
        });
    }
}
