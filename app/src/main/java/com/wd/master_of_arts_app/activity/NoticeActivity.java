package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.adapter.NoticeAdapter;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.NoticeBean;
import com.wd.master_of_arts_app.bean.NoticeDetailsBean;
import com.wd.master_of_arts_app.bean.NoticeNumBer;
import com.wd.master_of_arts_app.contreater.NoticeContreanter;
import com.wd.master_of_arts_app.preanter.NoticePreanter;

import java.util.List;

import butterknife.OnClick;

/**
 * 通知
 */
public class NoticeActivity extends BaseActivity implements NoticeContreanter.IVew {

    private RecyclerView rv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_notice2;
    }

    @Override
    protected BasePreantert initModel() {
        return new NoticePreanter(this);
    }

    @Override
    protected void initView() {
        rv = findViewById(R.id.notice_xrv);
    }

    @Override
    protected void initData() {
        SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
        String token = sp.getString("token", "");
        if(!token.isEmpty()){
            BasePreantert basePreantert = getmPreantert();
            if (basePreantert instanceof NoticeContreanter.IPreanter) {

                ((NoticeContreanter.IPreanter) basePreantert).NoticeViewSuccess(token);
            }
        }else{
            Intent intent = new Intent(getApplicationContext(),Verification_code_login.class);
            startActivity(intent);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(linearLayoutManager);
    }

    @OnClick(R.id.img_return)
    public void OnClick() {
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    @Override
    public void OnNoticeView(NoticeBean noticeBean) {
        NoticeBean.DataBeanX data = noticeBean.getData();
        NoticeBean.DataBeanX.ListBean list = data.getList();
        List<NoticeBean.DataBeanX.ListBean.DataBean> data1 = list.getData();
        NoticeAdapter noticeAdapter = new NoticeAdapter(getApplicationContext(), data1);
        noticeAdapter.OnSetItem(new NoticeAdapter.OnClick() {
            @Override
            public void OnClick(int id) {
                Intent intent = new Intent(getApplicationContext(),NoticeDetails.class);
                intent.putExtra("noticeId",id);
                startActivity(intent);
            }
        });
        rv.setAdapter(noticeAdapter);
    }

    @Override
    public void OnNoticeBean(NoticeDetailsBean noticeDetailsBean) {

    }

    @Override
    public void OnNoticeNumber(NoticeNumBer noticeNumBer) {

    }
}
