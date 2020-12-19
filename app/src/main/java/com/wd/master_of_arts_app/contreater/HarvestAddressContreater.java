package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.DeleteHarvestAddress;
import com.wd.master_of_arts_app.bean.HarvestAddress;
import com.wd.master_of_arts_app.bean.ViewHarvestAddress;

/**
 * @author 时文豪
 * @description: 我的订单
 * @date :2020/12/19 13:55
 */
public interface HarvestAddressContreater {

    interface IView extends IBaseView{
        //添加地址
        void AddHarverst(HarvestAddress harvestAddress);
        // 获取地址列表
        void ViewHarvestAddress(ViewHarvestAddress viewHarvestAddress);
        //删除收获地址
        void DeleteHarvest(DeleteHarvestAddress deleteHarvestAddress);
    }
    interface IPreanter{
        //添加地址
        void AddHarverstSuccess(String token,String province,String city,String county,String detail_address,String company,String consignee,String contact_number,String postcode,String is_default);
        //获取收获地址列表
        void ViewHarvestAddressSuccess(String token);
        //删除收获地址
        void DeleteHarvestSuccess(String token,String address_id);
    }
    interface IModel{
        //添加地址
        void AddHarverstSuccess(String token,String province,String city,String county,String detail_address,String company,String consignee,String contact_number,String postcode,String is_default,HarverstCoallack harverstCoallack);
        interface HarverstCoallack{
            void AddHarverst(HarvestAddress harvestAddress);
        }
        //获取收获地址列表
        void ViewHarvestAddressSuccess(String token,ViewHarvestCoallack coallack);
        interface ViewHarvestCoallack{
            void ViewHarvestAddress(ViewHarvestAddress viewHarvestAddress);
        }
        // 删除收获地址
        void DeleteHarvestSuccess(String token,String address_id,DeleteHarvestCoallack deleteHarvestCoallack);
        interface DeleteHarvestCoallack{
            void DeleteHarvest(DeleteHarvestAddress deleteHarvestAddress);
        }
    }
}
