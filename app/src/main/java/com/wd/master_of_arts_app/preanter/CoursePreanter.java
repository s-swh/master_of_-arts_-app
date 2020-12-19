package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.AgeInterface;
import com.wd.master_of_arts_app.bean.CourseList;
import com.wd.master_of_arts_app.contreater.CourseContreater;
import com.wd.master_of_arts_app.model.CourseModel;

/**
 * @author 时文豪
 * @description: 课程P层
 * @date :2020/12/18 15:32
 */
public class CoursePreanter extends BasePreantert implements CourseContreater.IPreanter {

    private CourseModel courseModel;

    public CoursePreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        courseModel = new CourseModel();
    }

    //课程
    @Override
    public void OnCourseSuccess(String cat_id, String is_top, String age, int p, int per) {
       courseModel.OnCourseSuccess(cat_id, is_top, age, p, per, new CourseContreater.IModel.CourseCollack() {
           @Override
           public void OnCourse(CourseList courseList) {
               IBaseView iBaseView = getView();
               if(iBaseView instanceof CourseContreater.IView){
                   CourseContreater.IView view= (CourseContreater.IView) iBaseView;
                   view.OnCourse(courseList);
               }
           }
       });
    }
//年龄段
    @Override
    public void OnAgeSuccess() {
        courseModel.OnAgeSuccess(new CourseContreater.IModel.AgeCoallack() {
            @Override
            public void onAgeInterface(AgeInterface ageInterface) {
                IBaseView view = getView();
                if(view instanceof CourseContreater.IView){
                    CourseContreater.IView view1= (CourseContreater.IView) view;
                    view1.onAgeInterface(ageInterface);
                }
            }
        });
    }
}
