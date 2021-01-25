package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.BookingExperience;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/31 9:59
 */
public interface BookingExperienceContreanter {
    interface IView extends IBaseView{
        void OnBooking(BookingExperience bookingExperience);
    }
    interface IPreanter{
        void OnBookingSuccess(String token,String phone,String linkman,int cat_id);
    }
    interface IModel{
        void OnBookingSuccess(String token,String phone,String linkman,int cat_id,BookingCoallack coallack);
        interface BookingCoallack{
            void OnBooking(BookingExperience bookingExperience);
        }
    }
}
