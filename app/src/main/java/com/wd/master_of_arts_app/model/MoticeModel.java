package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.NoticeBean;
import com.wd.master_of_arts_app.contreater.NoticeContreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:
 * @date :2021/1/9 14:09
 */
public class MoticeModel implements NoticeContreanter.IModel {
    @Override
    public void NoticeViewSuccess(String token, NoticeCoallack coallack) {
        NetUtils.getInstance().getApi().getNotice(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NoticeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NoticeBean noticeBean) {
                        if(coallack!=null){
                            coallack.OnNoticeView(noticeBean);
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
