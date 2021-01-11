package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.WatchTheReplay;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/11 12:01
 */
public interface WatchThreContreanter {
    interface IView extends IBaseView{
        void OnWatchThree(WatchTheReplay watchTheReplay);
    }
    interface IPreanter{
        void OnWatSuccess(String meetingId,String recordId);
    }
    interface IModel{
        void OnWatSuccess(String meetingId,String recordId,OnWatchThreeCoallack onWatchThreeCoallack);
        interface OnWatchThreeCoallack{
            void OnWatchThree(WatchTheReplay watchTheReplay);
        }
    }
}
