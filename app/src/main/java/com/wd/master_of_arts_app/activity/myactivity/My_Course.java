package com.wd.master_of_arts_app.activity.myactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.Calendar_Activity;
import com.wd.master_of_arts_app.adapter.MyCourseAdapter;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.MyClassDate;
import com.wd.master_of_arts_app.bean.MyCourseDetailsBean;
import com.wd.master_of_arts_app.bean.MyCurse;
import com.wd.master_of_arts_app.contreater.MyCourseContreater;
import com.wd.master_of_arts_app.preanter.MyCoursePreanter;
import com.wd.master_of_arts_app.preanter.MyPreanter;

import java.util.List;

import butterknife.OnClick;

/**
 * 我的课程
 */
public class My_Course extends BaseActivity implements MyCourseContreater.IView {

    private XRecyclerView xrv;
    private int i=1;
    private int j=10;
    private List<MyCurse.DataBean.ListBean> list;
    private MyCourseAdapter myCourseAdapter;
    private MyCurse.DataBean data;
    private LinearLayout wushuju;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_my__course;
    }

    @Override
    protected BasePreantert initModel() {
        return new MyCoursePreanter(this);
    }

    @Override
    protected void initView() {
        xrv = findViewById(R.id.my_coursercv);
        wushuju = findViewById(R.id.wushuju);
    }
    @OnClick(R.id.oncDestruction)
    public void onDestrution(){
        finish();
    }
    @OnClick(R.id.date)
    public void onDate(){
        //跳转到日期选择
        Intent intent = new Intent(getApplicationContext(), Calendar_Activity.class);
        startActivity(intent);
    }
    @Override
    protected void initData() {
        BasePreantert basePreantert = getmPreantert();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xrv.setLayoutManager(linearLayoutManager);

        if(basePreantert instanceof MyCourseContreater.IPreanter){
            SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
            String token1 = token.getString("token", "");
            ((MyCourseContreater.IPreanter) basePreantert).OnMyCourseSuccess(token1,i,j);
        }
       xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
           @Override
           public void onRefresh() {
               xrv.refreshComplete();
           }

           @Override
           public void onLoadMore() {
                myCourseAdapter.LoadMore(data.getList());
                xrv.loadMoreComplete();
                i++;
               if(basePreantert instanceof MyCourseContreater.IPreanter){
                   SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
                   String token1 = token.getString("token", "");
                   ((MyCourseContreater.IPreanter) basePreantert).OnMyCourseSuccess(token1,i,j);
               }
           }
       });


    }

    @Override
    public void OnCourse(MyCurse myCurse) {

        data = myCurse.getData();

        List<MyCurse.DataBean.ListBean> list = data.getList();

        if(list.size()==0){
            wushuju.setVisibility(View.VISIBLE);

        }else{
            myCourseAdapter = new MyCourseAdapter(getApplicationContext(), list);
            myCourseAdapter.setOnClick(new MyCourseAdapter.OnClick() {
                @Override
                public void OnCliack(int id,int order_id) {
                    Intent intent = new Intent(getApplicationContext(), MyCourseDetails.class);
                    intent.putExtra("icqd",id);
                    intent.putExtra("order_id",order_id);
                    startActivity(intent);
                }
            });
            xrv.setAdapter(myCourseAdapter);
        }

    }

    @Override
    public void OnCourseDatails(MyCourseDetailsBean myCourseDetailsBean) {

    }

    @Override
    public void OnMyClassDate(MyClassDate myClassDate) {

    }
}
