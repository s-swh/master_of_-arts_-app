package com.wd.master_of_arts_app.activity.myactivity;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.LinearLayout;

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
            ((MyCourseContreater.IPreanter) basePreantert).OnMyCourseSuccess(token1, 1, 10);
        }
        xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                xrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                myCourseOneAdapter.JiaZai(data.getList());
                xrv.loadMoreComplete();
            }
        });
    }


    @Override
    public void OnCourse(MyCurse myCurse) {

        data = myCurse.getData();
        List<MyCurse.DataBean.ListBean> list = data.getList();
        if (list.size() == 0) {
            llt.setVisibility(View.VISIBLE);
            xrv.setVisibility(View.GONE);
        } else {
            llt.setVisibility(View.GONE);
            xrv.setVisibility(View.VISIBLE);
            myCourseOneAdapter = new MyCourseOneAdapter(getApplicationContext(), list);
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
            xrv.setAdapter(myCourseOneAdapter);
        }
    }

    @Override
    public void OnCourseDatails(MyCourseDetailsBean myCourseDetailsBean) {

    }

    @Override
    public void OnMyClassDate(MyClassDate myClassDate) {

    }
}
