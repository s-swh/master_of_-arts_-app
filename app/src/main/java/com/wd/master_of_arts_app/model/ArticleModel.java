package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.ArticleList;
import com.wd.master_of_arts_app.bean.CommBean;
import com.wd.master_of_arts_app.contreater.ArticleListContreater;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:  文章model
 * @date :2020/12/21 15:11
 */
public class ArticleModel implements ArticleListContreater.IModel {
    //文章列表
    @Override
    public void OnArticleSuccess(String token,ArticleCoallack coallack) {
        NetUtils.getInstance().getApi().getArticle(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArticleList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArticleList articleList) {
                        if(coallack!=null){
                            coallack.OnArticle(articleList);
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
    //文章列表更多
    @Override
    public void OnCommonSuccess(int cat_id, int p, int per, OnCommonCoallack commonCoallack) {
        NetUtils.getInstance().getApi().getCommBean(cat_id, p, per)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CommBean commBean) {
                    if(commonCoallack!=null){
                        commonCoallack.OnCommon(commBean);
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
