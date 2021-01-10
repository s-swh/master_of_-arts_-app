package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.SampleReels;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/10 14:35
 */
public interface SampleReelsContreanter {
    interface IView extends IBaseView{
        void OnSampleRessle(SampleReels sampleReels);
    }
    interface IPreanter{
        void SampleRessleSuccess(String token,int course_time_id);
    }
    interface IModel{
        void SampleRessleSuccess(String token,int course_time_id,SampleRessCoallack coallack);
        interface SampleRessCoallack{
            void OnSampleRessle(SampleReels sampleReels);
        }
    }
}
