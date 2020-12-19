package com.wd.master_of_arts_app.model;

import com.wd.master_of_arts_app.bean.DeleteHarvestAddress;
import com.wd.master_of_arts_app.bean.HarvestAddress;
import com.wd.master_of_arts_app.bean.ViewHarvestAddress;
import com.wd.master_of_arts_app.contreater.HarvestAddressContreater;
import com.wd.master_of_arts_app.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description: 添加收获地址Model
 * @date :2020/12/19 14:04
 */
public class HarvestAddressModel implements HarvestAddressContreater.IModel {
    //添加地址列表
    @Override
    public void AddHarverstSuccess(String token, String province, String city, String county, String detail_address, String company, String consignee, String contact_number, String postcode, String is_default, HarverstCoallack harverstCoallack) {
        NetUtils.getInstance().getApi().getHarvestAddress(token, province, city, county, detail_address, company, consignee, contact_number, postcode, is_default)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HarvestAddress>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HarvestAddress harvestAddress) {
                        if(harverstCoallack!=null){
                            harverstCoallack.AddHarverst(harvestAddress);
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
    // 查看收获地址列表
    @Override
    public void ViewHarvestAddressSuccess(String token, ViewHarvestCoallack coallack) {
        NetUtils.getInstance().getApi().getViewHarvest(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ViewHarvestAddress>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ViewHarvestAddress viewHarvestAddress) {
                        if(coallack!=null){
                            coallack.ViewHarvestAddress(viewHarvestAddress);
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
    public void DeleteHarvestSuccess(String token, String address_id, DeleteHarvestCoallack deleteHarvestCoallack) {
        NetUtils.getInstance().getApi().getDelete(token,address_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DeleteHarvestAddress>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DeleteHarvestAddress deleteHarvestAddress) {
                        if(deleteHarvestCoallack!=null){
                            deleteHarvestCoallack.DeleteHarvest(deleteHarvestAddress);
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
