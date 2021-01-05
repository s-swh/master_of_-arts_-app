package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.LiveBoradCast;
import com.wd.master_of_arts_app.contreater.LiveBoradcastContreanter;
import com.wd.master_of_arts_app.model.LiveBoradCastModel;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/5 13:55
 */
public class LiveBoraCastPreanter extends BasePreantert implements LiveBoradcastContreanter.IPreanter {

    private LiveBoradCastModel liveBoradCastModel;

    public LiveBoraCastPreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        liveBoradCastModel = new LiveBoradCastModel();
    }

    @Override
    public void OnLiveBoradSuccess(String userType, String meetingType, String mediaType, String meetingId, String userName, String loginName, String topic) {
        liveBoradCastModel.OnLiveBoradSuccess(userType, meetingType, mediaType, meetingId, userName, loginName, topic, new LiveBoradcastContreanter.IModel.OnLiveBoradCoallack() {
            @Override
            public void OnLiveBorad(LiveBoradCast liveBoradCast) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof LiveBoradcastContreanter.IView){
                    LiveBoradcastContreanter.IView view= (LiveBoradcastContreanter.IView) iBaseView;
                    view.OnLiveBorad(liveBoradCast);
                }
            }
        });
    }
}
