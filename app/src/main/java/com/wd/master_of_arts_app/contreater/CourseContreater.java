package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.AgeInterface;
import com.wd.master_of_arts_app.bean.CourseList;

/**
 * @author 时文豪
 * @description: 课程契约类
 * @date :2020/12/18 15:30
 */
public interface CourseContreater {
    interface IView extends IBaseView{
        // 课程
        void OnCourse(CourseList courseList);
        //年龄段
        void onAgeInterface(AgeInterface ageInterface);
    }
    interface IPreanter{
        // 课程
        void OnCourseSuccess(String cat_id,String is_top,String age,int p,int per);
        //年龄段
        void OnAgeSuccess();
    }
    interface IModel{
        // 课程
        void OnCourseSuccess(String cat_id,String is_top,String age,int p,int per,CourseCollack courseCollack);
        interface CourseCollack{
            void OnCourse(CourseList courseList);
        }
        //年龄段
        void OnAgeSuccess(AgeCoallack ageCoallack);
        interface AgeCoallack{
            void onAgeInterface(AgeInterface ageInterface);
        }
    }
}
