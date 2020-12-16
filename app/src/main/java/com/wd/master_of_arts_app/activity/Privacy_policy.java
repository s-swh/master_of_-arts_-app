package com.wd.master_of_arts_app.activity;

import android.widget.TextView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

import butterknife.OnClick;

public class Privacy_policy extends BaseActivity {


    private TextView til,lable,conut;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_privacy_policy;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }
    @OnClick(R.id.oncDestruction)
    public void onDestrution() {
        finish();
    }
    @Override
    protected void initView() {
        til = findViewById(R.id.titbt);
        lable = findViewById(R.id.lable);
        conut = findViewById(R.id.conut);

    }

    @Override
    protected void initData() {

    }

}
