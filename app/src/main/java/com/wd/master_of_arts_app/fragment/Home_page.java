package com.wd.master_of_arts_app.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.Booking_experience;
import com.wd.master_of_arts_app.activity.Search_Activity;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.Beanner_Bean;
import com.wd.master_of_arts_app.contreater.HomePage_Contract;
import com.wd.master_of_arts_app.preanter.HomePage_Preanter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author 时文豪
 * @description:  首页模块
 * @date :2020/12/3 10:48
 */
@SuppressWarnings("ALL")
public class Home_page extends BaseFragment implements HomePage_Contract.IView{
    @BindView(R.id.xbn)
    XBanner xb;
    @Override
    protected int getLayoutId() {
        return R.layout.home_page;
    }

    @Override
    protected BasePreantert initPreantert() {
        return new HomePage_Preanter(this);
    }
    @OnClick({R.id.search})
    public void search(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getActivity(), Search_Activity.class);
                startActivity(intent);
            }
        }).start();

    }
    @OnClick(R.id.tt_appointment)
    public void appointment(){
        startActivity(new Intent(getActivity(), Booking_experience.class));
    }
    @Override
    protected void initView(View view) {
        BasePreantert basePreantert = getmPreanter();
        if(basePreantert instanceof HomePage_Contract.IPraenter){
            ((HomePage_Contract.IPraenter)basePreantert).BeanSuccess(2,"*");
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    public void OnBeanSuccess(Beanner_Bean beanner_bean) {//首页轮播图
        Beanner_Bean.DataBean data = beanner_bean.getData();
        List<Beanner_Bean.DataBean.ListBean> list = data.getList();
        xb.setData(list,null);
        xb.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                String img = list.get(position).getImg();//获取图片的路径
                Glide.with(getActivity()).load(img).into(((ImageView)view));//图片加载
            }
        });
    }
}
