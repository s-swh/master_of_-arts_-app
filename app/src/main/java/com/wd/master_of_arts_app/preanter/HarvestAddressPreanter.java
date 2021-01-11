package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.DeleteHarvestAddress;
import com.wd.master_of_arts_app.bean.HarvestAddress;
import com.wd.master_of_arts_app.bean.SeleteBean;
import com.wd.master_of_arts_app.bean.UpdateShipping;
import com.wd.master_of_arts_app.bean.ViewHarvestAddress;
import com.wd.master_of_arts_app.contreater.HarvestAddressContreater;
import com.wd.master_of_arts_app.model.HarvestAddressModel;

/**
 * @author 时文豪
 * @description:  添加地址Preanter
 * @date :2020/12/19 14:05
 */
public class HarvestAddressPreanter extends BasePreantert implements HarvestAddressContreater.IPreanter {

    private HarvestAddressModel harvestAddressModel;

    public HarvestAddressPreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        harvestAddressModel = new HarvestAddressModel();
    }
    // 添加收货地址
    @Override
    public void AddHarverstSuccess(String token, String province, String city, String county, String detail_address, String company, String consignee, String contact_number, String postcode, String is_default) {
        harvestAddressModel.AddHarverstSuccess(token, province, city, county, detail_address, company, consignee, contact_number, postcode, is_default, new HarvestAddressContreater.IModel.HarverstCoallack() {
            @Override
            public void AddHarverst(HarvestAddress harvestAddress) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof HarvestAddressContreater.IView){
                    HarvestAddressContreater.IView view= (HarvestAddressContreater.IView) iBaseView;
                    view.AddHarverst(harvestAddress);
                }
            }
        });
    }
    // 查看收获地址列表
    @Override
    public void ViewHarvestAddressSuccess(String token) {
        harvestAddressModel.ViewHarvestAddressSuccess(token, new HarvestAddressContreater.IModel.ViewHarvestCoallack() {
            @Override
            public void ViewHarvestAddress(ViewHarvestAddress viewHarvestAddress) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof HarvestAddressContreater.IView){
                    HarvestAddressContreater.IView view= (HarvestAddressContreater.IView) iBaseView;
                    view.ViewHarvestAddress(viewHarvestAddress);
                }
            }
        });
    }

    @Override
    public void DeleteHarvestSuccess(String token, String address_id) {
        harvestAddressModel.DeleteHarvestSuccess(token, address_id, new HarvestAddressContreater.IModel.DeleteHarvestCoallack() {
            @Override
            public void DeleteHarvest(DeleteHarvestAddress deleteHarvestAddress) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof HarvestAddressContreater.IView){
                    HarvestAddressContreater.IView view= (HarvestAddressContreater.IView) iBaseView;
                    view.DeleteHarvest(deleteHarvestAddress);
                }
            }
        });
    }

    @Override
    public void UpdateSuccess(String token, int address_id, String province, String city, String county, String detail_address, String consignee, String contact_number, String is_default) {
        harvestAddressModel.UpdateSuccess(token, address_id, province, city, county, detail_address, consignee, contact_number, is_default, new HarvestAddressContreater.IModel.UpdataCoallack() {
            @Override
            public void Update(UpdateShipping updateShipping) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof HarvestAddressContreater.IView){
                    HarvestAddressContreater.IView view= (HarvestAddressContreater.IView) iBaseView;
                    view.Update(updateShipping);
                }
            }
        });
    }

    @Override
    public void OnSelectSucess(String token) {
        harvestAddressModel.OnSelectSucess(token, new HarvestAddressContreater.IModel.OnSelectedCoallack() {
            @Override
            public void SelectBean(SeleteBean seleteBean) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof HarvestAddressContreater.IView){
                    HarvestAddressContreater.IView view= (HarvestAddressContreater.IView) iBaseView;
                    view.SelectBean(seleteBean);
                }
            }
        });
    }
}
