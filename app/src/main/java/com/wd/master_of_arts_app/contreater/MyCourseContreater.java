package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.MyCourseDetailsBean;
import com.wd.master_of_arts_app.bean.MyCurse;

/**
 * @author 时文豪
 * @description: 我的课程
 * @date :2020/12/28 11:15
 */
public interface MyCourseContreater {
    interface IView extends IBaseView{
        void OnCourse(MyCurse myCurse);
        //我的课程详情
        void OnCourseDatails(MyCourseDetailsBean myCourseDetailsBean);
    }
    interface IPreanter{
        void OnMyCourseSuccess(String token,int p,int per);
        //我的课程详情
        void OnCourseDatailsSuccess(String token,int order_id,int course_time_id);
    }
    interface IModel{
        void OnMyCourseSuccess(String token,int p,int per,MyCourseCoallack courseCoallack);
        interface MyCourseCoallack{
            void OnCourse(MyCurse myCurse);
        }
        //我的课程详情
        void OnCourseDatailsSuccess(String token,int order_id,int course_time_id,MyCourseDatilsCoallack myCourseDatilsCoallack);
        interface MyCourseDatilsCoallack{
            void OnCourseDatails(MyCourseDetailsBean myCourseDetailsBean);
        }
    }
}
