package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.LiveBoradCast;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/5 13:51
 */
public interface LiveBoradcastContreanter {
    interface IView extends IBaseView{
        void OnLiveBorad(LiveBoradCast liveBoradCast);

    }
    interface IPreanter{
        void OnLiveBoradSuccess(String userType,String meetingType,String mediaType,String meetingId,String userName,String loginName,String topic);
    }
    interface IModel{
        void OnLiveBoradSuccess(String userType,String meetingType,String mediaType,String meetingId,String userName,String loginName,String topic,OnLiveBoradCoallack coallack);
        interface OnLiveBoradCoallack{
            void OnLiveBorad(LiveBoradCast liveBoradCast);
        }
    }
}
