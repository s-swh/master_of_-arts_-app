package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.CourseChecking;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.MyClassDate;
import com.wd.master_of_arts_app.contreater.DateTableContreater;
import com.wd.master_of_arts_app.model.DateModel;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/3 9:39
 */
public class DateLablePreanter extends BasePreantert implements DateTableContreater.IPreanter {

    private DateModel dateModel;

    public DateLablePreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        dateModel = new DateModel();
    }

    @Override
    public void DateSuccess(String token) {
        dateModel.DateSuccess(token, new DateTableContreater.IModel.DateTableCoallack() {
            @Override
            public void DateTable(MyClassDate myClassDate) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof DateTableContreater.IView){
                    DateTableContreater.IView view= (DateTableContreater.IView) iBaseView;
                    view.DateTable(myClassDate);
                }
            }
        });
    }

    @Override
    public void OnCourseCheckingSuccess(String token, String date) {
        dateModel.OnCourseCheckingSuccess(token, date, new DateTableContreater.IModel.CourseCheckingCoallack() {
            @Override
            public void CourseChecking(CourseChecking courseChecking) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof DateTableContreater.IView){
                    DateTableContreater.IView view= (DateTableContreater.IView) iBaseView;
                    view.CourseChecking(courseChecking);
                }
            }
        });
    }
}
