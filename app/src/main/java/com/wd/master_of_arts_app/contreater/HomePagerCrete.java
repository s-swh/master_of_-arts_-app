package com.wd.master_of_arts_app.contreater;

import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.BannerPage;
import com.wd.master_of_arts_app.bean.Beanner;
import com.wd.master_of_arts_app.bean.HomePage;

/**
 * @author 时文豪
 * @description: 首页MVP
 * @date :2020/12/17 16:49
 */
public interface HomePagerCrete {
    interface IVew extends IBaseView{
        // 轮播图
        void BannerSuccess(Beanner beanner);
        //首页
        void HomePage(HomePage homePage);
        //轮播图详情
        void OnBanner(BannerPage bannerPage);
    }
    interface IPreanter{
        // 轮播图
        void OnBeanner(int cat_id);
        //首页
        void OnHomepage(String token);
        //轮播图详情
        void OnBannerSuccess(int id);
    }
    interface IModel{
        // 轮播图
        void OnBeanner(int cat_id,BeannerCoallack coallack);
        interface BeannerCoallack{
            void BannerSuccess(Beanner beanner);
        }
        //首页
        void OnHomepage(String token,OnHomePagerCoallack homePagerCoallack);
        interface OnHomePagerCoallack{
            void HomePage(HomePage homePage);
        }
        //轮播图详情
        void OnBannerSuccess(int id,OnBannerCoallack coallack);
        interface OnBannerCoallack{
            void OnBanner(BannerPage bannerPage);
        }
    }
}
