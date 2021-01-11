package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.WatchTheReplay;
import com.wd.master_of_arts_app.contreater.WatchThreContreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/11 12:03
 */
public class WatchThreModel implements WatchThreContreanter.IModel {

    @Override
    public void OnWatSuccess(String meetingId, String recordId, OnWatchThreeCoallack onWatchThreeCoallack) {
        NetUtils.getInstance().getApi().getWatch(meetingId, recordId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WatchTheReplay>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WatchTheReplay watchTheReplay) {
                        if(onWatchThreeCoallack!=null){
                            onWatchThreeCoallack.OnWatchThree(watchTheReplay);
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
