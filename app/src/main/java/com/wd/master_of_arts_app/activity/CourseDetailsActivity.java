package com.wd.master_of_arts_app.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.adapter.ActivityAdapter;
import com.wd.master_of_arts_app.adapter.CommentAdapter;
import com.wd.master_of_arts_app.adapter.PopActivityAdapter;
import com.wd.master_of_arts_app.adapter.PopServiceAdapter;
import com.wd.master_of_arts_app.adapter.ServiceActivity;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.AgeInterface;
import com.wd.master_of_arts_app.bean.CourseDetails;
import com.wd.master_of_arts_app.bean.CourseList;
import com.wd.master_of_arts_app.bean.DingdanXiangqing;
import com.wd.master_of_arts_app.bean.IdNumber;
import com.wd.master_of_arts_app.contreater.CourseContreater;
import com.wd.master_of_arts_app.payment.SignUpNow;
import com.wd.master_of_arts_app.preanter.CoursePreanter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.OnClick;


public class CourseDetailsActivity extends BaseActivity implements CourseContreater.IView {


    private TextView tv, itle, present_price, original_price, attend, ic_name, gd_pj,goumairenshu,title_r;
    private ImageView img;
    private ImageView ic,details_iv;
    private Button Signupnow;
    private RecyclerView rv_service, rv_service1, rcv;
    private WebView web;
    private RelativeLayout rlt_pl;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_course_details;
    }

    @Override
    protected BasePreantert initModel() {
        return new CoursePreanter(this);
    }

    @Override
    protected void initView() {

        img = findViewById(R.id.jcrImage);
        itle = findViewById(R.id.itle);
        present_price = findViewById(R.id.present_price);
        original_price = findViewById(R.id.original_price);
        rv_service1 = findViewById(R.id.rv_service1);
        rv_service = findViewById(R.id.rv_service);
        attend = findViewById(R.id.attend1);
        ic = findViewById(R.id.ic);
        ic_name = findViewById(R.id.ic_name);
        rcv = findViewById(R.id.rec_rv);
        Signupnow = findViewById(R.id.Signupnow);
        web = findViewById(R.id.web);
        gd_pj = findViewById(R.id.gd_pj);
        details_iv = findViewById(R.id.details_iv);
        goumairenshu = findViewById(R.id.goumairenshu);
        title_r = findViewById(R.id.title_r);
        rlt_pl = findViewById(R.id.rlt_pl);

    }

    @OnClick(R.id.itreturn)
    public void retu() {
        finish();
    }

    @Override
    protected void initData() {
        details_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Signupnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpNow.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        BasePreantert basePreantert = getmPreantert();
        if (basePreantert instanceof CourseContreater.IPreanter) {
            ((CourseContreater.IPreanter) basePreantert).OnCourseOnSuccess(id);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rv_service.setLayoutManager(linearLayoutManager1);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rv_service1.setLayoutManager(linearLayoutManager2);
    }

    //课程列表
    @Override
    public void OnCourse(CourseList courseList) {

    }

    //年龄
    @Override
    public void onAgeInterface(AgeInterface ageInterface) {

    }

    //课程详情
    @Override
    public void OnCourse(CourseDetails courseDetails) {
        CourseDetails.DataBean data = courseDetails.getData();

        int class_sale_count = data.getClass_sale_count();
        goumairenshu.setText("已购买"+class_sale_count+"人");
        String icon = data.getIcon();
        Glide.with(this).load(icon).into(img);
        String content = data.getContent();
        title_r.setText(data.getCourse_name());

        web.getSettings().setUseWideViewPort(true);
        web.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);//适应内容大小
        web.getSettings().setLoadWithOverviewMode(true);

        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);//支持JS
        String js = "<script type=\"text/javascript\">"+
                "var imgs = document.getElementsByTagName('img');" + // 找到img标签
                "for(var i = 0; i<imgs.length; i++){" +  // 逐个改变
                "imgs[i].style.width = '100%';" +  // 宽度改为100%
                "imgs[i].style.height = 'auto';" +
                "}" +
                "</script>";
        web.loadDataWithBaseURL(null, content+js, "text/html", "UTF-8", null);

        present_price.setText(data.getPrice() + "￥");
        original_price.setText(data.getOld_price() + "￥");
        String course_name1 = data.getCourse_name();
        String icon1 = data.getIcon();
        String time_detail = data.getTime_detail();
        String first_class_time = data.getFirst_class_time();
        String de = time_detail + first_class_time;
        String price = data.getPrice();
        EventBus.getDefault().postSticky(new DingdanXiangqing(course_name1, de, price, icon1));


        int course_id = data.getCourse_id();
        gd_pj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseDetailsActivity.this, MoreComments.class);
                intent.putExtra("course_idzc", course_id);

                startActivity(intent);
            }
        });
        int course_time_id = data.getCourse_time_id();
        EventBus.getDefault().postSticky(new IdNumber(course_id, course_time_id));


        //活动适配器
        List<CourseDetails.DataBean.MarkBean> mark = data.getMark();
        ActivityAdapter activityAdapter = new ActivityAdapter(this, mark);
        activityAdapter.Click(new ActivityAdapter.cnClick() {

            private PopupWindow popupBigPhoto;

            @Override
            public void OnClick(CourseDetails.DataBean.MarkBean markBeans) {
                int id = markBeans.getId();

                String description = markBeans.getDescription();
                View view = getLayoutInflater().inflate(R.layout.activity_photo_preview, null);
                if (popupBigPhoto == null) {
                    popupBigPhoto = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                    popupBigPhoto.setOutsideTouchable(true);
                }
                if (popupBigPhoto.isShowing()) {
                    popupBigPhoto.dismiss();
                } else {
                    popupBigPhoto.showAtLocation(view, Gravity.TOP, 0, 0);
                }

// 设置PopupWindow是否能响应外部点击事件
                popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                popupBigPhoto.setTouchable(true);
                RecyclerView v = view.findViewById(R.id.rec_service1);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                v.setLayoutManager(linearLayoutManager);
                PopActivityAdapter popActivityAdapter = new PopActivityAdapter(getApplicationContext(), mark);
                v.setAdapter(popActivityAdapter);
                ImageView xz = view.findViewById(R.id.xz);
                LinearLayout de = view.findViewById(R.id.dimens);
                de.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupBigPhoto.dismiss();
                    }
                });
                String mark1 = markBeans.getMark();

                String description1 = markBeans.getDescription();

                xz.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupBigPhoto.dismiss();
                    }
                });
            }
        });

        rv_service1.setAdapter(activityAdapter);

        List<CourseDetails.DataBean.ServiceBean> service = data.getService();
        //服务适配器
        ServiceActivity serviceActivity = new ServiceActivity(this, data);

        serviceActivity.OnClicked(new ServiceActivity.OnService() {
            private PopupWindow popupBigPhoto;

            @Override
            public void OnCliakc(CourseDetails.DataBean.ServiceBean serviceBean) {
                int id = serviceBean.getId();

                View view = getLayoutInflater().inflate(R.layout.service, null);
                if (popupBigPhoto == null) {
                    popupBigPhoto = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
                    popupBigPhoto.setOutsideTouchable(true);
                }
                if (popupBigPhoto.isShowing()) {
                    popupBigPhoto.dismiss();
                } else {
                    popupBigPhoto.showAtLocation(view, Gravity.TOP, 0, 0);
                }

// 设置PopupWindow是否能响应外部点击事件
                popupBigPhoto.setOutsideTouchable(true);
// 设置PopupWindow是否能响应点击事件
                popupBigPhoto.setTouchable(true);
                ImageView zx = view.findViewById(R.id.xz);
                LinearLayout let = view.findViewById(R.id.dimens);
                RecyclerView rv = view.findViewById(R.id.rec_service);
                String description = serviceBean.getDescription();
                String service1 = serviceBean.getService();
                String icon1 = serviceBean.getIcon();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                rv.setLayoutManager(linearLayoutManager);
                PopServiceAdapter popServiceAdapter = new PopServiceAdapter(getApplicationContext(), data);
                rv.setAdapter(popServiceAdapter);

                let.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupBigPhoto.dismiss();
                    }
                });
                zx.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupBigPhoto.dismiss();
                    }
                });
            }
        });
        rv_service.setAdapter(serviceActivity);


        attend.setText(data.getTime_detail());
        Glide.with(this).load(data.getTeacher_avatar()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(ic);
        ic_name.setText(data.getTeacher_name());


        List<CourseDetails.DataBean.CommentListBean> comment_list = data.getComment_list();
        if(comment_list.size()==0){
            rlt_pl.setVisibility(View.GONE);
        }
        //适配器加载评论列表
        CommentAdapter commentAdapter = new CommentAdapter(this, comment_list);
        rcv.setAdapter(commentAdapter);
    }

}
