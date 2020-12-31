package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.BookingExperience;
import com.wd.master_of_arts_app.contreater.BookingExperienceContreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/31 10:01
 */
public class BookingModel implements BookingExperienceContreanter.IModel {
    @Override
    public void OnBookingSuccess(String token, String phone, String linkman, int cat_id, BookingCoallack coallack) {
        NetUtils.getInstance().getApi().getBook(token, phone, linkman, cat_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookingExperience>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BookingExperience bookingExperience) {
                        if(coallack!=null){
                            coallack.OnBooking(bookingExperience);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
