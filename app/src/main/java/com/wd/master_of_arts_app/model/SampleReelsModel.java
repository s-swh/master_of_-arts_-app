package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.SampleReels;
import com.wd.master_of_arts_app.contreater.SampleReelsContreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/10 14:37
 */
public class SampleReelsModel implements SampleReelsContreanter.IModel {
    @Override
    public void SampleRessleSuccess(String token, int course_time_id, SampleRessCoallack coallack) {
        NetUtils.getInstance().getApi().getSamole(token, course_time_id)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Observer<SampleReels>() {
                  @Override
                  public void onSubscribe(Disposable d) {

                  }

                  @Override
                  public void onNext(SampleReels sampleReels) {
                        if(coallack!=null){
                            coallack.OnSampleRessle(sampleReels);
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
