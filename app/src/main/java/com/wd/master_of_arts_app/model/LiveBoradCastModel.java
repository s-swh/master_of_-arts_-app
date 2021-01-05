package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.LiveBoradCast;
import com.wd.master_of_arts_app.contreater.LiveBoradcastContreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/5 13:53
 */
public class LiveBoradCastModel implements LiveBoradcastContreanter.IModel {
    @Override
    public void OnLiveBoradSuccess(String userType, String meetingType, String mediaType, String meetingId, String userName, String loginName, String topic, OnLiveBoradCoallack coallack) {
        NetUtils.getInstance().getApi().getLiveBorad(userType, meetingType, mediaType, meetingId, userName, loginName, topic)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LiveBoradCast>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LiveBoradCast liveBoradCast) {
                            if(coallack!=null){
                                coallack.OnLiveBorad(liveBoradCast);
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
