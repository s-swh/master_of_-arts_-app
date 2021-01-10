package com.wd.master_of_arts_app.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.stx.xhb.xbanner.XBanner;
import com.wd.master_of_arts_app.activity.BannerActivity;
import com.wd.master_of_arts_app.activity.CoursePreview;
import com.wd.master_of_arts_app.activity.CourseSelection;
import com.wd.master_of_arts_app.activity.LiveBroadcast;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.Booking_experience;
import com.wd.master_of_arts_app.activity.MainActivity;
import com.wd.master_of_arts_app.activity.MyHomeWork;
import com.wd.master_of_arts_app.activity.NoticeActivity;
import com.wd.master_of_arts_app.activity.WorkPage;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.Beanner;
import com.wd.master_of_arts_app.bean.HomePage;
import com.wd.master_of_arts_app.bean.NoticeNumBer;
import com.wd.master_of_arts_app.contreater.HomePagerCrete;
import com.wd.master_of_arts_app.preanter.HomePreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
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

    private TextView tv,home_tv,left_title,left_date,left_tv;
    private ImageView left, right, notice_iv, icon_tz_y,home_img;

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
        Glide.with(this).load(R.mipmap.icon_left_lf).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(left);
        Glide.with(this).load(R.mipmap.icon_right_ri).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(right);
    }

    @Override
    public void onStart() {
        super.onStart();
        SharedPreferences token = App.getContext().getSharedPreferences("token", Context.MODE_PRIVATE);
        String token1 = token.getString("token", "");
        BasePreantert basePreantert = getmPreanter();
        if (basePreantert instanceof HomePagerCrete.IPreanter) {
            ((HomePagerCrete.IPreanter) basePreantert).OnBeanner(2);
            if (token1 != null) {
                ((HomePagerCrete.IPreanter) basePreantert).OnHomepage(token1);
            } else {
                ((HomePagerCrete.IPreanter) basePreantert).OnHomepage("");
            }

        }


    }


    @Override
    protected void initData() {

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
                            icon_tz_y.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(getActivity(), NoticeActivity.class);
                                    startActivity(intent);
                                }
                            });
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
                String href = listBean.getHref();
                if (href == null || href != null) {
                    Intent intent = new Intent(getActivity(), BannerActivity.class);
                    intent.putExtra("hrefweb", href);
                    startActivity(intent);
                }
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
        int class_id = homePage.getData().getClass_id();
        String unit_name = homePage.getData().getUnit_name();
        int homework_id = homePage.getData().getHomework_id();
        int id = homePage.getData().getCourse_time_id();
        String avatar = data.getAvatar();
        Glide.with(getActivity()).load(avatar).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(home_img);
        String teacher = data.getTeacher();
        String course_name = data.getCourse_name();
        home_tv.setText(course_name+"\n任课老师\n\t"+teacher);
        String unit_name1 = data.getUnit_name();
        String date = data.getDate();
        String time = data.getTime();
        left_title.setText(date);
        left_date.setText(time);
        left_tv.setText(unit_name1);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (status == 0) {
                    startActivity(new Intent(getActivity(), Booking_experience.class));
                } else if (status == 1) {

                    Intent intent = new Intent(getActivity(), CourseSelection.class);
                    startActivity(intent);



                } else if (status == 2) {
                    Intent intent = new Intent(getContext(), CoursePreview.class);

                    intent.putExtra("unit_id_two", unit_id);
                    startActivity(intent);

                    Toast.makeText(getContext(), "点击", Toast.LENGTH_SHORT).show();
                } else if (status == 3) {
                    Intent intent = new Intent(getActivity(), LiveBroadcast.class);
                    intent.putExtra("classid", class_id);
                    intent.putExtra("unit_ssname", unit_name);
                    startActivity(intent);
                } else if (status == 4) {
                    Intent intent = new Intent(getActivity(), MyHomeWork.class);
                    intent.putExtra("unit_id_two", unit_id);
                    intent.putExtra("ididididid", id);
                    startActivity(intent);
                } else if (status == 5) {
                    Intent intent = new Intent(getActivity(), WorkPage.class);
                    intent.putExtra("homework_idcid", homework_id);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}