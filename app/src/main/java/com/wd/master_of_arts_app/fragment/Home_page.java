package com.wd.master_of_arts_app.fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Outline;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.stx.xhb.xbanner.XBanner;
import com.wd.master_of_arts_app.activity.AboutUs;
import com.wd.master_of_arts_app.activity.BannerActivity;
import com.wd.master_of_arts_app.activity.CoursePreview;
import com.wd.master_of_arts_app.activity.CourseSelection;
import com.wd.master_of_arts_app.activity.GuideToUse;
import com.wd.master_of_arts_app.activity.LiveBroadcast;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.Booking_experience;
import com.wd.master_of_arts_app.activity.Login_interface;
import com.wd.master_of_arts_app.activity.MainActivity;
import com.wd.master_of_arts_app.activity.MyHomeWork;
import com.wd.master_of_arts_app.activity.NoticeActivity;
import com.wd.master_of_arts_app.activity.Verification_code_login;
import com.wd.master_of_arts_app.activity.WorkPage;
import com.wd.master_of_arts_app.adapter.HomePageAdapter;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.BannerPage;
import com.wd.master_of_arts_app.bean.Beanner;
import com.wd.master_of_arts_app.bean.Extra;
import com.wd.master_of_arts_app.bean.HomePage;
import com.wd.master_of_arts_app.bean.NoticeNumBer;
import com.wd.master_of_arts_app.bean.Update;
import com.wd.master_of_arts_app.contreater.HomePagerCrete;
import com.wd.master_of_arts_app.customview.CustomLinearLayoutManager;
import com.wd.master_of_arts_app.customview.CustomRoundAngleImageView;
import com.wd.master_of_arts_app.preanter.HomePreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import cn.jpush.android.api.JPushInterface;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * @author 时文豪
 * @description: 首页模块
 * @date :2020/12/3 10:48
 */
@SuppressWarnings("ALL")
public class Home_page extends BaseFragment implements HomePagerCrete.IVew, View.OnClickListener {
    @BindView(R.id.xbn)
    XBanner xb;

    private Disposable downDisposable;
    private ProgressBar progressBar;
    private TextView textView4;
    private Button upgrade;
    private long downloadLength = 0;
    private long contentLength = 0;
    private String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private TextView tv, home_tv, left_title, left_date, left_tv, tv_tvv;
    private ImageView left, right, notice_iv, icon_tz_y, home_img;
    private RecyclerView home_rv;
    private List<HomePage.DataBean> data;
    private RelativeLayout rec_gono, rellt;
    private int version;

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
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        tv = view.findViewById(R.id.tv_tvv);
        left = view.findViewById(R.id.iv_left);
        right = view.findViewById(R.id.iv_right);
        notice_iv = view.findViewById(R.id.notice_iv);
        icon_tz_y = view.findViewById(R.id.icon_tz_y);
        home_img = view.findViewById(R.id.home_img);
        home_tv = view.findViewById(R.id.home_tv);
        left_title = view.findViewById(R.id.left_title);
        left_date = view.findViewById(R.id.left_date);
        left_tv = view.findViewById(R.id.left_tv);
        home_rv = view.findViewById(R.id.home_rv);
        tv_tvv = view.findViewById(R.id.tv_tvv);
        rec_gono = view.findViewById(R.id.rec_gono);
        rellt = view.findViewById(R.id.rellt);

    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void postEvent(Bundle bundle) {
        String extra = bundle.getString(JPushInterface.EXTRA_EXTRA);
        initData();
        initMVC();
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
        initMVC();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }



    private int anzhuo_num;
    private String anzhuo_link;

