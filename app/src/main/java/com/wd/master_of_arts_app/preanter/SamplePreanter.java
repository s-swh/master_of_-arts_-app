package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.SampleReels;
import com.wd.master_of_arts_app.contreater.SampleReelsContreanter;
import com.wd.master_of_arts_app.model.SampleReelsModel;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/10 14:38
 */
public class SamplePreanter extends BasePreantert implements SampleReelsContreanter.IPreanter {

    private SampleReelsModel sampleReelsModel;

    public SamplePreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        sampleReelsModel = new SampleReelsModel();
    }

    @Override
    public void SampleRessleSuccess(String token, int course_time_id) {
        sampleReelsModel.SampleRessleSuccess(token, course_time_id, new SampleReelsContreanter.IModel.SampleRessCoallack() {
            @Override
            public void OnSampleRessle(SampleReels sampleReels) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof SampleReelsContreanter.IView){
                    SampleReelsContreanter.IView view= (SampleReelsContreanter.IView) iBaseView;
                    view.OnSampleRessle(sampleReels);
                }
            }
        });
    }
}
