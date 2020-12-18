package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.Beanner;

/**
 * @author 时文豪
 * @description: 首页MVP
 * @date :2020/12/17 16:49
 */
public interface HomePagerCrete {
    interface IVew extends IBaseView{
        //todo 轮播图
        void BannerSuccess(Beanner beanner);
    }
    interface IPreanter{
        //todo 轮播图
        void OnBeanner(int cat_id);
    }
    interface IModel{
        //todo 轮播图
        void OnBeanner(int cat_id,BeannerCoallack coallack);
        interface BeannerCoallack{
            void BannerSuccess(Beanner beanner);
        }
    }
}