    @Override
    protected void initData() {




        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AboutUs.class);
                startActivity(intent);
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GuideToUse.class);
                startActivity(intent);
            }
        });
        notice_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NoticeActivity.class);
                startActivity(intent);
            }
        });
        SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
        String token1 = token.getString("token", "");
        BasePreantert basePreantert = getmPreanter();
        if (basePreantert instanceof HomePagerCrete.IPreanter) {
            ((HomePagerCrete.IPreanter) basePreantert).OnBeanner(2);
            if (token1 != null) {
                ((HomePagerCrete.IPreanter) basePreantert).OnHomepage(token1);
          /*      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, true);
                home_rv.setLayoutManager(linearLayoutManager);*/
/*                CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, true);
                home_rv.setLayoutManager(customLinearLayoutManager);*/

            } else {
                ((HomePagerCrete.IPreanter) basePreantert).OnHomepage("");

            }

        }
        initMVC();
    }



    private void initMVC() {
        SharedPreferences sp = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");
        NetUtils.getInstance().getApi().getNoticeNumber(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NoticeNumBer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NoticeNumBer noticeNumBer) {
                        int code = noticeNumBer.getCode();
                        int data = noticeNumBer.getData();
                        if (data > 0) {
                            icon_tz_y.setVisibility(View.VISIBLE);
                            notice_iv.setVisibility(View.GONE);
                        } else {
                            notice_iv.setVisibility(View.VISIBLE);
                            icon_tz_y.setVisibility(View.GONE);
                        }
                        icon_tz_y.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getActivity(), NoticeActivity.class);
                                startActivity(intent);
                            }
                        });
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
    public void BannerSuccess(Beanner beanner) {

        Beanner.DataBean data = beanner.getData();
        List<Beanner.DataBean.ListBean> list = data.getList();

        xb.setData(list, null);
        xb.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 10);
            }
        });
        xb.setClipToOutline(true);
        xb.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Beanner.DataBean.ListBean listBean = list.get(position);
                String img = listBean.getImg();
                Glide.with(Home_page.this).load(img).into(((ImageView) view));
            }
        });
        xb.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                Beanner.DataBean.ListBean listBean = list.get(position);
                int id = listBean.getId();
                String href = listBean.getHref();
                Intent intent = new Intent(getActivity(), BannerActivity.class);
                intent.putExtra("BannerId", id);
                startActivity(intent);

            }
        });
    }

    @Override
    public void HomePage(HomePage homePage) {

        data = homePage.getData();

        if (data.size() == 1 && data.get(0).getStatus() == 6) {
            String button = data.get(0).getButton();
            tv_tvv.setText(button);
            tv_tvv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getActivity(), Login_interface.class));
                }
            });
            rec_gono.setVisibility(View.VISIBLE);
            rellt.setVisibility(View.GONE);
        } else {
            rec_gono.setVisibility(View.GONE);
            rellt.setVisibility(View.VISIBLE);
            if (data.size() == 1) {
                SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
                String token1 = token.getString("token", "");
                BasePreantert basePreantert = getmPreanter();
                if (basePreantert instanceof HomePagerCrete.IPreanter) {

                    if (token1 != null) {
                        //   ((HomePagerCrete.IPreanter) basePreantert).OnHomepage(token1);
                        CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(getActivity());
                        home_rv.setLayoutManager(customLinearLayoutManager);


                    } else {
                        //   ((HomePagerCrete.IPreanter) basePreantert).OnHomepage("");

                    }

                }
            } else if (data.size() >= 2) {
                SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
                String token1 = token.getString("token", "");
                BasePreantert basePreantert = getmPreanter();
                if (basePreantert instanceof HomePagerCrete.IPreanter) {

                    if (token1 != null) {
                        //     ((HomePagerCrete.IPreanter) basePreantert).OnHomepage(token1);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
                        home_rv.setLayoutManager(linearLayoutManager);


                    } else {
                        //   ((HomePagerCrete.IPreanter) basePreantert).OnHomepage("");

                    }

                }
            }
            HomePageAdapter homePageAdapter = new HomePageAdapter(getActivity(), data);
            homePageAdapter.OnClick(new HomePageAdapter.OnHomeOnClick() {
                @Override
                public void OnClickItem(HomePage.DataBean dataBean) {
                    int status = dataBean.getStatus();
                    int unit_id = dataBean.getUnit_id();
                    int class_id = dataBean.getClass_id();
                    String unit_name = dataBean.getUnit_name();
                    int id = dataBean.getCourse_time_id();
                    int homework_id = dataBean.getHomework_id();
                    if (status == 0) {
                        startActivity(new Intent(getActivity(), Booking_experience.class));
                    } else if (status == 1) {

                        Intent intent = new Intent(getActivity(), CourseSelection.class);
                        startActivity(intent);


                    } else if (status == 2) {
                        Intent intent = new Intent(getContext(), CoursePreview.class);

                        intent.putExtra("unit_id_two", unit_id);
                        startActivity(intent);

                    } else if (status == 3) {
                        Intent intent = new Intent(getActivity(), LiveBroadcast.class);
                        intent.putExtra("classid", class_id);
                        intent.putExtra("unit_ssname", unit_name);
                        startActivity(intent);
                    } else if (status == 4) {
                        Intent intent = new Intent(getActivity(), MyHomeWork.class);
                        intent.putExtra("unit_id_two", unit_id);
                        intent.putExtra("myHomeWorkid", unit_id);
                        intent.putExtra("ididididid", id);
                        intent.putExtra("itemonr_id", id);
                        startActivity(intent);
                    } else if (status == 5) {
                        Intent intent = new Intent(getActivity(), WorkPage.class);
                        intent.putExtra("homework_idcid", homework_id);
                        startActivity(intent);
                    }
                }
            });
            home_rv.setAdapter(homePageAdapter);
        }


    }

    @Override
    public void OnBanner(BannerPage bannerPage) {

    }

    @Override
    public void onClick(View view) {

    }
}