package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.WatchTheReplay;
import com.wd.master_of_arts_app.contreater.WatchThreContreanter;
import com.wd.master_of_arts_app.model.WatchThreModel;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/11 12:05
 */
public class WatchThrePreanter extends BasePreantert implements WatchThreContreanter.IPreanter {

    private WatchThreModel watchThreModel;

    public WatchThrePreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        watchThreModel = new WatchThreModel();
    }

    @Override
    public void OnWatSuccess(String meetingId, String recordId) {
        watchThreModel.OnWatSuccess(meetingId, recordId, new WatchThreContreanter.IModel.OnWatchThreeCoallack() {
            @Override
            public void OnWatchThree(WatchTheReplay watchTheReplay) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof WatchThreContreanter.IView){
                    WatchThreContreanter.IView view= (WatchThreContreanter.IView) iBaseView;
                    view.OnWatchThree(watchTheReplay);
                }
            }
        });
    }
}
