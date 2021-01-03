package com.wd.master_of_arts_app.preanter;

import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.base.IBaseView;
import com.wd.master_of_arts_app.bean.Beanner;
import com.wd.master_of_arts_app.bean.HomePage;
import com.wd.master_of_arts_app.contreater.HomePagerCrete;
import com.wd.master_of_arts_app.model.HomeModel;

/**
 * @author 时文豪
 * @description: 主页p层
 * @date :2020/12/17 16:53
 */
public class HomePreanter extends BasePreantert implements HomePagerCrete.IPreanter {

    private HomeModel homeModel;

    public HomePreanter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModer() {
        homeModel = new HomeModel();
    }

    @Override
    public void OnBeanner(int cat_id) {
        homeModel.OnBeanner(cat_id, new HomePagerCrete.IModel.BeannerCoallack() {
            @Override
            public void BannerSuccess(Beanner beanner) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof HomePagerCrete.IVew){
                    HomePagerCrete.IVew vew= (HomePagerCrete.IVew) iBaseView;
                    vew.BannerSuccess(beanner);
                }
            }
        });
    }

    @Override
    public void OnHomepage(String token) {
        homeModel.OnHomepage(token, new HomePagerCrete.IModel.OnHomePagerCoallack() {
            @Override
            public void HomePage(HomePage homePage) {
                IBaseView iBaseView = getView();
                if(iBaseView instanceof HomePagerCrete.IVew){
                    HomePagerCrete.IVew vew= (HomePagerCrete.IVew) iBaseView;
                    vew.HomePage(homePage);
                }
            }
        });
    }
}
