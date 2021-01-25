package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.BookingExperience;
import com.wd.master_of_arts_app.contreater.BookingExperienceContreanter;
import com.wd.master_of_arts_app.model.BookingModel;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/31 10:04
 */
public class BookingPreanter extends BasePreantert implements BookingExperienceContreanter.IPreanter {

    private BookingModel bookingModel;

    public BookingPreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        bookingModel = new BookingModel();
    }

    @Override
    public void OnBookingSuccess(String token, String phone, String linkman, int cat_id) {
        bookingModel.OnBookingSuccess(token, phone, linkman, cat_id, new BookingExperienceContreanter.IModel.BookingCoallack() {
            @Override
            public void OnBooking(BookingExperience bookingExperience) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof BookingExperienceContreanter.IView){
                    BookingExperienceContreanter.IView view= (BookingExperienceContreanter.IView) iBaseView;
                    view.OnBooking(bookingExperience);
                }
            }
        });
    }
}
