package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.AgeInterface;
import com.wd.master_of_arts_app.bean.CourseDetails;
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
        //课程详情
        void OnCourse(CourseDetails courseDetails);
    }
    interface IPreanter{
        // 课程
        void OnCourseSuccess(String cat_id,String is_top,String course_name,String age,int p,int per);
        //年龄段
        void OnAgeSuccess();
        //课程详情
        void OnCourseOnSuccess(int course_time_id);
    }
    interface IModel{
        // 课程
        void OnCourseSuccess(String cat_id,String is_top,String course_name,String age,int p,int per,CourseCollack courseCollack);
        interface CourseCollack{
            void OnCourse(CourseList courseList);
        }
        //年龄段
        void OnAgeSuccess(AgeCoallack ageCoallack);
        interface AgeCoallack{
            void onAgeInterface(AgeInterface ageInterface);
        }
        //课程详情
        void OnCourseOnSuccess(int course_time_id,CourseCoallack courseCoallack);
        interface CourseCoallack{
            void OnCourse(CourseDetails courseDetails);
        }
    }
}
