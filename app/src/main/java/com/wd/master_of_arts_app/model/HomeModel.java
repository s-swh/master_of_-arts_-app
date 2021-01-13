package com.wd.master_of_arts_app.model;

import android.util.Log;

import com.wd.master_of_arts_app.bean.BannerPage;
import com.wd.master_of_arts_app.bean.Beanner;
import com.wd.master_of_arts_app.bean.HomePage;
import com.wd.master_of_arts_app.contreater.HomePagerCrete;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description: 主页model
 * @date :2020/12/17 16:52
 */
public class HomeModel implements HomePagerCrete.IModel {
    @Override
    public void OnBeanner(int cat_id, BeannerCoallack coallack) {
        NetUtils.getInstance().getApi().getBeanner(cat_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Beanner>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Beanner beanner) {
                        if(coallack!=null){
                            coallack.BannerSuccess(beanner);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        String message = e.getMessage();
                        Log.e("Homexxx",message);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void OnHomepage(String token,OnHomePagerCoallack homePagerCoallack) {
        NetUtils.getInstance().getApi().getHomePage(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomePage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomePage homePage) {
                        if(homePagerCoallack!=null){
                            homePagerCoallack.HomePage(homePage);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        String message = e.getMessage();
                        Log.i("Homexxx",message);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void OnBannerSuccess(int id, OnBannerCoallack coallack) {
        NetUtils.getInstance().getApi().getBanner(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerPage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerPage bannerPage) {
                        if(coallack!=null){
                            coallack.OnBanner(bannerPage);
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
