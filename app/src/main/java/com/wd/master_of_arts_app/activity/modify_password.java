package com.wd.master_of_arts_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.BaseActivity;
import com.wd.master_of_arts_app.base.BasePreantert;

import butterknife.OnClick;

public class modify_password extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_modify_password;
    }

    @Override
    protected BasePreantert initModel() {
        return null;
    }
    @OnClick(R.id.oncDestruction)
    public void onDestrution(){
        finish();
    }
    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
