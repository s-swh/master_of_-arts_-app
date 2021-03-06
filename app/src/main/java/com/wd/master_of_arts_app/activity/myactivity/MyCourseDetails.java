package com.wd.master_of_arts_app.activity.myactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.MyHomeWork;
import com.wd.master_of_arts_app.activity.OrderComment;
import com.wd.master_of_arts_app.activity.WatchTheReplayActivity;
import com.wd.master_of_arts_app.activity.WorkPage;
import com.wd.master_of_arts_app.adapter.MyCourseAdapterData;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.CommentId;
import com.wd.master_of_arts_app.bean.MyClassDate;
import com.wd.master_of_arts_app.bean.MyCourseDetailsBean;
import com.wd.master_of_arts_app.bean.MyCurse;
import com.wd.master_of_arts_app.contreater.MyCourseContreater;
import com.wd.master_of_arts_app.customview.CustomLinearLayoutManager;
import com.wd.master_of_arts_app.preanter.MyCoursePreanter;
import com.wd.master_of_arts_app.preanter.MyPreanter;
import com.wd.master_of_arts_app.utils.NetUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyCourseDetails extends BaseActivity implements MyCourseContreater.IView {


    private RecyclerView rv;
    private ImageView iv, ls_iv;
    private TextView name, time_detail, num, user_n, unit_num_tv,qpl1;
    private ImageView vv, qpl;
    private int icqd;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_course_details;
    }

    @Override
    protected BasePreantert initModel() {
        return new MyCoursePreanter(this);
    }

    @Override
    protected void initView() {
        rv = findViewById(R.id.details_rv);
        vv = findViewById(R.id.retufn);
        iv = findViewById(R.id.detailsiv);
        name = findViewById(R.id.cour_name);
        time_detail = findViewById(R.id.time_detail);
        unit_num_tv = findViewById(R.id.unit_num_tv);
        num = findViewById(R.id.num);
        ls_iv = findViewById(R.id.ls_iv);
        user_n = findViewById(R.id.user_n);
        qpl = findViewById(R.id.qpl);
        qpl1 = findViewById(R.id.qpl1);

    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    @Override
    protected void initData() {
        BasePreantert basePreantert = getmPreantert();
        if (basePreantert instanceof MyCourseContreater.IPreanter) {
            SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
            String token1 = token.getString("token", "");
            Intent intent = getIntent();
            icqd = intent.getIntExtra("icqd", 0);

            int order_id = intent.getIntExtra("order_id", 0);
            ((MyCourseContreater.IPreanter) basePreantert).OnCourseDatailsSuccess(token1, order_id, icqd);

        }
        CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(customLinearLayoutManager);
        vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void OnCourse(MyCurse myCurse) {

    }

    @Override
    public void OnCourseDatails(MyCourseDetailsBean myCourseDetailsBean) {

        MyCourseDetailsBean.DataBean data = myCourseDetailsBean.getData();

        String course_name = data.getCourse_name();
        name.setText(course_name);
        String t = data.getTime_detail();
        time_detail.setText(t);
        int unit_num = data.getUnit_num();
        num.setText(unit_num + "课时");
        String name = data.getName();
        String job_num = data.getJob_num();
        user_n.setText(name+"\n"+job_num);
        int order_id = data.getOrder_id();
        qpl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyCourseDetails.this, OrderComment.class);
                intent.putExtra("intentid",order_id);
                startActivity(intent);
            }
        });
        qpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyCourseDetails.this, OrderComment.class);
                intent.putExtra("intentid",order_id);
                startActivity(intent);
            }
        });
        unit_num_tv.setText("课程章节(" + unit_num+"节)");
        String avatar = data.getAvatar();
        Glide.with(getApplicationContext()).load(avatar).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(ls_iv);
        Glide.with(getApplicationContext()).load(data.getIcon()).apply(RequestOptions.bitmapTransform(new RoundedCorners(50))).into(iv);
        List<MyCourseDetailsBean.DataBean.UnitListBean> unit_list = data.getUnit_list();
        MyCourseAdapterData myCourseAdapterData = new MyCourseAdapterData(getApplicationContext(), unit_list);

        myCourseAdapterData.OnItemClick(new MyCourseAdapterData.OnHuiFangClick() {



            @Override
            public void OnClicked(int meetingId, List<String> list) {

                Intent intent = new Intent(getApplicationContext(), WatchTheReplayActivity.class);
                intent.putExtra("meetingId",meetingId);


                startActivity(intent);
            }
        });
        //查看作业详情
        myCourseAdapterData.OnClickZSelete(new MyCourseAdapterData.OnClickSelete() {
            @Override
            public void onClickzy(int id, int cid) {
                Intent intent = new Intent(getApplicationContext(), WorkPage.class);
                intent.putExtra("homework_idcid",cid);

                startActivity(intent);
            }
        });
        //提交作业与查看作业详情
        myCourseAdapterData.OnClickZYe(new MyCourseAdapterData.OnClickZYe() {
            @Override
            public void onClickzy(int id,int cid) {
                if(cid==0){
                    Intent intent = new Intent(getApplicationContext(), MyHomeWork.class);
                    intent.putExtra("myHomeWorkid",id);
                    intent.putExtra("itemonr_id",icqd);

                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getApplicationContext(), WorkPage.class);
                    intent.putExtra("homework_idcid",cid);

                    startActivity(intent);
                }


            }
        });
        rv.setAdapter(myCourseAdapterData);
    }

    @Override
    public void OnMyClassDate(MyClassDate myClassDate) {

    }
}
