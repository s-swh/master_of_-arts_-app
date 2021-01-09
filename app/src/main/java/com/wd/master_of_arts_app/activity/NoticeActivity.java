package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;
import com.wd.master_of_arts_app.bean.NoticeBean;
import com.wd.master_of_arts_app.contreater.NoticeContreanter;

public class NoticeActivity extends BaseActivity implements NoticeContreanter.IVew {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice2);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void OnNoticeView(NoticeBean noticeBean) {

    }
}
