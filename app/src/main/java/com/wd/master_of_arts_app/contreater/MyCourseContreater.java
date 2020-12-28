package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.MyCurse;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/28 11:15
 */
public interface MyCourseContreater {
    interface IView extends IBaseView{
        void OnCourse(MyCurse myCurse);
    }
    interface IPreanter{
        void OnMyCourseSuccess(String token,int p,int per);
    }
    interface IModel{
        void OnMyCourseSuccess(String token,int p,int per,MyCourseCoallack courseCoallack);
        interface MyCourseCoallack{
            void OnCourse(MyCurse myCurse);
        }
    }
}
