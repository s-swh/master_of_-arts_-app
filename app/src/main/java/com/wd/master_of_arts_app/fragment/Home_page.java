package com.wd.master_of_arts_app.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.Booking_experience;
import com.wd.master_of_arts_app.activity.CoursePreview;
import com.wd.master_of_arts_app.activity.Search_Activity;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.Beanner;
import com.wd.master_of_arts_app.bean.HomePage;
import com.wd.master_of_arts_app.contreater.HomePagerCrete;
import com.wd.master_of_arts_app.preanter.HomePreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 时文豪
 * @description:  首页模块
 * @date :2020/12/3 10:48
 */
@SuppressWarnings("ALL")
public class Home_page extends BaseFragment implements HomePagerCrete.IVew, View.OnClickListener {
    @BindView(R.id.xbn)
    XBanner xb;
    private ImageView iv;
    private TextView tv;

    @Override
    protected int getLayoutId() {
        return R.layout.home_page;
    }

    @Override
    protected BasePreantert initPreantert() {

        return new HomePreanter(this);
    }


    @Override
    protected void initView(View view) {
        iv = view.findViewById(R.id.tt_appointment);
        tv = view.findViewById(R.id.tv_tvv);

    }

    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
        String token1 = token.getString("token", "");
        BasePreantert basePreantert=getmPreanter();
        if(basePreantert instanceof HomePagerCrete.IPreanter){
            ((HomePagerCrete.IPreanter) basePreantert).OnBeanner(2);
            if(token1!=null){
                ((HomePagerCrete.IPreanter) basePreantert).OnHomepage(token1);
            }else{
                ((HomePagerCrete.IPreanter) basePreantert).OnHomepage("");
            }

        }



    }



    @Override
    protected void initData() {
        SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
        String token1 = token.getString("token", "");
        BasePreantert basePreantert=getmPreanter();
        if(basePreantert instanceof HomePagerCrete.IPreanter){
            ((HomePagerCrete.IPreanter) basePreantert).OnBeanner(2);
            if(token1!=null){
                ((HomePagerCrete.IPreanter) basePreantert).OnHomepage(token1);
            }else{
                ((HomePagerCrete.IPreanter) basePreantert).OnHomepage("");
            }

        }



    }

    @Override
    public void BannerSuccess(Beanner beanner) {
        Beanner.DataBean data = beanner.getData();
        List<Beanner.DataBean.ListBean> list = data.getList();
        xb.setData(list,null);
        xb.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Beanner.DataBean.ListBean listBean = list.get(position);
                String img = listBean.getImg();
                Glide.with(Home_page.this).load(img).into(((ImageView)view));
            }
        });
    }

    @Override
    public void HomePage(HomePage homePage) {
        HomePage.DataBean data = homePage.getData();
        int status = data.getStatus();
        String button = data.getButton();
        tv.setText(button);
        int unit_id = data.getUnit_id();

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(status==0){
                    startActivity(new Intent(getActivity(), Booking_experience.class));
                }else if(status==1){

                }else if(status==2){
                    Intent intent = new Intent(getActivity(), CoursePreview.class);
                    intent.putExtra("unit_id_two",unit_id);
                    startActivity(intent);
                }else if(status==3){

                }else if(status==4){

                }else if(status==5){

                }
            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}
