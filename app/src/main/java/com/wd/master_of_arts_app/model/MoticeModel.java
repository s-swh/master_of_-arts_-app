package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.NoticeBean;
import com.wd.master_of_arts_app.bean.NoticeDetailsBean;
import com.wd.master_of_arts_app.bean.NoticeNumBer;
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

    @Override
    public void OnNoticeSuccess(String token, int notice_id, NoticeBeanCoallack coallack) {
        NetUtils.getInstance().getApi().getNoticeBean(token, notice_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NoticeDetailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NoticeDetailsBean noticeDetailsBean) {
                    if(coallack!=null){
                        coallack.OnNoticeBean(noticeDetailsBean);
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

    @Override
    public void OnNoticeNumberSuccess(String token, NoTiceNumberCoallack coallack) {
        NetUtils.getInstance().getApi().getNoticeNumber(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NoticeNumBer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NoticeNumBer noticeNumBer) {
                    if(coallack!=null){
                        coallack.OnNoticeNumber(noticeNumBer);
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
