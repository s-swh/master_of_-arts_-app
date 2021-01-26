package com.wd.master_of_arts_app.activity.myactivity;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.activity.SampleReelsActivity;
import com.wd.master_of_arts_app.adapter.MyCourseOneAdapter;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.MyClassDate;
import com.wd.master_of_arts_app.bean.MyCourseDetailsBean;
import com.wd.master_of_arts_app.bean.MyCurse;
import com.wd.master_of_arts_app.contreater.MyCourseContreater;
import com.wd.master_of_arts_app.preanter.MyCoursePreanter;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

/**
 *
 */
public class My_Collection_of_works extends BaseActivity implements MyCourseContreater.IView {


    private XRecyclerView xrv;
    private LinearLayout llt;
    private MyCourseOneAdapter myCourseOneAdapter;
    private MyCurse.DataBean data;
    List<MyCurse.DataBean.ListBean> listBean=new ArrayList<>();
    private List<MyCurse.DataBean.ListBean> list;
    private int i=1;
    private int j=10;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_my__collection_of_works;
    }

    @Override
    protected BasePreantert initModel() {
        return new MyCoursePreanter(this);
    }

    @Override
    protected void initView() {
        xrv = findViewById(R.id.my_courserv);
        llt = findViewById(R.id.llt);
    }

    @OnClick(R.id.oncDestruction)
    public void onDestrution() {
        finish();
    }

    @Override
    protected void initData() {
        xrv.setLoadingMoreEnabled(true);
        xrv.setPullRefreshEnabled(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xrv.setLayoutManager(linearLayoutManager);
        BasePreantert basePreantert = getmPreantert();
        if (basePreantert instanceof MyCourseContreater.IPreanter) {
            SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
            String token1 = token.getString("token", "");
            ((MyCourseContreater.IPreanter) basePreantert).OnMyCourseSuccess(token1, i, 10);
        }
        xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                i=1;
                myCourseOneAdapter.ShuaXin(data.getList());
                if (basePreantert instanceof MyCourseContreater.IPreanter) {
                    SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
                    String token1 = token.getString("token", "");
                    ((MyCourseContreater.IPreanter) basePreantert).OnMyCourseSuccess(token1, i, 10);
                }
                LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getApplicationContext());
                xrv.setLayoutManager(linearLayoutManager1);
            }

            @Override
            public void onLoadMore() {
                i++;
                if (basePreantert instanceof MyCourseContreater.IPreanter) {
                    SharedPreferences token = getSharedPreferences("token", MODE_PRIVATE);
                    String token1 = token.getString("token", "");
                    ((MyCourseContreater.IPreanter) basePreantert).OnMyCourseSuccess(token1, i, 10);
                }

            }
        });
        myCourseOneAdapter = new MyCourseOneAdapter(getApplicationContext(), listBean);
        xrv.setAdapter(myCourseOneAdapter);
        myCourseOneAdapter.setOnClick(new MyCourseOneAdapter.OnClick() {

            private String teacher_name;
            private String title;

            @Override
            public void OnCliack(int id) {
                Intent intent = new Intent(getApplicationContext(), SampleReelsActivity.class);
                for (int i = 0; i < list.size(); i++) {
                    MyCurse.DataBean.ListBean listBean = list.get(i);
                    title = listBean.getTitle();


                }
                intent.putExtra("titlet", title);
                intent.putExtra("teacher_namea", teacher_name);
                intent.putExtra("course_time_id111", id);
                startActivity(intent);
            }
        });
    }


    @Override
    public void OnCourse(MyCurse myCurse) {

        data = myCurse.getData();
        list = data.getList();
        listBean= list;
        myCourseOneAdapter.JiaZai(listBean);
        if(listBean.size()==0){
            Toast.makeText(this, "没用更多数据", Toast.LENGTH_SHORT).show();
        }
        if (i==1&&list.size()==0) {
            llt.setVisibility(View.VISIBLE);
            xrv.setVisibility(View.GONE);
        } else {
            llt.setVisibility(View.GONE);
            xrv.setVisibility(View.VISIBLE);
        }
        xrv.refreshComplete();
        xrv.loadMoreComplete();
        myCourseOneAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnCourseDatails(MyCourseDetailsBean myCourseDetailsBean) {

    }

    @Override
    public void OnMyClassDate(MyClassDate myClassDate) {

    }
}
