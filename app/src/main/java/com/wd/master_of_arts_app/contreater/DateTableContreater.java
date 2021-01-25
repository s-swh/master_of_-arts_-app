package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.CourseChecking;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.MyClassDate;

/**
 * @author 时文豪
 * @description:  日历
 * @date :2021/1/3 9:37
 */
public interface DateTableContreater {

    interface IView extends IBaseView{
        void DateTable(MyClassDate myClassDate);
        //根据日历查课
        void CourseChecking(CourseChecking courseChecking);
    }
    interface IPreanter{
        void DateSuccess(String token);
        //根据日历查课
        void OnCourseCheckingSuccess(String token,String date);
    }
    interface IModel{
        void DateSuccess(String token,DateTableCoallack coallack);
        interface DateTableCoallack{
            void DateTable(MyClassDate myClassDate);
        }
        //根据日历查课
        void OnCourseCheckingSuccess(String token,String date,CourseCheckingCoallack courseCheckingCoallack);
        interface CourseCheckingCoallack{
            void CourseChecking(CourseChecking courseChecking);
        }
    }
}
