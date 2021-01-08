package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.adapter.MoreCommentsAdapter;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.MoreComm;
import com.wd.master_of_arts_app.contreater.MoreContreanter;
import com.wd.master_of_arts_app.preanter.MorePreanter;

import java.util.List;

public class MoreComments extends BaseActivity implements MoreContreanter.IView {


    private XRecyclerView xrv;
    private ImageView iv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_more_comments;
    }

    @Override
    protected BasePreantert initModel() {
        return new MorePreanter(this);
    }

    @Override
    protected void initView() {
        xrv = findViewById(R.id.more_xrv);
        iv = findViewById(R.id.returfan);
    }

    @Override
    protected void initData() {
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        xrv.setPullRefreshEnabled(true);
        xrv.setLoadingMoreEnabled(true);
        BasePreantert basePreantert = getmPreantert();
        Intent intent = getIntent();
        int course_idzc = intent.getIntExtra("course_idzc", 0);
        if(basePreantert instanceof MoreContreanter.IPreanter){
            ((MoreContreanter.IPreanter) basePreantert).OnMoreSuccess(course_idzc,1,10);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xrv.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void OnMore(MoreComm moreComm) {
        MoreComm.DataBean data = moreComm.getData();
        List<MoreComm.DataBean.ListBean> list = data.getList();
        MoreCommentsAdapter moreCommentsAdapter = new MoreCommentsAdapter(getApplicationContext(), list);
        xrv.setAdapter(moreCommentsAdapter);
    }
}
