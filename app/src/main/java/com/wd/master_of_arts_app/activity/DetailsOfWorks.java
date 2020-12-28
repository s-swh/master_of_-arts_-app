package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.adapter.DetailsWorksAdapter;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.DetailsOfWorksBean;
import com.wd.master_of_arts_app.bean.ListOfWorks;
import com.wd.master_of_arts_app.contreater.worksContreanter;
import com.wd.master_of_arts_app.preanter.WorksPreanter;

import java.util.List;

public class DetailsOfWorks extends BaseActivity implements worksContreanter.IVew {


    private RecyclerView rv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details_of_works;
    }

    @Override
    protected BasePreantert initModel() {
        return new WorksPreanter(this);
    }

    @Override
    protected void initView() {
        rv = findViewById(R.id.wor_rv);
    }

    @Override
    protected void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        BasePreantert basePreantert = getmPreantert();
        if(basePreantert instanceof worksContreanter.IPreanter){
            Intent intent = getIntent();
            int work_id = intent.getIntExtra("work_id", 0);
            ((worksContreanter.IPreanter) basePreantert).OnDetailsSuccess(work_id);
        }
    }

    @Override
    public void OnWorks(ListOfWorks listOfWorks) {

    }

    @Override
    public void OnDetailsWorks(DetailsOfWorksBean worksBean) {
        DetailsOfWorksBean.DataBean data = worksBean.getData();
        List<DetailsOfWorksBean.DataBean.WorkMsgBean> workMsg = data.getWorkMsg();
        DetailsWorksAdapter detailsWorksAdapter = new DetailsWorksAdapter(getApplicationContext(), workMsg);
        rv.setAdapter(detailsWorksAdapter);
    }
}
